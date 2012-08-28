<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<h1>Customer List</h1>

<table class="data_grid display">
	<c:forEach items="${transactions}" var="transaction">
	<tr>
		<td>${transaction.name}</td>
		<td>
			<a href="/admin/customers/${transaction.id}">Show</a>
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