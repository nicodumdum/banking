<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<form:form action="/admin/transactions/save" method="POST" modelAttribute="transaction" enctype="multipart/form-data">
<h1>Create New Transaction</h1></br>
	<table>
		<tr>
			<td>Bank Account:</td>
			<form:select path="account" items="${bankaccounts}" itemLabel="name" itemValue="id"/><br/>
		</tr>
		<tr>
			<td>Date:</br>
			<form:input path="transactionDate"/></td>
		</tr>
		<tr>
			<td>Amount</br>
			<form:input path="amount"/></td>
		</tr>
		<tr>
			<td>Transaction Type:</br>
			<form:input path="transactionType"/></td>
		</tr>
	</table>
	<input type="submit" value="Submit"/>
</form:form>