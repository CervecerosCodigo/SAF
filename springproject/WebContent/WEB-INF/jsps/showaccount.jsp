
<%@include file="head.jsp"%>
	
<h2>Displaying you account,  <c:out value="${customer.firstname}"/> <c:out value="${customer.lastname}"/></h2>

<sec:authorize access="hasRole('ROLE_USER')">	
		<table class="formtable">
			<tr>
				<td class="label">First name:</td>
				<td><c:out value="${customer.firstname}"></c:out></td>
			</tr>
			<tr>
				<td class="label">Last name:</td>
				<td><c:out value="${customer.lastname}"></c:out></td>
			</tr>
			<tr>
				<td class="label">Address 1:</td>
				<td><c:out value="${customer.address1}"></c:out></td>
			</tr>
			<tr>
				<td class="label">Address 2:</td>
				<td><c:out value="${customer.address2}"></c:out></td>
			</tr>
			<tr>
				<td class="label">Post code:</td>
				<td><c:out value="${customer.post.postNumber}"></c:out></td>
			</tr>
			<tr>
				<td class="label">Post address:</td>
				<td><c:out value="${customer.post.postAddress}"></c:out></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td><c:out value="${customer.phone}"></c:out></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><c:out value="${customer.email}"></c:out></td>
			</tr>
		</table>

<h3>Your order history</h3>		


		
</sec:authorize>
		
<%@include file="footer.jsp"%>
