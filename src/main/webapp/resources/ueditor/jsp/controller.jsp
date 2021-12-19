<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
    String str=	new ActionEnter( request, rootPath ).exec();
    String strPlaceHolder="image_prefix_placeholder_26796456";
    String path = str.replace(strPlaceHolder, request.getContextPath());
	out.write( path );
	
%>