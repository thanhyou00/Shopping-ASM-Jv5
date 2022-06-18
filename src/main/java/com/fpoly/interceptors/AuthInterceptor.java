//package com.fpoly.interceptors;
//
//import java.security.Principal;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.fpoly.entities.Account;
//import com.fpoly.repositories.AccountRepository;
//
//@Component
//public class AuthInterceptor implements HandlerInterceptor {
//	@Autowired
//	private AccountRepository accRepo;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		Principal principal = request.getUserPrincipal();
//		Account account = this.accRepo.findByEmailEquals(principal.getName());
//		if (account == null) {
//			response.sendRedirect("/login");
//			return false;
//		} else if (account.getAdmin() != 1) {
//			response.sendRedirect("/home");
//			return false;
//		}
//
//		return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//	}
//}
