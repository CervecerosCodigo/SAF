<%@include file="head.jsp"%>

	<h2>Please fill in the form to register your user account</h2>
	<sf:form method="post" action="${pageContext.request.contextPath}/registercustomer" commandName="customer">
		<table class="formtable">
			<tr>
				<td class="label">First name:</td>
				<td><sf:input class="control" path="firstname" name="firstname" type="text"/><br><sf:errors path="firstname" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Last name:</td>
				<td><sf:input class="control" path="lastname" name="lastname" type="text"/><br><sf:errors path="lastname" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Address 1:</td>
				<td><sf:input class="control" path="address1" name="address1" type="text"/><br><sf:errors path="address1" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Address 2:</td>
				<td><sf:input class="control" path="address2" name="address2" type="text"/><br><sf:errors path="address2" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Post code:</td>
				<td><sf:input class="control" path="post.postNumber" name="post" type="text"/><br><sf:errors path="post.postNumber" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Post address:</td>
				<td><sf:input class="control" path="post.postAddress" name="post" type="text"/><br><sf:errors path="post.postAddress" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td><sf:input class="control" path="phone" name="phone" type="text"/><br><sf:errors path="phone" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" path="email" name="email" type="text"/><br><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input class="control" path="password" name="password" type="password"/><br><sf:errors path="password" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
			<td class="label"></td>
			<td><input class="control" name="Register" type="submit"/></td>
			</tr>
		</table>
		<div class="error">
			<c:if test="${exists != null}"> 
				<c:out value="${exists}"></c:out>
			</c:if>  
		</div>
	</sf:form>


<%@include file="footer.jsp"%>