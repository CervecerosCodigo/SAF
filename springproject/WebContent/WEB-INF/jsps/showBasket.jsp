<%@include file="head.jsp"%>

<div>
	<h3>Your basket</h3>
	<table>
		<tr>
			<td>Id</td>
			<td>Type</td>
			<td>Description</td>
			<td>Price</td>
		</tr>

		<c:forEach var="item" items="${cart.cartItems}">
			<tr>
				<td><c:out value="${item.id}"></c:out></td>
				<td><c:out value="${item.type}"></c:out></td>
				<td><c:out value="${item.description}"></c:out></td>
				<td><c:out value="${item.priceIn}"></c:out></td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total:</td>
			<td><c:out value="${cart.totalPrice}"></c:out></td>
		</tr>
	</table>
	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="${pageContext.request.contextPath}/checkout">Checkout</a>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
		<h4>Please log in to continue to checkout.</h4>		
	</sec:authorize>
</div>


<%-- <div>
	<h3>Your basket</h3>
	<table>
		<tr>
			<td>Id</td>
			<td>Type</td>
			<td>Description</td>
			<td>Price</td>
		</tr>

		<c:forEach var="item" items="${liste}">
			<tr>
				<td><c:out value="${item.id}"></c:out></td>
				<td><c:out value="${item.type}"></c:out></td>
				<td><c:out value="${item.description}"></c:out></td>
				<td><c:out value="${item.priceIn}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</div> --%>



<%@include file="footer.jsp"%>