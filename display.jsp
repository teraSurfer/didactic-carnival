<%-- 
    Document   : insert
    Created on : Dec 6, 2016, 3:38:24 PM
    Author     : MSLCELTP1800
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <h1><spring:message code="label.displayWelcome" text="Enter the Employee ID to display employee, Click all to display all employees"/>:-</h1>
        <form:form action= "displaying.htm" method="post">
            <table>
                <tr><td>Employee ID:- </td><td><input type="text" name="id"></td></tr>
            </table>
            <input type="submit" value="<spring:message code="label.getdetails" text="Get Details"/>"> 
            <a href="index.htm" class="button"><spring:message code="label.goback" text="Go Back"/></a>
        </form:form>
            <form:form action= "displayAll.htm" method="post">
                <input type="submit" value="<spring:message code="label.getall" text="Get All"/>"> 
                </form:form>
                
                <table border="1">
                    <tr><th><spring:message code="label.id" text="ID"/></th><th><spring:message code="label.name" text="NAME"/></th><th><spring:message code="label.sal" text="SAL"/></th></tr>
                    <tr><td>${did.employeeId}</td><td>${did.employeeName}</td><td>${did.employeeSalary}</td></tr>
                </table>
    </body>
</html>
