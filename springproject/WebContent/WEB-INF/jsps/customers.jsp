
<%@include file="head.jsp"%>


<table>

	<c:forEach var="customer" items="${liste}">
	
		<tr>
			<td><c:out value="${customer.firstname}"></c:out></td>
		</tr>
		
	</c:forEach>
</table>


<%@include file="footer.jsp"%>
