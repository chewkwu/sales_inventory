<%-- 
    Document   : viewCustPurch
    Created on : Jun 2, 2018, 9:41:51 PM
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
            <form action="ViewCustPurch">
            <table>
                <tr>
                    <td>Enter Customer PhoneNo Here : </td>
                    <td><input type="text" name="phone" value="" /></td>
                </tr>
                <tr> <input type="submit" value="Check" /> </tr>
            </table>
            </form>    
        </div>
    </body>
</html>
