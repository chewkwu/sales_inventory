<%-- 
    Document   : revFromDate
    Created on : Jun 2, 2018, 9:12:55 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revenue Page</title>
         <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div align="center">
            <h1>Enter a Date to Calculate Revenue From</h1>
            <form action="RevFromDate">
                <table>
                    <tr>
                        <td>Enter Your Date Criteria : </td>
                        <td> <input type="text" name="date" value="" /> </td>
                    </tr>
                    <tr> <input type="submit" value="Check" /> </tr>
                </table>
            </form>
        </div>
    </body>
</html>
