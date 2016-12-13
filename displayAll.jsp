<%-- 
    Document   : displayAll
    Created on : Dec 7, 2016, 4:49:58 PM
    Author     : MSLCELTP1800
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .button {
    font-family: Arial, Helvetica, sans-serif;
    background-color: #DF590C;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
input[type=submit] {
    background-color: #DF590C;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button:hover {
    font-family: Arial, Helvetica, sans-serif;
    background-color: #F17A34;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
input[type=submit]:hover {
    background-color: #F17A34;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
        </style>
    </head>
    <body>
        <h1><spring:message code="label.displayAllWelcome" text="All Employees"/>:-</h1>
        <script>
function toggle(source) {
  checkboxes = document.getElementsByName('select');
  for(var i=0, n=checkboxes.length;i<n;i++) {
    checkboxes[i].checked = source.checked;
  }
}
        </script>    
        <form:form action = "delmultiple.htm" method="post" >
        <table border="1">
            <tr><th><input type="checkbox" id="selectAll" onClick="toggle(this)"></th><th><spring:message code="label.id" text="ID"/></th><th><spring:message code="label.name" text="NAME"/></th><th><spring:message code="label.sal" text="SAL"/></th><th><spring:message code="label.EDIT" text="EDIT"/></th></tr>
        <c:forEach items="${elist}" var="m">
                <tr><td><input type="checkbox" name="select" value="${m.employeeId}"></td><td><c:out value="${m.employeeId}"></c:out></td><td><c:out value="${m.employeeName}"></c:out></td><td><c:out value="${m.employeeSalary}"></c:out></td><td><a href="Udisplaying.htm?id=${m.employeeId}"><spring:message code="label.edit1" text="edit"/></a></td></tr>
        </c:forEach>
        </table>
        <input type="submit" value="<spring:message code="label.delete" text="Delete"/>">
        <a href="index.htm" class="button"><spring:message code="label.goback" text="Go Back"/></a>   
        </form:form>
        
        <c:forEach items="${pages}" var = "p">
            <a href="pages.htm?id=${p}">${p}</a>
        </c:forEach>
    </body>
</html>