<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee CURD</title>
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

        </style>    
    </head>
    <a href="insert.htm" class="button"><spring:message code="label.insert" text="Insert"/></a>
    <a href="update.htm" class="button"><spring:message code="label.update" text="Update"/></a>
    <a href="delete.htm" class="button"><spring:message code="label.delete" text="Delete"/></a>
    <a href="display.htm" class="button"><spring:message code="label.display" text="Display"/></a>
 <br/>   <br/> <br/> <br/> 
Current Locale:- ${pageContext.response.locale}<br/>
Change Locale:- <a href="?lang=en">English</a>|<a href="?lang=fr">French</a>
</body>
    