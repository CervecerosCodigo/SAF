<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> <!-- brukes for å hente lengde til arraylist -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Project</title>
</head>
<body>

<div id="overfyll"></div>

<div id="container">
	<div id="nav">

			<a href="${pageContext.request.contextPath}/">Home</a> 
			<a href="${pageContext.request.contextPath}/displayUserRegistration">Register</a>
			<a href="${pageContext.request.contextPath}/showItems">Products</a>

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="${pageContext.request.contextPath}/showCustomers">Show	Customers</a> 
				<a href="${pageContext.request.contextPath}/newitem">New item</a>
			</sec:authorize>
			
			
			<sec:authorize access="!isAuthenticated()">
				<a href="${pageContext.request.contextPath}/signin">Login</a>
			</sec:authorize>
			
			
			
			<sec:authorize access="isAuthenticated()"> 
			<sec:authentication property="principal.username" var="uid" />
				<form id="logoutform" action="<c:url value="/logout" />" method="post">
					<a href="javascript:{}" onclick="document.getElementById('logoutform').submit();">Log out</a>
					<br><a style="font-weight: lighter;" href="${pageContext.request.contextPath}/showaccount">My Account</a>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</sec:authorize>		
			
			<sec:authorize access="isAuthenticated()">

				<!-- Hello ${username} -->
				<%-- 
				<c:out value="${cart.sillyName}"></c:out>
				<c:out value="${cart.cartId}"></c:out> --%>

			</sec:authorize>			

	</div>
	
<div id="content">