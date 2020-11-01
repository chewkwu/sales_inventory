<%-- 
    Document   : customers
    Created on : Jun 2, 2018, 8:41:47 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers Page</title>
    </head>
    <body>
        <div align="center">
            <h1> Select a Measure by Clicking Any Link Below</h1>
            <p></p>
            <a href="regCust.jsp"> Register a Customer </a>
            <p></p>
            <a href="updCust.jsp"> Update Customer Details</a>
            <p></p>
            <form action="ViewAllCustManager">
            <input type="submit" value="View All"/>
            </form>
            <p></p>
            <a href="options.jsp">Back</a>
        </div>
    </body>
</html>
