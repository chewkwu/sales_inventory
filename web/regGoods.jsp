<%-- 
    Document   : regGoods
    Created on : Jun 2, 2018, 9:02:18 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Goods Page</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
         <div align="center">
        <h1>Register Your Item Here</h1>
        <form action="GoodsRegManager">
            <table>
                <tr>
                    <td>Goods Name : </td>
                    <td><input type="text" name="goodsname" value="" /></td>
            </tr>
            <tr><td>Quantity : </td>
                <td><input type="text" name="quantity" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr><a href="goods.jsp"> Back </a></tr>
            </table>
        </form>
        </div>
    </body>
</html>
