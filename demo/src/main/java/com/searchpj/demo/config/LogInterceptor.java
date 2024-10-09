package com.searchpj.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogInterceptor{
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	// Controller의 메서드가 실행된 후에 실행
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// System.out.println(handler.toString() + " 가 종료되었습니다.  " + modelAndView.getViewName() + "을 view로 사용합니다.");
//		logger.debug("{} 가종료되었습니다. {} 를 view로 사용합니다.", handler.toString(), modelAndView.getViewName());
//	}
//
//	// Controller의 메서드가 실행되기 전에 실행
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// System.out.println(handler.toString() + " 를 호출했습니다.");
//		logger.debug("{} 를 호출했습니다.", handler.toString());
//		return true;
//	}
}
