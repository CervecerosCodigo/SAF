<%@include file="head.jsp"%>

	<h2>Registration</h2>
	
	<sf:form id="item" method="post" action="${pageContext.request.contextPath}/newitem" commandName="item">
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
				<td><input class="submitKnapp control" name="Save" type="submit"/></td>
			</tr>
		</table>
	</sf:form>
	
<%@include file="footer.jsp"%>