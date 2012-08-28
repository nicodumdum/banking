<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<h1>Transaction Info</h1>

<h2>Bank Account</h2>
<div>${transaction.account}</div>

<h2>Date</h2>
<div>${transaction.transactionDate}</div>

<h2>Amount</h2>
<div>${transaction.amount}</div>

<h2>Transaction Type</h2>
<div>${transaction.transactionType}</div>