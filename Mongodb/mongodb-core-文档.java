--------------------------------
�ĵ�							|
--------------------------------
	# �ĵ���key�����ַ���

	# �ĵ��в����ظ����Ƶ� key

	# �ĵ�����Ҫ��һ�� _id ����
		* ������ֵ�������κ���������,���û������,��ôϵͳ���Զ�����,Ĭ��ֵ�� ObjectId ����
		* ÿ��������,�ĵ���	_id �����ظ�

	# �����ĵ������ֵΪ: 54122 kb 
		* ����ͨ��Object��bsonsize�����鿴db���ĵ���СԼ��

		Object.bsonsize(db.doc);

--------------------------------
��������						|
--------------------------------
	db.[colelction].insert([document])
		* ��ָ����colelction����һ�����߶�����¼
		* ����Ƕ�����¼,��ô����Ӧ����һ�������˶��document������
		* ����ü��ϲ��ڸ����ݿ���, MongoDB ���Զ������ü��ϲ������ĵ�
	
	db.[colelction].insertOne([document]) 
		* ����һ����¼,������һ��document
	
	db.[colelction].insertMany([document...]) 
		* ���������¼,������һ��document����
			db.collection.insertMany([{"b": 3}, {'c': 4}])
		
		* ������е�һ���ĵ�����ʧ��(_id�ظ�֮����쳣),��ô�Ӹ��쳣�ĵ�,�����Ժ���ĵ��������ʧ��
		* ��������������Ϣ���Ĭ��Ϊ 48MB,���������ֵ,����и�Ϊ��� 48MB����Ϣ����������
	


	db.[colelction].save([document]) 
		* �����ָ�� _id �ֶ� save() ���������� insert() ����
		* ���ָ�� _id �ֶ�,�����¸� _id �����ݶ����ǲ���
	

	db.[colelction].find()
		* �鿴ָ��collection���Ѳ����ĵ�
	
	db.[colelction].findOne()
		* �鿴ָ��collection���Ѳ����ĵ�
		* ��������һ�����
	
	db.[colelction].remove([document]);
		* ɾ����¼,ʹ��һ���ĵ�������Ϊ����,����ɾ�����������ļ�¼
		* �����һ���ն���({}),��ɾ�����еļ�¼
		* ����ɾ��������
			{ "nRemoved" : 2 }
		* ɾ������������,ǧ��Ҫ����

--------------------------------
����							|
--------------------------------
	
	# ���µĺ���,��Ҫ��������Ĳ���,�Լ�һ���Ǳ���� config ������
		* һ���Ǹ�����˵�����,�������һ���ն���,��ʾƥ�������ĵ�
		* һ����Ҫ���µĲ���,�᳹���滻�����������ļ�¼(�����Ǹ��·ǿյ��ֶ�)

		db.[colelction].update([query], [update],   {
			upsert: true,
			multi: false,
			writeConcern: <document>
		})
	
		query
			* update�Ĳ�ѯ����,����sql update��ѯ��where�����
		
		update
			* update�Ķ����һЩ���µĲ�����(��$,$inc...)��,Ҳ�������Ϊsql update��ѯ�ں����SET
		
		* config������ѡ��
			upsert
				* ��ѡ,�����������˼��,���������update�ļ�¼,�Ƿ����objNew,true Ϊ����
				* Ĭ���� false ������
			
			multi
				* �������·��������ĵ�һ��,���Ǹ�������
				* ������� true,ֻ�������޸��� $ �޸Ĳ�����
			
			writeConcern
				* �׳��쳣�ļ���
		
		* ���²�����һ��ԭ�Ӳ���,����ִ�и��µ�ʱ��,˭�������ȵ���,˭����ִ��,����ĸ��»Ḳ��ǰ��ĸ���
	
		
	# �޸���,modifter
		* ͨ���ĵ�ֻ��һ���ֻ����(�����Ǹ������е��ֶ�)
		* �޸�������ʵ����һϵ�е�ָ��,ʹ�� $ ��ͷ
		* ָ��ı��ʽ,�󶼿���ʹ�ö��󵼺��ķ�ʽ���ж�,���߲���
			* ���󵼺�
				{'sub':{'name':'KevinBlandy'}}			sub.name

			* ���鵼��(ʹ���±�)
				{'sub':[{'name':'KevinBlandy'}]}		sub.0.name

		$set
			* ��������һ���ֶε�ֵ,������ֶβ�����,�򴴽�
			* ���������޸�value����������,ԭʼ���������ַ���,���Ա��޸�Ϊ[],{}.....
				db.users.update({'id':'1'},{
						'$set':{
							'name':'new New',			// ����name����
							'foo':'new field'			// ����foo����
						}
					},{
						multi:true						// �޸Ķ���
				});
			
			* ��֧��ʹ�ö��󵼺�����ʽȥ�޸ļ�¼
				db.users.insert({
					'id':1,
					'name':'KevinBlandy',
					'skill':{
						'foo':'foo',
						'bar':'bar'
					}
				});

				db.users.update({'id':1},{
					'$set':{
						'skill.foo': 'New Foo Value' // �޸��ĵ��� skill����ֵ��foo����ֵ
					}
				});
		
		$unset
			* ������ɾ���ĵ���field
				db.users.update({'id':'1'},{
						'$unset':{
							'foo': 1			// ɾ�������ĵ��� foo ����
						}
					},{
						multi:true
				});

		
		$inc
			* ����ֵ���Խ��мӼ�,�����¼������,��ᴴ��(ֵ�ͻ�����ΪҪ�޸ĵ�ֵ)
			* ��ֻ������ ��ֵ ���͵��ֶ���,������������������ͻ����ʧ��
			* ��ָ���ֵҲֻ������ֵ,������������
				db.users.insert({
					'id':2,
					'number':1,
				});

				db.users.update({'id':2,},{
					'$inc':{
						'number': 1		// ���ĵ���number���� + 1
					}
				});
		
		$push
			* �����޸���,�������������� push Ԫ��
			* �������field������,���´���,��push
				db.users.insert({
					'id':3,
					'skills':['Java','Python'],
				});

				db.users.update({'id':3,},{
					'$push':{
						'skills': 'Javascript'
					}
				});
			* ��ָ��һ����,ֻ��pushһ����¼,������value������,�����������鵱��һ��value push���ĵ���Ŀ������ֵ��������
			* �����Ҫһ���Բ�����Ԫ��,������� $each ָ��
					db.users.update({'id':3,},{
						'$push':{
							'skills':{
								'$each':['Javascript', 'Ruby', 'C++']		// ʹ�� each ָ��,�� skills����push���Ԫ��
							}
						}
					});
		
			* ����ʹ�� $slice �����ĵ������ֶεĳ���
			* $slice ������һ��������,��ʾ�����������ļ�������
				db.users.update({'id':3,},{
					'$push':{
						'skills':{
							'$each':['Javascript', 'Ruby', 'C++'],		// ����3��Ԫ��
							'$slice': -2							// ���������������,����, skills �ֶ����Ľ������ ['Ruby', 'C++']
						}
					}
				});
			
			* ����ʹ�� $ort �������,��� $sliceָ��,�Ϳ��Զ�����������,�����Ƴ���
				db.users.update({'id':3,},{
					'$push':{
						'skills':{
							'$each':['Javascript', 'Ruby', 'C++'],
							'$slice': -1,							// ������������һ��Ԫ��
							'$sort':{'rating': -1}					// �Ȱ���������Խ�������
						}
					}
				});


		$ne
			* ��ָ������ж�ָ����Ԫ��,�Ƿ���ָ���������д���
			* ���ʺϷ���updateָ��Ĺ�������������
				db.users.insertMany([{
					'skills':['Java','Python'],
				},{
					'skills':['Java','Ruby'],
				}]);

				db.users.update({'skills':{
						'$ne':'Ruby'				//��������: Ruby��������skill�ֶ��е��ĵ�
					}},{
					'$push':{
						'skills':'Ruby'				// push Ruby �� skills�ֶ���
					}
				});
		
		$addToSet
			* ������[]����Setʹ�õ�ָ��
				db.users.update({},{
					'$addToSet':{
						'skills':'Ruby'		//����ĵ���skills���治����Ruby,��push,�������,�����κδ���
					}
				});
		
			* ��� $each ָ��,���� addSet ���ֵ
				db.users.update({},{
					'$addToSet':{
						'skills':{
							'$each':['Java','C++','Javascript']		// skills�ֶ��������������,�ͻ����,���ھ�ɶҲ����
						}
					}
				},{
					multi:true
				});

		
		$pop
			* ��ָ�����ڴ������е���һ��Ԫ��,�����Ǵ�ͷ,Ҳ���Դ�β
				db.users.update({},{
					'$pop':{
						'skills': -1		// -1 ��ʾ��ͷ��ʼɾ��(0), 1 ��ʾ��β����ʼɾ��(length - 1)
					}
				},{
					multi:true
				});

		$pull
			* ��ָ������ɾ�������е�ָ��Ԫ��
			* �����ƥ�䵽������Ԫ�ض�����������ɾ��
				db.users.update({},{
					'$pull':{
						'skills': 'Ruby'		// ɾ��skills�ֶ��е�RubyԪ��
					}
				},{
					multi:true
				});
		

								
		
		$
			* ��λ������,����ͨ����ָ���ҵ�����Ԫ����ƥ���Ԫ��
				db.users.insertMany([{
					'_id':1,
					'name':'KevinBlandy',
					'skills':[{
						'lang':'Java',
						'proficiency':10
					},{
						'lang':'Python',
						'proficiency':8
					},{
						'lang':'Javascript',
						'proficiency':8
					},{
						'lang':'C',
						'proficiency':5
					}],
				}]);

				db.users.update({'skills.lang':'C'},{		// (1)
					'$inc':{
						'skills.$.proficiency': 1			// (2)
					}
				},{
					multi:true
				});

				(1) �� 'skills' ����������,ƥ��� 'lang' ����ֵΪ 'C' ��Ԫ��,���Ҽ�¼�����±�Ϊ '$'
				(2) 'skills.$.proficiency', ��'skills'��������ָ��Ԫ�ص� 'proficiency' ֵ���м�1����, '$' ���������м��������±�
		

