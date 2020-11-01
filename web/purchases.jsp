<%-- 
    Document   : purchases
    Created on : Jun 2, 2018, 8:58:58 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchases Page</title>
    </head>
    <body>
         <div align="center">
        <h1>Welcome to the Purchases page</h1>
        <p></p>
            <form action="LoadRegPurch"><input type="submit" value="Register Purchase"/></form>
            <p></p>
            <a href="updPurch.jsp"> Update a Purchase</a>
            <p></p>
            <a href="viewPartPurch.jsp"> View A Purchase</a>
            <p></p> 
            <a href="viewCustPurch.jsp">View Purchases by Customer </a>
            <p></p>
            <a href="revFromDate.jsp">Calculate Revenue from Date</a>
            <p></p>
            <a href="salesFromDate.jsp">Calculate Sales from Date</a>
            <p></p>
            <a href="debtFromDate.jsp">Calculate Debt From Date</a>
            <p></p>
            <a href="custDebt.jsp">Calculate Debt of Customer</a>
            <p></p>
            <form action="AllDebt"><input type="submit" value="Calculate All Debt"/></form>
            <p></p>
            <form action="AllPurch"><input type="submit" value="View All Purchases" /></form>
            <p></p>
            <form action="AllSales"><input type="submit" value="Calculate Total Sales" /></form>
            <p></p>
            <form action="AllRev"><input type="submit" value="Calculate Total Revenue" /></form>
            <p></p>
            <a href="options.jsp"> Back </a>
        </div>
    </body>
</html>
