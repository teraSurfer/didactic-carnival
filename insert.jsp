<%-- 
    Document   : insert
    Created on : Dec 6, 2016, 3:38:24 PM
    Author     : MSLCELTP1800
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1><spring:message code="label.insertWelcome" text="Hello, please enter values"/>:-</h1>
        <form:form action="inserting.htm" method="post" commandName="cmdIns">
            <table>
                <tr><td><spring:message code="label.empId" text="Employee ID"/>:-</td><td><input type="text" name="employeeId"></td></tr>
                <tr><td><spring:message code="label.empName" text="Employee Name"/>:-</td><td><input type="text" name="employeeName"></td></tr>
                <tr><td><spring:message code="label.empSal" text="Employee Salary"/>:-</td><td><input type="text" name="employeeSalary"></td></tr>
            </table>
            <input type="submit" value="<spring:message code="label.insert" text="Insert"/>" > 
            <a href="index.htm" class="button"><spring:message code="label.goback" text="Go Back"/></a>
        </form:form>
            
            ${emp}
    </body>
</html>
