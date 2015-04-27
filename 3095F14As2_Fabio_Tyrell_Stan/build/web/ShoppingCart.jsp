<%-- 
    Document   : ShoppingCart
    Created on : 28-Nov-2014, 10:32:58 AM
    Author     : Owner
--%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h4><%=session.getAttribute("name")%>'s profile</h4>
           <%
           if(session.getAttribute("name")==null){
               response.sendRedirect("Login.jsp");
           }
           %>
    </body>
</html>
