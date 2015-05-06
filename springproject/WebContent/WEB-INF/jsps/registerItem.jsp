<%@include file="head.jsp"%>

<div id="container">

	<h2>Registration</h2>
	<br>
	<h3>New store item</h3>
	
	<sf:form method="post" action="${pageContext.request.contextPath}/registerItem" commandName="item">
		<table class="formtable">
			<tr>
				<td class="label">Item type:</td>
				<td><sf:input class="control" path="type" name="type" type="text"/></td>
			</tr>
			<tr>
				<td class="label">Description:</td>
				<td><sf:input class="control" path="description" name="description" type="text"/></td>
			</tr>
			<tr>
				<td class="label">Prince in:</td>
				<td><sf:input class="control" path="priceIn" name="priceIn" type="text"/></td>
			</tr>
			<tr>
				<td class="label">Available items:</td>
				<td><sf:input class="control" path="numInStock" name="numInStock" type="text"/></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" name="Save" type="submit"/></td>
			</tr>
		</table>
	</sf:form>
</div>
<%@include file="footer.jsp"%>