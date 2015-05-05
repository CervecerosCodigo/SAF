
<%@include file="head.jsp"%>

<div id="container">


<table>

	<c:forEach var="customer" items="${liste}">
	
		<tr>
			<td><c:out value="${customer.firstname}"></c:out></td>
		</tr>
		
	</c:forEach>
</table>

</div> <!-- End of container -->

<%@include file="footer.jsp"%>
