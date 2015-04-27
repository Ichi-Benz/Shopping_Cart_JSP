<%-- 
    Document   : userlogin
    Created on : 25-Nov-2014, 4:54:14 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
    </head>
    <body>
        <a href='./index.html'>Home Page</a>
        <a href='./Registration.jsp'>Registration Page</a>
        <h1>Login</h1>
        <form action='./Process' method='POST'>
            Enter username <input type='text' name='username'><br />
            Enter password <input type='password' name='password'><br />
            <input type='submit' value='Login' name='submit'>
        </form>
    </body>
</html>
