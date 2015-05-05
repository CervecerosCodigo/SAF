<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Project</title>
</head>
<body>

<div id="nav">
	<span class="menuitem">
		<a href="${pageContext.request.contextPath}/">Home</a>
		<a href="${pageContext.request.contextPath}/displayRegistration">Register</a>
		<a href="${pageContext.request.contextPath}/showcustomers">Show Customers</a>
		<a href="${pageContext.request.contextPath}/registeritem">Register new item</a>
	</span>
</div>