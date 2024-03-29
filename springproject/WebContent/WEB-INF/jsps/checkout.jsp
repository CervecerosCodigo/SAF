<%@include file="head.jsp"%>


<!-- <h2>Please verify you account details</h2> -->


<h3>Shipping address</h3>
<sec:authorize access="hasRole('ROLE_USER')">
	<table class="formtable">
		<tr>
			<td class="label">First name:</td>
			<td><input class="control" type="text" name="fname"	value="<c:out value="${customer.firstname}"></c:out>" readonly="true"></td>
		</tr>
		<tr>
			<td class="label">Last name:</td>
			<td><input class="control" type="text" name="lname"	value="<c:out value="${customer.lastname}"></c:out>" readonly="true"></td>
		</tr>
		<tr>
			<td class="label">Address 1:</td>
			<td><input class="control" type="text" name="adr1" value="<c:out value="${customer.address1}"></c:out>" readonly="true"></td>
		</tr>
		<tr>
			<td class="label">Address 2:</td>
			<td><input class="control" type="text" name="adr2" value="<c:out value="${customer.address2}"></c:out>" readonly="true"></td>
		</tr>
		<tr>
			<td class="label">Post code:</td>
			<td><input class="control" type="text" name="zipcode" value="<c:out value="${customer.post.postNumber}"></c:out>" readonly="true"></td>
		</tr>
		<tr>
			<td class="label">Post address:</td>
			<td><input class="control" type="text" name="street" value="<c:out value="${customer.post.postAddress}"></c:out>" readonly="true"></td>
		</tr>
		<tr>
			<td class="label">Phone:</td>
			<td><input class="control" type="text" name="phone"	value="<c:out value="${customer.phone}"></c:out>" readonly="true"></td>
		</tr>
		<tr>
			<td class="label">Email:</td>
			<td><input class="control" type="text" name="email"	value="<c:out value="${customer.email}"></c:out>" readonly="true"></td>
		</tr>
	</table>
</sec:authorize>

<h3>Payment details</h3>
<div>
	<sf:form action="${pageContext.request.contextPath}/confirmingOrder" method="POST" id="payment-form">
		
		<table class="formtable">
			<tr>
				<td class="label">Card Number:</td>
				<td><input class="control" type="text" size="20" data-stripe="number" value="1234123412341234" /></td>
			</tr>
			<tr>
				<td class="label">CVC:</td>
				<td><input class="control" type="text" size="4" data-stripe="cvc" value="123" /></td>
			</tr>
			<tr>
				<td class="label">Expiration (MM/YYYY):</td>
				<td>
					<input class="control numberText" type="text" size="2" data-stripe="exp-month" value="01" />
					<input class="control numberText" type="text" size="4" data-stripe="exp-year" value="2020" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><button class="submitKnapp control" type="submit">Submit Payment</button></td>
			</tr>
			
		</table>

		
	</sf:form>
</div>

<%@include file="footer.jsp"%>