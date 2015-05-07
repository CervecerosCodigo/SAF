
<%@include file="head.jsp"%>
	
<h2>Displaying you account,  <c:out value="${customer.firstname}"/> <c:out value="${customer.lastname}"/></h2>

<sec:authorize access="hasRole('ROLE_USER')">	

	<sf:form method="post" action="${pageContext.request.contextPath}/editaccount" commandName="customer">

	<table class="formtable">
			<tr>
				<td class="label">First name:</td>
				<td><sf:input class="control" path="firstname" name="firstname" id="firstname" type="text" readonly="true" /><br><sf:errors path="firstname" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Last name:</td>
				<td><sf:input class="control" path="lastname" name="lastname" id="lastname" type="text" readonly="true" /><br><sf:errors path="lastname" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Address 1:</td>
				<td><sf:input class="control" path="address1" name="address1" id="address1" type="text" readonly="true" /><br><sf:errors path="address1" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Address 2:</td>
				<td><sf:input class="control" path="address2" name="address2" id="address2" type="text" readonly="true" /><br><sf:errors path="address2" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Post code:</td>
				<td><sf:input class="control" path="post.postNumber" name="postNumber" id="postNumber" type="text" readonly="true" /><br><sf:errors path="post.postNumber" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Post address:</td>
				<td><sf:input class="control" path="post.postAddress" name="postAddress" id="postAddress" type="text" readonly="true" /><br><sf:errors path="post.postAddress" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td><sf:input class="control" path="phone" name="phone" id="phone" type="text" readonly="true" /><br><sf:errors path="phone" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" path="email" name="email" id="email" type="text" readonly="true" /><br><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input class="control" path="password" name="password" id="password" type="password" readonly="true" /><br><sf:errors path="password" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
			<td class="label"></td>
			<td><input class="control" name="Register" id="update_customer" type="submit" hidden="true" /></td>
			</tr>
		</table>
		<a href="javascript:void(0)" id="edit_link" onclick="enableEditCustomer()">Edit account</a>
		<a href="javascript:void(0)" id="cancel_edit_link" onclick="disableEditCustomer()" hidden="true">Cancel</a>

		<div class="error">
			<c:if test="${exists != null}"> 
				<c:out value="${exists}"></c:out>
			</c:if>  
		</div>
	</sf:form>		
</sec:authorize>


		
<%@include file="footer.jsp"%>
