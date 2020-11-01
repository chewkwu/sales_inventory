<%-- 
    Document   : goods
    Created on : Jun 2, 2018, 8:47:36 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Goods Page</title>
    </head>
    <body>
         <div align="center">
        <h1>Welcome to the Goods Section </h1>
        <p></p>
        <a href="regGoods.jsp"> Register a New Item </a>
        <p></p>
        <a href="updGoods.jsp"> Update Stock of Present Item</a>
        <p></p>
        <form action="ViewAllGoodsManager">
        <input type="submit" value="ViewAll"/>
        </form>
        <p></p>
        <a href="options.jsp"> Back </a>
        </div>
    </body>
</html>
