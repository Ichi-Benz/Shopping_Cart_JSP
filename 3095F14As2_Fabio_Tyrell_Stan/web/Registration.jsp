<%-- 
    Document   : Registration
    Created on : 28-Nov-2014, 11:15:47 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <a href='./index.html'>Home Page</a>
        <a href='./Login.jsp'>Login Page</a>
        <h1>Registration</h1>
            
        <form action='./Process' method='Post'>
            Enter your username <input type='text' name='registerUsername' required="required"><br />
            Enter your password <input type='password' name='registerPassword' required="required"><br />
            Enter first name <input type="text" name="firstName" required="required"><br />
            Enter last name <input type="text" name="lastName" required="required"><br/>
            Enter your address<input type="text" name="address" required="required"><br />
            <input type='submit' value='Registration' name='submit'>
        </form>
    </body>
</html>
