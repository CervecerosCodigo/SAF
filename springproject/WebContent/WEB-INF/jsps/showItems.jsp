
<%@include file="head.jsp"%>

<div>
	<hr>
	Your basket id: <b><c:out value="${cart.cartId}"></c:out></b>
	<br> Number of items in basket: <b>${fn:length(cart.cartItems)}
	</b>
</div>



<div>
	<hr>
	<table id="produktvisning" class="table">
		<tr>
			<th>Id</th>
			<th>Type</th>
			<th>Description</th>
			<th>Price</th>
			<th>Avilable</th>
			<th>Add to cart</th>
		</tr>

		<c:forEach var="item" items="${liste}">
			<tr class="cellUnderline">
				<sf:form method="get" action="${pageContext.request.contextPath}/addItemToCart"	commandName="item">
					<td><input type="text" class="produktText produktId" name="id" value="<c:out value="${item.id}"></c:out>" readonly="true"/></td>
					<td><input type="text" class="produktText" name="type" value="<c:out value="${item.type}"></c:out>" readonly="true"></td>
					<td><input type="text" class="produktText" name="description" value="<c:out value="${item.description}"></c:out>"	readonly="true"></td>
					<td><input type="text" class="produktText numberText" name="priceIn" value="<c:out value="${item.priceIn}"></c:out>" readonly="true"></td>
					<td><input type="text" class="produktText numberText" name="numInStock" value="<c:out value="${item.numInStock}"></c:out>" readonly="true"></td>
					<td><input class="submitKnapp control" name="send" value="Add to cart" type="submit"></td>
				</sf:form>
			</tr>
		</c:forEach>
	</table>
	<sec:authorize access="hasRole('ROLE_USER')">
		<form action="${pageContext.request.contextPath}/showBasket">
	    	<input class="submitKnapp control" type="submit" value="Go to Basket">
		</form>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
		<h4>Please log in to view your basket.</h4>		
	</sec:authorize>
</div>

<%@include file="footer.jsp"%>
