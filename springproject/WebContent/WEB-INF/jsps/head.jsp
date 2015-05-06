<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
			<a href="${pageContext.request.contextPath}/displayUserRegistration">Register</a>
			<a href="${pageContext.request.contextPath}/showItems">Products</a>

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="${pageContext.request.contextPath}/showCustomers">Show	Customers</a> 
				<a href="${pageContext.request.contextPath}/registerItem">New item</a>
			</sec:authorize>
			
			
			<sec:authorize access="!isAuthenticated()">
				<a href="${pageContext.request.contextPath}/signin">Login</a>
			</sec:authorize>
			
			
			
			<sec:authorize access="isAuthenticated()"> 
			<sec:authentication property="principal.username" var="username" />
				<form id="logoutform" action="<c:url value="/logout" />" method="post">
					<a href="javascript:{}" onclick="document.getElementById('logoutform').submit();">Log out</a>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</sec:authorize>		
			
			<sec:authorize access="isAuthenticated()">
				Hello ${username}
			</sec:authorize>			
		</span>
	</div>