---------------------
POST				 |
---------------------
	String post(String url, String json) throws IOException {

		MediaType JSON = MediaType.parse("application/json; charset=utf-8");

		OkHttpClient client = new OkHttpClient();

		// json������
		RequestBody body = RequestBody.create(JSON, json);

		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}


---------------------
�����ļ�����		 |
---------------------
	OkHttpClient client = new OkHttpClient();

	// �ļ�����
	File file = new File("");
	RequestBody requestBody = new MultipartBody.Builder()
		.setType(MultipartBody.FORM)
		.addFormDataPart("file",file.getName(), RequestBody.create(MediaType.parse("image/png"), file))
		.addFormDataPart("name", "KevinBlandy")
		.build();

	Request request = new Request.Builder().url("").post(requestBody).build();
	Response response = client.newCall(request).execute();
	response.body().string();


---------------------
������ͨ����		 |
---------------------
	RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{}");
	RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), "name=KevinBlandy");