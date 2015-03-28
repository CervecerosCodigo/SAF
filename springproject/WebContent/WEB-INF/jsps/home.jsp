
<%@include file="head.jsp"%>



<h1>Hi there!</h1>
<c:out value="${name}"></c:out>

<%-- <h2>Persons</h2>
<c:forEach var="person" items="${person}">
Id: <c:out value="${person.idperson}"></c:out> <br/>
Firstname: <c:out value="${person.firstname}"></c:out> <br/>
Lastname: <c:out value="${person.lastname}"></c:out> <br/>

</c:forEach> --%>

<h2>Post</h2>
<c:forEach var="post" items="${post}">
Postnr: <c:out value="${post.postNumber}"></c:out> <br/>
Poststed: <c:out value="${post.postAddress}"></c:out> <br/>

</c:forEach>


<%@include file="footer.jsp"%>
