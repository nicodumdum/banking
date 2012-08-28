<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<form:form action="/admin/bankaccounts/save" method="POST" modelAttribute="bankaccounts" enctype="multipart/form-data">
<h1>New Bank Account</h1></br>
	<table>
		<tr>
			<td>Account Number:</br>
			<form:input path="accountNumber"/></td>
		</tr>
		<tr>
			<td>Status:</br>
			<input type="radio" name="isActive" value= 1  /> Active     
			<input type="radio" name="isActive" value= 0 /> Inactive</td>
		</tr>
		<tr>
			<td>Account Owner:</td>
			<form:select path="customer" items="${customers}" itemLabel="name" itemValue="id"/><br/>
		</tr>
		<tr>
			<td>Current Balance:</br>
			<form:input path="currentBalance"/></td>
		</tr>
		<!-- <tr>
			<td>Birth Date</br>
			<form:input path="birthDate"/></td>
		</tr> -->
	</table>
	<input type="submit" value="Submit"/>
</form:form>