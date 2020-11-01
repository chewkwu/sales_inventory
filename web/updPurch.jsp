<%-- 
    Document   : updPurch
    Created on : Jun 2, 2018, 9:27:59 PM
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
            <h1>Update Debt for the Purchase Here</h1>
            <form action="UpdatePurchase">
            <table>
                <tr>
                    <td>Purchase ID</td>
                    <td> <input type="text" name="id" value="" /> </td>
                </tr>
              <tr>
                    <td>Amount To Be Paid</td>
                    <td> <input type="text" name="amount" value="" /> </td>
                </tr> 
                <tr>
                    <td><input type="submit" value="Update" /> </td>
                    <td><a href="purchases.jsp"> Back </a></td>
                </tr>
            </table> 
            </form>
        </div>
    </body>
</html>
