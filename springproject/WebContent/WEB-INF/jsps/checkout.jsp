<%@include file="head.jsp"%>


<h2>Your order</h2>


<h3>Shipping adress</h3>
<sec:authorize access="hasRole('ROLE_USER')">
	<table class="formtable">
		<tr>
			<td class="label">First name:</td>
			<td><input type="text" name="fname"
				value="<c:out value="${customer.firstname}"></c:out>"></td>
		</tr>
		<tr>
			<td class="label">Last name:</td>
			<td><input type="text" name="lname"
				value="<c:out value="${customer.lastname}"></c:out>"></td>
		</tr>
		<tr>
			<td class="label">Address 1:</td>
			<td><input type="text" name="adr1"
				value="<c:out value="${customer.address1}"></c:out>"></td>
		</tr>
		<tr>
			<td class="label">Address 2:</td>
			<td><input type="text" name="adr2"
				value="<c:out value="${customer.address2}"></c:out>"></td>
		</tr>
		<tr>
			<td class="label">Post code:</td>
			<td><input type="text" name="zipcode"
				value="<c:out value="${customer.post.postNumber}"></c:out>"></td>
		</tr>
		<tr>
			<td class="label">Post address:</td>
			<td><input type="text" name="street"
				value="<c:out value="${customer.post.postAddress}"></c:out>"></td>
		</tr>
		<tr>
			<td class="label">Phone:</td>
			<td><input type="text" name="phone"
				value="<c:out value="${customer.phone}"></c:out>"></td>
		</tr>
		<tr>
			<td class="label">Email:</td>
			<td><input type="text" name="email"
				value="<c:out value="${customer.email}"></c:out>"></td>
		</tr>
	</table>
</sec:authorize>

<h3>Payment details</h3>
<div class="formtable">
	<sf:form action="${pageContext.request.contextPath}/confirmingOrder"
		method="POST" id="payment-form">
		<div>
			<label> <span>Card Number</span> <input type="text" size="20"
				data-stripe="number" value="1234123412341234" />
			</label>
		</div>

		<div>
			<label> <span>CVC</span> <input type="text" size="4"
				data-stripe="cvc" value="123" />
			</label>
		</div>

		<div>
			<label> <span>Expiration (MM/YYYY)</span> <input type="text"
				size="2" data-stripe="exp-month" value="01" />
			</label> <span> / </span> <input type="text" size="4" data-stripe="exp-year"
				value="2020" />
		</div>

		<button type="submit">Submit Payment</button>
	</sf:form>
</div>

<%@include file="footer.jsp"%>