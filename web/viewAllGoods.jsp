<%-- 
    Document   : viewAllGoods
    Created on : Jun 2, 2018, 9:35:58 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div align="center">
            <table>
                <tr>
                    <td>Goods Name</td>
                    <td>Stock Quantity</td>
                </tr>
                <c:forEach items="${result}" var="element"> 
                <tr>
                    <td>${element.goodsName}</td>
                    <td>${element.stockQuantity}</td>  </tr>
                </c:forEach>
            </table>
            <a href="options.jsp">Home</a>
        </div>
    </body>
</html>
