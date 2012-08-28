<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<h1>Accounts List</h1>

<table class="data_grid display">
	<c:forEach items="${bankaccounts}" var="bankaccount">
	<tr>
		<td>${bankaccount.name}</td>
		<td>
			<a href="/admin/bankaccounts/${bankaccounts.accountNumber}">Show</a>
		</td>
	</tr>
	</c:forEach>
</table>

<script type="text/javascript">
$(document).ready(function() {
	$('table.data_grid').dataTable({
		"sPaginationType": "full_numbers"
	});
});
</script>