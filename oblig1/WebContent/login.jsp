<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<h2>Log in here!</h2>
<form id="login" action="/oblig1/Controller" method="post">
	
	<input type="hidden" name="action" value="logginrequest" />
	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="username"/></td>
			<td></td>
		</tr>
		<tr>
		</tr>
			<td>Password</td>
			<td><input type="password" name="password"/></td>
			<td><input type="submit" value="Login"/></td>
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