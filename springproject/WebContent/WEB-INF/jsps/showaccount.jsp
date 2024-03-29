
<%@include file="head.jsp"%>
	
<h2>Displaying your account,  <c:out value="${customer.firstname}"/> <c:out value="${customer.lastname}"/></h2>

<sec:authorize access="hasRole('ROLE_USER')">	

	<sf:form method="post" action="${pageContext.request.contextPath}/editaccount" commandName="customer">

	<table class="formtable">
			<sf:input type="text" path="idCustomer" name="idCustomer" hidden="true" />
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
	<br/>
	<br/>
	<hr>
	<c:if test="${fn:length(customer.orders) gt 0}">
		<h3>Your order history</h3>
		<hr>
		<table id="orderHistory" class="table">
			<tr>
				<th>Order ID</th>
				<th>Order Date</th>
				<th>Number of items</th>
				<th>Total cost</th>
			</tr>
			<c:forEach var="order" items="${customer.orders}">
				<tr class="cellUnderline">
					<td class="produktText"><c:out value="${order.idOrder}"></c:out></td>
					<td class="produktText"><fmt:formatDate value="${order.orderDate}"/></td>
					<td class="produktText"><c:out value="${fn:length(order.orderLines)}"></c:out> </td>
					<td class="produktText">
						<c:set var="sum" value="${0}"/>
						<c:forEach step="1" var="line" items="${order.orderLines}"> 
							<c:set var="sum" value="${sum + line.priceUnit}"/>
						</c:forEach>
						
						<fmt:formatNumber value='${sum}' groupingUsed='true' /> 
					</td>
				</tr>
			
			</c:forEach>
		</table>
	</c:if>
</sec:authorize>



		
<%@include file="footer.jsp"%>
