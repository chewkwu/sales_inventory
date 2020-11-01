<%-- 
    Document   : login
    Created on : Jun 2, 2018, 8:55:30 PM
    Author     : Uchenna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div align="center">
        <h1>Welcome To OjaWeb!</h1>
        <form action="LoginManager">
            UserName : <input type="text" name="username" value="" />
            <p></p>
            Password : <input type="password" name="password" value="" />
            <p></p>
            <input type="submit" value="Login" />
        </form>   
        </div>
    </body>
</html>
