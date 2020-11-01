<%-- 
    Document   : custDebt
    Created on : Jun 2, 2018, 8:35:42 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Debt Page</title>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div>
            <form action="CustDebt">
            <table>
                <tr>
                    <td>Enter Customer PhoneNo Here : </td>
                    <td><input type="text" name="phone" value="" /></td>
                </tr>
                <tr> <input type="submit" value="Check" /> </tr>
            </table>
            </form>
            <a href="purchases.jsp">Back</a>
        </div>
    </body>
</html>
