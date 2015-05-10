<%@include file="head.jsp"%>

<div>
	
	<h3>Your basket</h3>
	<hr>
	<table id="basketTabell" class="table">
		<tr>
			<th>Id</th>
			<th>Type</th>
			<th>Description</th>
			<th>Price</th>
		</tr>

		<c:forEach var="item" items="${cart.cartItems}">
			<tr class="cellUnderline">
				<td class="produktText numberText"><c:out value="${item.id}"></c:out></td>
				<td class="produktText"><c:out value="${item.type}"></c:out></td>
				<td class="produktText"><c:out value="${item.description}"></c:out></td>
				<td class="produktText numberText"><c:out value="${item.priceIn}"></c:out></td>
			</tr>
		</c:forEach>
		<tr class="cellTotal">
			<td></td>
			<td></td>
			<td>Total:</td>
			<td><c:out value="${cart.totalPrice}"></c:out></td>
		</tr>
	</table>
	<form action="${pageContext.request.contextPath}/checkout">
		<sec:authorize access="hasRole('ROLE_USER')">
			<input class="submitKnapp control" type="submit" value="Checkout">
		</sec:authorize>
	</form>

	<sec:authorize access="!isAuthenticated()">
		<h4>Please log in to continue to checkout.</h4>		
	</sec:authorize>	
</div>




<%@include file="footer.jsp"%>