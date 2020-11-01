<%-- 
    Document   : revFromDateSucc
    Created on : Jun 2, 2018, 9:16:03 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revenue Page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <div align="center">
            <h1> Your Revenue For the Period :  ${revenue}</h1>
            <p></p>
             <a href="revFromDate.jsp"> Back </a>
            <a href="options.jsp"> Home </a>
        </div>
    </body>
</html>
