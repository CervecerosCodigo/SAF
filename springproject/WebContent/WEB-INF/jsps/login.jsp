
<%@include file="head.jsp"%>

<div id="container" onload='document.f.j_username.focus();'>

	<h3>Login with Username - Custom page</h3>

	<form name='f' action="<c:url value='/signin' />"	method='POST'>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>

	<%@include file="footer.jsp"%>