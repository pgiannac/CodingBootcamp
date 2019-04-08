<%--
  Created by IntelliJ IDEA.
  User: pgiannac
  Date: 08/04/19
  Time: 2:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="Form"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<h1>Trainers List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>LastName</th><th>FirstName</th><th>Assignment</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="trainer" items="${list}">
        <tr>
            <td>${trainer.id}</td>
            <td>${trainer.lastName}</td>
            <td>${trainer.firstName}</td>
            <td>${trainer.assignment}</td>
            <td><a href="editTrainer/${trainer.id}">Edit</a></td>
            <td><a href="deleteTrainer/${trainer.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="trainerForm">Add New Trainer</a>