//package com.model2.mvc.common.web;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import domain.Festival;
//
//public class LogonCheckInterceptor extends HandlerInterceptorAdapter {
//	
//	public LogonCheckInterceptor(){
//		System.out.println("\nCommon :: "+this.getClass()+"\n");		
//	}
//	
//	public boolean preHandle(	HttpServletRequest request,
//														HttpServletResponse response, 
//														Object handler) throws Exception {
//		
//		System.out.println("\n[ LogonCheckInterceptor start........]");
//		
//		//==> �α��� ����Ȯ��
//		HttpSession session = request.getSession(true);
//		Festival festival = (Festival)session.getAttribute("festival");
//
//		if(   festival != null   )  {
//			String uri = request.getRequestURI();
//			
//			if(		uri.indexOf("addUser") != -1 ||	uri.indexOf("login") != -1 		|| 
//					uri.indexOf("checkDuplication") != -1 ){
//				request.getRequestDispatcher("/index.jsp").forward(request, response);
//				System.out.println("[ �α��� ����.. �α��� �� ���ʿ� �� �䱸.... ]");
//				System.out.println("[ LogonCheckInterceptor end........]\n");
//				return false;
//			}
//			
//			System.out.println("[ �α��� ���� ... ]");
//			System.out.println("[ LogonCheckInterceptor end........]\n");
//			return true;
//		}else{ //==> �� �α����� ȭ���̶��...
//			//==> �α��� �õ� ��.....
//			String uri = request.getRequestURI();
//			
//			if(		uri.indexOf("addUser") != -1 ||	uri.indexOf("login") != -1 		|| 
//					uri.indexOf("checkDuplication") != -1 ){
//				System.out.println("[ �α� �õ� ���� .... ]");
//				System.out.println("[ LogonCheckInterceptor end........]\n");
//				return true;
//			}
//			
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//			System.out.println("[ �α��� ���� ... ]");
//			System.out.println("[ LogonCheckInterceptor end........]\n");
//			return false;
//		}
//	}
//}//end of class