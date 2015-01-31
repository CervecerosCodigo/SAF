<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Withdraw money</title>
</head>
<body>

<h2>Withdraw your money here!</h2>

<%
if(request.getSession().getAttribute("validated") == null){
	response.sendRedirect("./login.jsp");
}
%>


<form id="withdrawal" action="/oblig1/Controller" method="post">
	<input type="hidden" name="action" value="loggedin" />
	<table>
		<tr>
			<td>From account number:</td>
			<td><input type="text" name="fromaccount"/></td>
			<td></td>
		</tr>
		<tr>
		<tr>
			<td>To account number:</td>
			<td><input type="text" name="toaccount"/></td>
			<td></td>
		</tr>		
		</tr>
			<td>Amount:</td>
			<td><input type="text" name="amount"/></td>
			<td><input type="submit" value="Transfer"/></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
</form>

</body>
</html>