<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3>Persons List</h3>
<%--<c:if test="${!empty listUsers}">--%>
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
		<td><a href="<c:url value='edit/${user.id}' />" >Edit</a></td>
		<td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
	</tr>
</c:forEach>
</table>
<%--</c:if>--%>

<c:url var="addAction" value="/addUser.html" ></c:url>
<form:form action="${addAction}" commandName="User" >
	<c:if test="${!empty User.username}">	
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>		
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />		
	</c:if>
	<div class="form-group">
  		<form:label path="username" class="form-control">Nick de Usuario</form:label>  
  		<form:input path="username" autocomplete="off"  class="form-control"/>
	</div>
	<div class="form-group">
  		<form:label path="password" class="form-control">contraseña</form:label>  
  		<form:input  type="password" path="password" class="form-control"/>
	</div>	
	<div class="form-group">
  		<form:label path="email" class="form-control">Correo</form:label>  
  		<form:input type="email" path="email" autocomplete="off" class="form-control"/>
	</div>
	
	<c:if test="${empty User.username}">
		<div class="form-group">
      		<input type="submit" value="Add User" class="btn btn-success"/>
    	</div>
	</c:if>
	<c:if test="${!empty User.username}">
		<div class="form-group">
      		<input type="submit" value="Edit User" class="btn btn-success"/>
    	</div>
	</c:if>
		 
</form:form> 

