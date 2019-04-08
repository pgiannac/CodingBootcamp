<%--
  Created by IntelliJ IDEA.
  User: pgiannac
  Date: 08/04/19
  Time: 2:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Trainer</h1>
<form:form method="post" action="save">
    <table >
        <tr>
            <td>Last Name : </td>
            <td><form:input path="lastName"  /></td>
        </tr>
        <tr>
            <td>First Name :</td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Assignment :</td>
            <td><form:input path="assignment" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
