----------------------------
Spring boot-�쳣����1		|
----------------------------
	# ʹ�� Spring Boot �ṩ�Ĵ�����
	# ���Դ��� 404,500���쳣
	1,�Զ��쳣���� Controller ,ʵ�ֽӿ�: org.springframework.boot.autoconfigure.web.ErrorController.ErrorController
	2,��д����
		
		@Controller
		public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

			private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

			/**
			 * ����ҳ���Ŀ¼/·��
			 * classpatg:/templates/error/error.html
			 */
			private static final String ERROR_PATH = "error";

			/**
			 * �쳣��ʱ��,ϵͳ���Զ���ת�����·��,���һ��� request ���д�źܶ�����쳣����Ϣ
			 * ���Ը����쳣״̬�����ж���ʲô�쳣
			 * Ҳ���Ը�����������(ajax)�����Ƿ���ModelAndView����ֱ����ӦAjax����
			 * @param modelAndView
			 * @param request
			 * @param response
			 * @return
			 */
			@RequestMapping(value = ERROR_PATH,method = RequestMethod.GET)
			public ModelAndView error(ModelAndView modelAndView,
									  HttpServletRequest request,
									  HttpServletResponse response){
				Class exceptionType = (Class) request.getAttribute("javax.servlet.error.exception_type");   //�쳣����
				Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");    //�쳣��,ֻ���� 500 �쳣�������,��ֵ��Ϊ��
				Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");     //HTTP�쳣״̬��
				String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");     //�쳣��Servlet
				String erroPath = (String) request.getAttribute("javax.servlet.error.request_uri");         //�������쳣�������ַ(�����ǵ�ǰ��ַ-request.getRequestURI())
				LOGGER.error("�������쳣, erroPath={}, message={}",erroPath,exception.getMessage());
				/**
				 * ��ֹ�����������·��������С�ף��Ƚٳֲ���ʾ�Լ��Ĵ���ҳ�棬ǿ�ƽ�code����Ϊ200
				 * ������ajax���޷�������״̬
				 */
				response.setStatus(HttpServletResponse.SC_OK);
				return new ModelAndView(ERROR_PATH + "/error");
			}

			/**
			 * �쳣��ʱ��,ϵͳ���Զ������������,��ȡ���쳣��·��.Ȼ��Ը�·��ִ������
			 * @return
			 */
			@Override
			public String getErrorPath() {
				return ERROR_PATH;
			}
		}

----------------------------
Spring boot-�쳣����2		|
----------------------------
	# ʹ�� Spring �ṩ�Ĵ�����
	# ����ֻ�ܴ���� 500 �������쳣,404 ֮��Ĳ��ᴦ��
	# ʵ�� HandlerExceptionResolver ע�ᵽIOC��ʵ��ȫ�ֵ��쳣����

		@Component
		public class ExceptionController implements HandlerExceptionResolver {

			private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
			
			/*
			 * ���Ը������������(Ajax)��ȷ���Ƿ���mv����ֱ����Ӧajax����
			 * ���ַ�ʽ,ֻ�ܴ�������������쳣,�޷����� 404 ֮����쳣
			 */
			@Override
			@ExceptionHandler
			public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
				HandlerMethod handlerMethod = (HandlerMethod) o;		//��handler����ǿת
				Method method = handlerMethod.getMethod();				//��ȡ�������쳣�ķ�������
				return new ModelAndView("error/error");
			}
		}
	

	# ����
	# ����ֻ�ܴ���� 500 �������쳣,404 ֮��Ĳ��ᴦ��
	# ��ʶ @ControllerAdvice ����Controllerע��,ע�ᵽIOC,��ʵ��ȫ���쳣�Ĵ���
		@ControllerAdvice
		public class ExceptionController {

			private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
			
			/*
			 * ���Ը������������(Ajax)��ȷ���Ƿ���mv����ֱ����Ӧajax����
			 * ���ַ�ʽ,ֻ�ܴ�������������쳣,�޷����� 404 ֮����쳣
			 */
			@ExceptionHandler
			public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
				HandlerMethod handlerMethod = (HandlerMethod) o;		//��handler����ǿת
				Method method = handlerMethod.getMethod();				//��ȡ�������쳣�ķ�������
				return new ModelAndView("error/error");
			}
		}


----------------------------
Spring boot-����ϲ����ʵ��  |
----------------------------
	# ��ͼ�����쳣,��Ӧ�쳣����ͼ��Ϣ
	# api�ӿ��쳣,��Ӧ�쳣��JSON/״̬����Ϣ
	
	# ����������쳣������
		import java.io.IOException;

		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		import org.springframework.http.HttpStatus;
		import org.springframework.http.converter.HttpMessageNotReadableException;
		import org.springframework.validation.BindException;
		import org.springframework.web.HttpMediaTypeNotSupportedException;
		import org.springframework.web.HttpRequestMethodNotSupportedException;
		import org.springframework.web.bind.MissingServletRequestParameterException;
		import org.springframework.web.bind.ServletRequestBindingException;
		import org.springframework.web.bind.annotation.ExceptionHandler;
		import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
		import org.springframework.web.multipart.MaxUploadSizeExceededException;
		import org.springframework.web.servlet.NoHandlerFoundException;

		import io.javaweb.paste.common.Message;
		import io.javaweb.paste.exception.ServiceException;


		public abstract class BaseExceptionAdvice {
			
			//����·��δ�ҵ�
			@ExceptionHandler(NoHandlerFoundException.class)  
			public Object noHandlerFoundException(HttpServletRequest request,HttpServletResponse response,NoHandlerFoundException e) throws IOException {
				return this.errorHandler(request,response,Message.fail(HttpStatus.NOT_FOUND, "����·��������"),e);
			}
			
			//�ϴ��ļ�����
			@ExceptionHandler(value = {MaxUploadSizeExceededException.class})
			public Object maxUploadSizeExceededException(HttpServletRequest request,HttpServletResponse response,MaxUploadSizeExceededException e) throws IOException {
				return this.errorHandler(request,response,Message.fail(HttpStatus.BAD_REQUEST, "�ļ���С���ܳ���:" + e.getMaxUploadSize()),e);
			}
			
			//����ʽ��֧��
			@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
			public Object httpRequestMethodNotSupportedException(HttpServletRequest request,
											HttpServletResponse response,
											HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
				return this.errorHandler(request, response, Message.fail(HttpStatus.METHOD_NOT_ALLOWED, "����ʽ��֧��"),httpRequestMethodNotSupportedException);
			}
			
			//ȱ�ٱ������
			@ExceptionHandler(MissingServletRequestParameterException.class)
			public Object missingServletRequestParameterException(HttpServletRequest request,
																		HttpServletResponse response,
																		MissingServletRequestParameterException exception) {
				return this.errorHandler(request,response,Message.fail(HttpStatus.BAD_REQUEST, "ȱ�ٱ������:" + exception.getParameterName()),exception);
			}
			
			//ҵ���쳣
			@ExceptionHandler(ServiceException.class)
			public Object businessException(HttpServletRequest request,
													HttpServletResponse response,
													ServiceException exception) {
				return this.errorHandler(request, response, exception.message(),exception);
			}
			
			//ϵͳ�쳣
			@ExceptionHandler(Exception.class)
			public Object exception(HttpServletRequest httpServletRequest,
											HttpServletResponse httpServletResponse,
											Exception exception) {
				return this.errorHandler(httpServletRequest, httpServletResponse, Message.fail(HttpStatus.INTERNAL_SERVER_ERROR, "ϵͳ�쳣"),exception);
			}
			
			
			//�Ƿ�����
			@ExceptionHandler(value = {
				HttpMessageNotReadableException.class,
				IllegalArgumentException.class,
				MethodArgumentTypeMismatchException.class,
				BindException.class,
				HttpMediaTypeNotSupportedException.class,
				ServletRequestBindingException.class
			})
			public Object  badRequestException(HttpServletRequest request,HttpServletResponse response,Exception e) throws IOException {
				e.printStackTrace();
				return this.errorHandler(request,response,Message.fail(HttpStatus.BAD_REQUEST, "�Ƿ�����"),e);
			} 
			
			
			abstract public Object errorHandler(HttpServletRequest request,HttpServletResponse response,Message<Void> message,Throwable throwable); 
		}
	
	# api�쳣
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		import org.springframework.http.ResponseEntity;
		import org.springframework.web.bind.annotation.ControllerAdvice;
		import org.springframework.web.bind.annotation.RestController;

		import io.javaweb.paste.common.Message;

		@ControllerAdvice(annotations = {RestController.class})		// ֻ����restController
		public class RestExceptionAdvice extends BaseExceptionAdvice {

			@Override
			public ResponseEntity<String> errorHandler(HttpServletRequest request, HttpServletResponse response, Message<Void> message,Throwable throwable) {
				throwable.printStackTrace();
				return ResponseEntity.status(message.getStatus()).build();
			}

		}

	# ��ͼ�쳣
		
		import java.io.PrintWriter;

		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		import org.springframework.stereotype.Controller;
		import org.springframework.web.bind.annotation.ControllerAdvice;
		import org.springframework.web.servlet.ModelAndView;

		import io.javaweb.paste.common.Message;
		import io.javaweb.paste.common.StringBuilderWriter;

		@ControllerAdvice(annotations = {Controller.class})		// ֻ����Controller
		public class ExceptionAdvice extends BaseExceptionAdvice {

			public static final String ERROR_PATH = "error/error";
			
			@Override
			public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Message<Void> message,Throwable throwable) {
				
				ModelAndView modelAndView = new ModelAndView(ERROR_PATH);
				
				modelAndView.addObject("message", message);
				
				StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
				
				PrintWriter printWrite = new PrintWriter(stringBuilderWriter);
				
				throwable.printStackTrace(printWrite);
				
				modelAndView.addObject("throwable", stringBuilderWriter.toString());
				
				return modelAndView;
			}
		}

		