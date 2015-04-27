package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      Assignment2.UserBean useBean = null;
      synchronized (session) {
        useBean = (Assignment2.UserBean) _jspx_page_context.getAttribute("useBean", PageContext.SESSION_SCOPE);
        if (useBean == null){
          useBean = new Assignment2.UserBean();
          _jspx_page_context.setAttribute("useBean", useBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("useBean"), "name", "${usernameSession}", _jspx_page_context, null);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("useBean"), "password", request.getParameter("password"), request, "password", false);
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <h1>Welcome ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Assignment2.UserBean)_jspx_page_context.findAttribute("useBean")).getName())));
      out.write("</h1>\n");
      out.write("        \n");
      out.write("        <h1>This is the admin page</h1>\n");
      out.write("        <h3>Here you can View, Update, Delete and Add items to the database.</h3>\n");
      out.write("        <h3>Use the below Console to do the above functions of this admin page.</h3>\n");
      out.write("        <br>\n");
      out.write("        <div>\n");
      out.write("            <form method=\"post\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                <label style=\"font-size: 30px;font-style: bold\">Add an Item : </label>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <label>Item Category : </label>\n");
      out.write("                <select name=\"pickCategory\">\n");
      out.write("                <option selected disabled>Select Field</option>\n");
      out.write("                <option>Game</option>\n");
      out.write("                <option>TV</option>\n");
      out.write("                <option>Computer</option>\n");
      out.write("                </select>\n");
      out.write("                <br>\n");
      out.write("                <label>Select Image : </label>\n");
      out.write("                <input type=\"file\" name=\"addImage\" />\n");
      out.write("                <br>\n");
      out.write("                <label>Item Name : </label>\n");
      out.write("                <input type=\"text\" name=\"addName\"/>\n");
      out.write("                <br>\n");
      out.write("                <label>Item Price : </label>\n");
      out.write("                <input type=\"number\" name=\"addPrice\"/>\n");
      out.write("                <br>\n");
      out.write("                <label>Item Quantity : </label>\n");
      out.write("                <input type=\"number\" name=\"addQuantity\"/>\n");
      out.write("                <br>\n");
      out.write("                <label>Item ID : </label>\n");
      out.write("                <input type=\"number\" name=\"addID\"/>\n");
      out.write("                <br>\n");
      out.write("                <label>Item Description : </label>\n");
      out.write("                <input type=\"text\" name=\"addDesc\"/>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" name=\"addItem\" value=\"Add Item\"/>\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
 
                    if(request.getParameter("addItem") != null)
                        useBean.AddItem(request.getParameter("addName"), 
                                request.getParameter("addDesc"), 
                                Integer.parseInt(request.getParameter("addQuantity")), 
                                Double.parseDouble(request.getParameter("addPrice")), 
                                Integer.parseInt(request.getParameter("addID")),
                                request.getParameter("addImage"),
                                request.getParameter("addCategory"));
                
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <label style=\"font-size: 30px;font-style: bold\">Update an Item (Pick what category to update): </label>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <select name=\"pickCat\">\n");
      out.write("                <option selected disabled>Select Field</option>\n");
      out.write("                <option>ITEM_DESCRIPTION</option>\n");
      out.write("                <option>ITEM_PRICE</option>\n");
      out.write("                <option>ITEM_STOCK</option>\n");
      out.write("                </select>\n");
      out.write("                <br>\n");
      out.write("                <label>New Value : </label>\n");
      out.write("                <input type=\"text\" name=\"newValue\"/>\n");
      out.write("                <br>\n");
      out.write("                <label>Item Name (Item that is being updated): </label>\n");
      out.write("                <input type=\"text\" name=\"itemName\"/>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" name=\"updateItem\" value=\"Update Item\"/>\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
 
                    if(request.getParameter("updateItem") != null)
                        useBean.UpdateItem(request.getParameter("itemName"), 
                                request.getParameter("newValue"), 
                                request.getParameter("pickCat"));
                
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <label style=\"font-size: 30px;font-style: bold\">Choose an Item name to delete it from the database : </label>\n");
      out.write("                <br>\n");
      out.write("                <label>Item Name : </label>\n");
      out.write("                <input type=\"text\" name=\"delItem\"/>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" name=\"deleteItem\" value=\"Delete\"/>\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

                    if(request.getParameter("deleteItem") != null)
                        useBean.DeleteItem(request.getParameter("delItem"));
                
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <label style=\"font-size: 30px;font-style: bold\">View all items within database</label>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" name=\"viewAll\" value=\"View Items\"/>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <table border=\"2\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>ID</td>\n");
      out.write("                        <td>NAME</td>\n");
      out.write("                        <td>DESCRIPTION</td>\n");
      out.write("                        <td>QUANTITY</td>\n");
      out.write("                        <td>PRICE</td>\n");
      out.write("                    </tr>\n");
      out.write("                ");

                    if(request.getParameter("viewAll") != null){
                        try{
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Assignment2","Root","Root");
                        Statement stmt = conn.createStatement();
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ITEMS");
                        ResultSet rs = ps.executeQuery();
                    
                    while(rs.next()){
                        
                
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(rs.getString("ITEM_ID"));
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rs.getString("ITEM_NAME"));
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rs.getString("ITEM_DESCRIPTION"));
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rs.getString("ITEM_STOCK"));
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rs.getString("ITEM_PRICE"));
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                ");

                        
                }
                
      out.write("\n");
      out.write("                </table>\n");
      out.write("                ");

                            rs.close();
                            stmt.close();
                            conn.close();
                            }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <br>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
