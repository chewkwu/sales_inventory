<%-- 
    Document   : regPurchSucc
    Created on : Jun 2, 2018, 9:11:16 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchases Page</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div align="center">
        <table>
            <tr><h1>Purchase Successfully Registered</h1></tr>
        <tr>
            <td>Name</td>
            <td>Value</td>
        </tr>
         <tr>
            <td>Transaction ID</td>
            <td>${purchase.id}</td>
        </tr>
         <tr>
            <td>Customer Phone</td>
            <td>${purchase.phone}</td>
        </tr>
         <tr>
            <td>Items Purchased</td>
            <td>${purchase.itemsPurchased}</td>
        </tr>
         <tr>
            <td>Purchase Amount</td>
            <td>${purchase.amount}</td>
        </tr>
         <tr>
            <td>Amount Paid</td>
            <td>${purchase.sumPaid}</td>
        </tr>
         <tr>
            <td>Purchase Date</td>
            <td>${purchase.purchaseDate}</td>
        </tr>
         <tr>
            <td>Debt</td>
            <td>${purchase.debt}</td>
        </tr>
        <tr>
            <td><a href="regPurch.jsp"> Back </a></td>
            <td><a href="options.jsp"> Home </a></td>
        </tr>
        </table>
        </div>
    </body>
</html>
