<%-- 
    Document   : updGoods
    Created on : Jun 2, 2018, 9:26:33 PM
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
        <h1>Update Your Items Here</h1>
        <form action="GoodsUpdManager">
            <select name="option">
            <option value="ChangeName">Change Name</option>
            <option value="UpdateStock">Update Stock</option>
            </select>
      <table>
        <tr>
            <td> Name of Item : </td>
            <td><input type="text" name="itemname" value="" /></td>
        </tr>
        <tr>
         <td>Type your Change : </td>
        <td><input type="text" name="change" value="" /></td>
        </tr>
        <tr>
        <input type="submit" value="Submit" />
       </tr>
       <tr><td><a href="goods.jsp">Back</a></td> 
           <td><a href="options.jap">Home</a></td>
        </tr>
            </table>
        </form>
        </div>
    </body>
</html>
