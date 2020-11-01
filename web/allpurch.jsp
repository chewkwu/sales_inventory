<%-- 
    Document   : allpurch
    Created on : Jun 2, 2018, 8:34:11 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchases Page</title>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div align="center">
            <table>
                <tr>
                    <td>Purchase ID</td>
                    <td>Customer Phone</td>
                    <td>Items Purchased</td>
                    <td>Amount</td>
                    <td>Sum Paid</td>
                    <td>Date</td>
                    <td>Debt</td>
                </tr>
                <c:forEach items="${allpurch}" var="element"> 
                <tr>
                    <td>${element.id}</td>
                    <td>${element.phone}</td> 
                    <td>${element.itemsPurchased}</td> 
                    <td>${element.amount}</td> 
                    <td>${element.sumPaid}</td> 
                    <td>${element.purchaseDate}</td> 
                    <td>${element.debt}</td> 
                </tr>
                </c:forEach>
            </table>
             <a href="options.jsp"> Home</a>
        </div>
    </body>
</html>
