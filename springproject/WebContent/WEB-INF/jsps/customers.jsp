
<%@include file="head.jsp"%>

<h2>All the registered customers</h2>
<table id="customerTable">

	<tr>
		<th>First name</th>
		<th>Last name</th>
		<th>Address 1</th>
		<th>Address 2</th>
		<th>Post number</th>
		<th>Post address</th>
		<th>Phone number</th>
		<th>Email address</th>
	</tr>
	<c:forEach var="customer" items="${liste}">

		<tr>
			<td><c:out value="${customer.firstname}"></c:out></td>
			<td><c:out value="${customer.lastname}"></c:out></td>
			<td><c:out value="${customer.address1}"></c:out></td>
			<td><c:out value="${customer.address2}"></c:out></td>
			<td><c:out value="${customer.post.postNumber}"></c:out></td>
			<td><c:out value="${customer.post.postAddress}"></c:out></td>
			<td><c:out value="${customer.phone}"></c:out></td>
			<td><c:out value="${customer.email}"></c:out></td>

		</tr>
		
	</c:forEach>
</table>


<%@include file="footer.jsp"%>
