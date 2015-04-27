<%-- 
    Document   : member
    Created on : 28-Nov-2014, 10:30:55 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.getAttribute("usernameSession"); %>
<%
    if(session.getAttribute("usernameSession")==null)
        response.sendRedirect("./index.html");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member Page</title>
    </head>
    <body>
        <jsp:useBean id="userBean" scope="session" class="Assignment2.UserBean"/>
        <jsp:setProperty name="userBean" property="name" />
        <jsp:setProperty name="userBean" property="password"/>
            <a href='./ShoppingCart'>Shopping Cart</a>
            <a href='./Catalogue'>Catalogue</a>
            <a href='./Checkout'>Checkout</a>
            <a href='./Logout'>Logout</a>
            
            <h1>Welcome<jsp:getProperty name="userBean" property="name"/></h1>
    </body>
</html>
