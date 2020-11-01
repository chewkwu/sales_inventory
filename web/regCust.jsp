<%-- 
    Document   : regCust
    Created on : Jun 2, 2018, 9:00:43 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers Page</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div align="center">
        <h1>Register Customer Here</h1>
        <form action="CustRegManager">
            <table>
                <tr> 
                    <td>Customer Phone : </td>
                    <td><input type="text" name="custphone" value="" /></td>
                </tr>
                <tr>
                    <td>Customer Name : </td>
                    <td><input type="text" name="custname" value="" /></td
               </tr>
               <tr>
                   <td>Customer Address : </td>
                   <td><textarea name="address" rows="4" cols="20"></textarea> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Register" /></td> 
                    <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
            <a href="goods.jsp"></a
            </tr>
            </table>
        </form>
        </div>
    </body>
</html>
