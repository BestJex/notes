---------------------
stage				 |
---------------------
	# �̳��� Window ���

	# ���캯��
		Stage()
		Stage(@Default("javafx.stage.StageStyle.DECORATED") StageStyle style)
	
	# ʵ������
		void setAlwaysOnTop(boolean value)
		ReadOnlyBooleanProperty alwaysOnTopProperty()
		void close()
			* �رմ���

		ObjectProperty<String> fullScreenExitHintProperty()
		ObjectProperty<KeyCombination> fullScreenExitKeyProperty()
		ReadOnlyBooleanProperty fullScreenProperty()
		String getFullScreenExitHint()
		KeyCombination getFullScreenExitKeyCombination()
		double getMaxHeight()
		double getMaxWidth()
		double getMinHeight()
		double getMinWidth()
		Modality getModality()
		Window getOwner()
		StageStyle getStyle()
		
		void initModality(Modality modality)
		void initOwner(Window owner)
		void initStyle(StageStyle style)
		boolean isAlwaysOnTop()
		boolean isMaximized()
		
		DoubleProperty maxHeightProperty()
		ReadOnlyBooleanProperty maximizedProperty()
		DoubleProperty maxWidthProperty()
		DoubleProperty minHeightProperty()
		DoubleProperty minWidthProperty()
		BooleanProperty resizableProperty()
		void setAlwaysOnTop(boolean value)
		void setFullScreenExitHint(String value)
		void setFullScreenExitKeyCombination(KeyCombination keyCombination)
		
		void setFullScreen(boolean value)
		boolean isFullScreen()
			* ����/��ȡ�Ƿ�ȫ��,(��ESC�Ż��˳�����)
			* ��Ҫ�������� Scene �Ż���Ч
		
		void setMaximized(boolean value)
			* �����Ƿ������(ȫ��)
		
		void setMaxHeight(double value)
		void setMaxWidth(double value)
		void setMinHeight(double value)
		void setMinWidth(double value)
			* ����/��ȡ�����С�Ŀ��

		void setResizable(boolean value)
		boolean isResizable()
			* ����/��ȡ�Ƿ���������

		void setScene(Scene value)

		String getTitle()
		void setTitle(String value)
			* ����/��ȡ����
		
		ObservableList<Image> getIcons()
		ReadOnlyBooleanProperty iconifiedProperty()
		void setIconified(boolean value)
		boolean isIconified()
			* icon������


		void show()
		void showAndWait()
		StringProperty titleProperty()
		void toBack()
		void toFront() 