-------------------------
HttpClient
-------------------------
	# ������

	# ��̬����
		 public static HttpClient newHttpClient()
		 public static Builder newBuilder()
	
	# ���󷽷�
		Optional<CookieHandler> cookieHandler()
		abstract Optional<Duration> connectTimeout()
		abstract Redirect followRedirects()
			* �ض������ö��
				NEVER
					* ��ԶҲ���ض���

				ALWAYS
					* �����Զ��ض���

				NORMAL
					* ���˴�HTTPS�ض���HTTP����, �����Զ��ض���


		abstract Optional<ProxySelector> proxy()
		abstract SSLContext sslContext()
		abstract SSLParameters sslParameters()
		abstract Optional<Authenticator> authenticator()
		abstract HttpClient.Version version()
			* ö��HTTP�汾
				HTTP_1_1
				HTTP_2

		abstract Optional<Executor> executor()
		abstract <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler)
		abstract <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> responseBodyHandler)
		abstract <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> responseBodyHandler, PushPromiseHandler<T> pushPromiseHandler)
	
	# ʵ������
		WebSocket.Builder newWebSocketBuilder()