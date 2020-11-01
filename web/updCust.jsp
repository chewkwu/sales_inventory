<%-- 
    Document   : updCust
    Created on : Jun 2, 2018, 9:25:18 PM
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
        <h1>Update the Customer Details Here</h1>
        <form action="CustUpdManager">
                <select name="CustDetails">
                    <option value="CustomerPhone">Customer Phone</option>
                    <option value="CustomerName">Customer Name</option>
                    <option value="Address">Address</option>
                </select>
            <table>
            <tr>
                <td>Customer Phone : </td>
                <td><input type="text" name="itemname" value="" /></td>
             </tr>
             <tr>
                 <td> Type your Change : </td>
                 <td><input type="text" name="change" value="" /></td>
        </tr>
          </table>
            <p></p>
         <input type="submit" value="Submit" />
         <p></p>
         <a href="customers.jsp">Back</a>
         <p></p>
        <a href="options.jsp">Home</a>
        </form>
        </div>
    </body>
</html>
