<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<h1>Account Info</h1>

<h2>Account Number</h2>
<div>${bankaccount.accountNumber}</div>

<h2>Status</h2>
<div>${bankaccount.isActive}</div>

<h2>Account Owner</h2>
<div>${bankaccount.customer}</div>

<h2>Available Balance</h2>
<div>${bankaccount.availableBalance}</div>

<!-- <h2>Birth Date</h2>
<div>${bankaccount.birthDate}</div>

<h2>Gender</h2>
<div>${bankaccount.gender}</div> -->