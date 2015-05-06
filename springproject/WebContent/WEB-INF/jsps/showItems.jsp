
<%@include file="head.jsp"%>

<div id="container">


<table>

	<c:forEach var="item" items="${liste}">
	
		<tr>
			<td><c:out value="${item.id}"></c:out></td>
		</tr>
		<tr>
			<td><c:out value="${item.type}"></c:out></td>
		</tr>
		<tr>
			<td><c:out value="${item.description}"></c:out></td>
		</tr>
		<tr>
			<td><c:out value="${item.priceIn}"></c:out></td>
		</tr>
		<tr>
			<td><c:out value="${item.numInStock}"></c:out></td>
		</tr>
		
	</c:forEach>
</table>

</div> <!-- End of container -->

<%@include file="footer.jsp"%>
