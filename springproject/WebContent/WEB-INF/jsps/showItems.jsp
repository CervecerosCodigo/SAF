
<%@include file="head.jsp"%>

<table>

	<tr>
		<th>Id</th>
		<th>Type</th>
		<th>Description</th>
		<th>Price</th>
		<th>Avilable</th>
	</tr>


	<c:forEach var="item" items="${liste}">

		<tr>
			<td><c:out value="${item.id}"></c:out></td>
			<td><c:out value="${item.type}"></c:out></td>
			<td><c:out value="${item.description}"></c:out></td>
			<td><c:out value="${item.priceIn}"></c:out></td>
			<td><c:out value="${item.numInStock}"></c:out></td>
		</tr>

	</c:forEach>
</table>

<c:out value="${cart.sillyName}"></c:out>
<c:out value="${cart.cartId}"></c:out>

<%@include file="footer.jsp"%>
