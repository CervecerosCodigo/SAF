
<%@include file="head.jsp"%>

<div>
	<hr>
	Id for kundevogn:
	<b><c:out value="${cart.cartId}"></c:out></b>
	<%-- Antall varer i vogn: <c:out value="${cart.cartItems.size}"></c:out> --%>
	<br> Antall varer i kundevogn: <b> ${fn:length(cart.cartItems)} </b> 
	<br><i>Kommer med en standard vare fra start for debugging.</i><br> <br>
</div>


<div>
	<hr>
	<sf:form method="get"
		action="${pageContext.request.contextPath}/showItems"
		commandName="item">
		<table>
			<tr>
				<td>Id</td>
				<td>Type</td>
				<td>Description</td>
				<td>Price</td>
				<td>Avilable</td>
				<td>Add to cart</td>
			</tr>


			<c:forEach var="item" items="${liste}">
				<tr>
					<td><c:out value="${item.id}"></c:out></td>
					<td><c:out value="${item.type}"></c:out></td>
					<td><c:out value="${item.description}"></c:out></td>
					<td><c:out value="${item.priceIn}"></c:out></td>
					<td><c:out value="${item.numInStock}"></c:out></td>
					<%-- <td><sf:checkboxes items="${liste}" path="purchase"/></td> --%>
					<td><input type="checkbox" name="${item.id}"></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td><input name="send" value="Add selected items to cart"
					type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</div>

<div>
	<br>
	<hr>
	<p>Følgende skjema "immiterer" et valg gjort fra lista. Klikk på
		knappen for å legge til varen i kundevognen. Når kontrolleren har tatt
		imot varen kommer den til å skrive ut innhold i kundevognen i
		terminal.</p>
	<sf:form method="get"
		action="${pageContext.request.contextPath}/showItems"
		commandName="item">
		<table>
			<tr>
				<td>Type:</td>
				<td><input type="text" name="type" value="Melon"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" value="Vannmelon"></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="priceIn" value="100.0"></td>
			</tr>
			<tr>
				<td>Available:</td>
				<td><input type="text" name="numInStock" value="5"></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="send" value="Buy a melon for fun"
					type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</div>

<%@include file="footer.jsp"%>
