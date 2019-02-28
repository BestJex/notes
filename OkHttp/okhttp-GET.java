---------------------
Get					 |
---------------------
	String run(String url) throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

---------------------
�ļ�����			 |
---------------------
	OkHttpClient client = new OkHttpClient();
	Request request = new Request.Builder().url("http://localhost/1.mp4").build();
	Response response = client.newCall(request).execute();
	
	// ����Ӧ��ȡ��InputStream
	BufferedInputStream bufferedInputStream = new BufferedInputStream(response.body().byteStream());
	
	// io������
	BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\�ݽ�.mp4")));
	byte[] data = new byte[1024];
	int len;
	while((len = bufferedInputStream.read(data)) != -1) {
		bufferedOutputStream.write(data,0,len);
		bufferedOutputStream.flush();
	}
	bufferedOutputStream.close();