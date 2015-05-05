
<%@include file="head.jsp"%>

<div id="container" onload='document.f.j_username.focus();'>

	<h3>Login with Username - Custom page</h3>

	<form name='f' action="<c:url value='login' />"	method='POST'>
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
    <c:if test="${param.error != null}">
        <div>
            Failed to login.
            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
              Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
            </c:if>
        </div>
    </c:if>
	<%@include file="footer.jsp"%>