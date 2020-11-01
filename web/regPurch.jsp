<%-- 
    Document   : regPurch
    Created on : Jun 2, 2018, 9:04:26 PM
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
            <h1> Enter a Purchase</h1>
            <form action="RegPurch">
            <table>
                <tr>
                    <td>Select Item</td>
                    <td>Goods Name</td>
                    <td>Stock Quantity</td>
                    <td>Price of Item</td>
                </tr>
                <c:forEach items="${result}" var="element"> 
                <tr>
                    <td> <input type="checkbox" name="init" value="${element.goodsName}"/></td>
                    <td>${element.goodsName}</td>
                    <td><input type="text" name="figure${element.goodsName}" value="" /></td>
                    <td><input type="text" name="price${element.goodsName}" value="" /></td>
                </tr>
                </c:forEach>
                 </table>
                <p></p>
                    Customer Phone : <input type="text" name="custPhone" value="" />
                    <p></p>
                    Amount Paid : <input type="text" name="amtpaid" value="" />
                    <p></p>
                     <input type="submit" value="Add Purchase" />
           
         </form>
        </div>
    </body>
</html>
