package com.ilemontech.ldcos.system.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ilemontech.ldcos.system.entity.User;

public class SessionUtils {

	public static User getUser(HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute(CommonConstants.SESSION_NAME);
			return user;
		} catch (Exception e) {

		}
		return null;
	}
	
	public static String getUserName(HttpServletRequest request){
		User user=getUser(request);
		if(user==null){
			return null;
		}
		return user.getUsername();
	}

	public static boolean isLogin(HttpServletRequest request) {
		if (request.getSession().getAttribute(CommonConstants.SESSION_NAME) != null) {
			return true;
		} else {
			return false;
		}
	}

	public static void login(User user, HttpServletRequest request) {
		request.getSession().setAttribute(CommonConstants.SESSION_NAME, user);
		request.getSession().setAttribute("username", user.getUsername());
	}
	
	public static void logout(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		session.invalidate();	
	}

	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	public static String getRequestURLContent(HttpServletRequest request, int index) {
		String requestURI = getRelativePath(request);
		// 去掉后缀 和 最前面的"/"
		requestURI = requestURI.substring(1, requestURI.lastIndexOf("."));
		String[] strs = requestURI.split("/");
		if (strs.length > index) {
			return strs[index];
		} else {
			return "";
		}
	}

	private static String getRelativePath(HttpServletRequest request) {
		String requestURI = request.getRequestURI().toLowerCase();
		requestURI = requestURI.substring(request.getContextPath().length(), requestURI.length());
		return requestURI;
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		String isAjax = request.getHeader("_isAjax");
		return (requestType != null && requestType.equals("XMLHttpRequest")) || Boolean.parseBoolean(isAjax);
	}
	
	public static Map<String,String> getParams(HttpServletRequest request){
		Map<String,String> params=new HashMap<String,String>();
		Enumeration<String> names=request.getParameterNames();
		
		while(names.hasMoreElements()){
			String name=names.nextElement();
			params.put(name, request.getParameter(name));
		}
		return params;
	}
}
