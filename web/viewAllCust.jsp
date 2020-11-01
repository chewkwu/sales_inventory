<%-- 
    Document   : viewAllCust
    Created on : Jun 2, 2018, 9:34:07 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div align="center">
            <table>
                <tr>
                    <td>Customer Phone</td>
                    <td>Customer Name</td>
                    <td>Address</td>
                </tr>
                <c:forEach items="${result}" var="element"> 
                <tr>
                    <td>${element.customerName}</td>
                    <td>${element.customerPhone}</td>  
                    <td>${element.address}</td>
                </tr>
                </c:forEach>
            </table>
            <a href="options.jsp"> Home </a>
        </div>
    </body>
</html>
