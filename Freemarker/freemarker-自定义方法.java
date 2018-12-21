----------------------------
��ǩʵ��					|
----------------------------
	# �﷨
		<#function name param1 param2 ... paramN>
		  ...
		  <#return returnValue>
		  ...
		</#function>
		
		* name ��������
		* ���Զ���������
		* paramN,���һ������, ���Կ�ѡ�İ���һ��β��ʡ��(...)�����ζ�ź���ܿɱ�Ĳ�������,�ֲ����� paramN ���Ƕ������������(��ɲ���)
		* ����������Ĭ��ֵ,���Ǳ���������ͨ�����ĺ���
		* return ָ���Ǳ����
		* �����ڵ�����������ᱻ����
	
	# Demo
		<#function foo v1 v2 v3...>
			<#local x = v1 + v2>
			<#list v3 as i>
				<#local x = i + x>
			</#list>
			<#return x>
		</#function>

		${foo(1,2,3,4,5)}		//15


----------------------------
����ʵ��					|
----------------------------
	# ʵ�ֽӿ�: TemplateMethodModelEx 
		import java.util.List;

		import freemarker.core.Environment;
		import freemarker.template.TemplateMethodModelEx;
		import freemarker.template.TemplateModelException;

		public class FooFunction implements TemplateMethodModelEx{

			public FooFunction() {
				System.out.println("new");
			}
			
			//arguments ���Ǵ��ݽ����Ĳ���
			@SuppressWarnings("rawtypes")
			@Override
			public Object exec(List arguments) throws TemplateModelException {
				//��ȡ��ǰ���л���
				Environment environment = Environment.getCurrentEnvironment();
				System.out.println(environment);
				return "result";
			}
		}

	
	# �Ѹ�ʵ����ģ������,��Ϊһ����������
		* configuration.setSharedVariable("fooFunc", new FooFunction());
		* ��������Ϊ�������,�Ե�����ʽ����
	
	# ��ģ��������ʹ��
		${fooFunc("123456")}
	



