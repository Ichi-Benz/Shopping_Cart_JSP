<%-- 
    Document   : admin
    Created on : Nov 30, 2014, 9:25:47 PM
    Author     : Stan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="useBean" scope="session" class="Assignment2.UserBean"/>
        <jsp:setProperty name="useBean" property="name" value="${usernameSession}"/>
        <jsp:setProperty name="useBean" property="password"/>
        
        
        <h1>Welcome <jsp:getProperty name="useBean" property="name"/></h1>
        
        <h1>This is the admin page</h1>
        <h3>Here you can View, Update, Delete and Add items to the database.</h3>
        <h3>Use the below Console to do the above functions of this admin page.</h3>
        <br>
        <div>
            <form method="post">
                <%--Add an item into the database --%>
                <label style="font-size: 30px;font-style: bold">Add an Item : </label>
                <br>
                <br>
                <label>Item Category : </label>
                <select name="pickCategory">
                <option selected disabled>Select Field</option>
                <option>Game</option>
                <option>TV</option>
                <option>Computer</option>
                </select>
                <br>
                <label>Select Image : </label>
                <input type="file" name="addImage" />
                <br>
                <label>Item Name : </label>
                <input type="text" name="addName"/>
                <br>
                <label>Item Price : </label>
                <input type="number" name="addPrice"/>
                <br>
                <label>Item Quantity : </label>
                <input type="number" name="addQuantity"/>
                <br>
                <label>Item ID : </label>
                <input type="number" name="addID"/>
                <br>
                <label>Item Description : </label>
                <input type="text" name="addDesc"/>
                <br>
                <input type="submit" name="addItem" value="Add Item"/>
                <%--Function that will be passed to the database to add the above item and the contents entered by the admin --%>
                <% 
                    if(request.getParameter("addItem") != null)
                        useBean.AddItem(request.getParameter("addName"), 
                                request.getParameter("addDesc"), 
                                Integer.parseInt(request.getParameter("addQuantity")), 
                                Double.parseDouble(request.getParameter("addPrice")), 
                                Integer.parseInt(request.getParameter("addID")),
                                request.getParameter("addImage"),
                                request.getParameter("addCategory"));
                %>
                <br>
                <br>
                <%--This will update an existing item within the database --%>
                <label style="font-size: 30px;font-style: bold">Update an Item (Pick what category to update): </label>
                <br>
                <br>
                <select name="pickCat">
                <option selected disabled>Select Field</option>
                <option>ITEM_DESCRIPTION</option>
                <option>ITEM_PRICE</option>
                <option>ITEM_STOCK</option>
                </select>
                <br>
                <label>New Value : </label>
                <input type="text" name="newValue"/>
                <br>
                <label>Item Name (Item that is being updated): </label>
                <input type="text" name="itemName"/>
                <br>
                <br>
                <input type="submit" name="updateItem" value="Update Item"/>
                <%--This function will be passed to the database to update the item enetered above by the admin --%>
                <% 
                    if(request.getParameter("updateItem") != null)
                        useBean.UpdateItem(request.getParameter("itemName"), 
                                request.getParameter("newValue"), 
                                request.getParameter("pickCat"));
                %>
                <br>
                <br>
                <%--This will delete an item within the database that already exists by the admin --%>
                <label style="font-size: 30px;font-style: bold">Choose an Item name to delete it from the database : </label>
                <br>
                <label>Item Name : </label>
                <input type="text" name="delItem"/>
                <br>
                <input type="submit" name="deleteItem" value="Delete"/>
                <%--This function will be passed to the database to delete the item enetered above by the admin --%>
                <%
                    if(request.getParameter("deleteItem") != null)
                        useBean.DeleteItem(request.getParameter("delItem"));
                %>
                <br>
                <br>
                <%--This will view all items within the database --%>
                <label style="font-size: 30px;font-style: bold">View all items within database</label>
                <br>
                <br>
                <input type="submit" name="viewAll" value="View Items"/>
                <%--This operation will be passed to the database to do the above view input --%>
                <table border="2">
                    <tr>
                        <td>ID</td>
                        <td>NAME</td>
                        <td>DESCRIPTION</td>
                        <td>QUANTITY</td>
                        <td>PRICE</td>
                    </tr>
                <%
                    if(request.getParameter("viewAll") != null){
                        try{
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Assignment2","Root","Root");
                        Statement stmt = conn.createStatement();
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ITEMS");
                        ResultSet rs = ps.executeQuery();
                    
                    while(rs.next()){
                        
                %>
                        <tr>
                            <td><%=rs.getString("ITEM_ID")%></td>
                            <td><%=rs.getString("ITEM_NAME")%></td>
                            <td><%=rs.getString("ITEM_DESCRIPTION")%></td>
                            <td><%=rs.getString("ITEM_STOCK")%></td>
                            <td><%=rs.getString("ITEM_PRICE")%></td>
                        </tr>
                <%
                        
                }
                %>
                </table>
                <%
                            rs.close();
                            stmt.close();
                            conn.close();
                            }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                %>
            </form>
            <br>
        </div>
    </body>
</html>
