<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Persons List</h3>
<c:if test="${!empty listUsers}">
	<table class="table">
	<tr>
		<th width="80"> ID</th>
		<th width="120">User Name</th>
		<th width="120">User Password</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>