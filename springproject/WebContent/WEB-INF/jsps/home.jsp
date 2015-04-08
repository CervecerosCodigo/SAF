
<%@include file="head.jsp"%>

<div id="container">

<h1>Hi there!</h1>
<c:out value="${name}"></c:out>

<%-- <h2>Persons</h2>
<c:forEach var="person" items="${person}">
Id: <c:out value="${person.idperson}"></c:out> <br/>
Firstname: <c:out value="${person.firstname}"></c:out> <br/>
Lastname: <c:out value="${person.lastname}"></c:out> <br/>

<%-- </c:forEach> --%>

<%-- <h2>Post</h2>
<c:forEach var="post" items="${post}">
Postnr: <c:out value="${post.postNumber}"></c:out> <br/>
Poststed: <c:out value="${post.postAddress}"></c:out> <br/>

</c:forEach>
 --%>

<h2>All items</h2>
<table>
<tr>
	<th>id</th><th>type</th><th>description</th><th>price in</th><th>in stock</th>
</tr>
<c:forEach var="item" items="${items}">
<tr>
	<td><c:out value="${item.id}"></c:out></td>
	<td><c:out value="${item.type}"></c:out></td>
	<td><c:out value="${item.description}"></c:out></td>
	<td><c:out value="${item.priceIn}"></c:out></td>
	<td><c:out value="${item.numInStock}"></c:out></td>
</tr>

</c:forEach>
</table>

<h2>Price History</h2>
<c:forEach var="hist" items="${capHistory}">
	<c:out value="${hist}"></c:out>
</c:forEach>

</div> <!-- End of container -->

<%@include file="footer.jsp"%>
