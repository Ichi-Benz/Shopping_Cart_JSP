<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Catalog
    Created on : 28-Nov-2014, 2:08:23 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Catalog</title>
    </head>
    <body>
        <h1>Welcome to the Tech Shop Catalog</h1><br />
        <form action="./Catalog.jsp" method="POST">
            
            <sql:query var="result" dataSource="Assignment2">
                SELECT * FROM items
            </sql:query>
                
            <table border="1">
                <!-- column headers -->
                <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                </c:forEach>
                    <th></th>
                </tr>
                <!-- column data -->
                <c:forEach var="row" items="${result.rowsByIndex}">
                    <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                        <td><input type="submit"></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
