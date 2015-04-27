/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;


/**
 *
 * @author Owner
 */
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 * Name: Fabio Gomes
 * Student Number: 100723813
 * CRN:13099
 */
public class Process extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Connection conn = null;
    Statement stmt = null;
    String dbUser = "Root";
    String dbPass = "Root";
    String username1 = null;
    
    HttpSession session = request.getSession();
    
    String username = (String) session.getAttribute("usernameSession");
    String password = (String) session.getAttribute("passwordSession");
    String submit = request.getParameter("submit");
    
    String user = String.valueOf(request.getParameter("username"));
    String pass = String.valueOf(request.getParameter("password"));
    String checkUser= "SELECT username, password, admin FROM USERS";
    try 
    {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Assignment2",dbUser,dbPass);
      stmt = conn.createStatement();
      ResultSet checkuser = stmt.executeQuery(checkUser);
        
       
            while(checkuser.next())
            {
                String user1 = checkuser.getString("username");
                String pass1 = checkuser.getString("password");
                boolean adminAuth = checkuser.getBoolean("admin");
                String site = new String("http://localhost:8084/3095F14As2_Fabio_Tyrell_Stan/Login.jsp");
                if((!user1.isEmpty()&&!pass1.isEmpty()) && (adminAuth == false) && (user1.equals(user)&&pass1.equals(pass)))
                {
                    session.setAttribute("usernameSession", user1);
                    session.setAttribute("passwordSession", pass1);
                    response.sendRedirect("./member.jsp");

                }else if((!user1.isEmpty()&&!pass1.isEmpty())&& (adminAuth == true) && (user1.equals(user)&&pass1.equals(pass))){
                    session.setAttribute("usernameSession", user1);
                    session.setAttribute("passwordSession", pass1);
                    response.sendRedirect("./admin.jsp");
                }else if((!checkuser.getString("username").isEmpty() || !checkuser.getString("password").isEmpty()) 
                &&
                (!checkuser.getString("username").equals(user) || !checkuser.getString("password").equals(pass))){
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }
            }
         
        if(submit.equals("Registration"))
        {
            
        }
        
    }
     catch (SQLException e) {
      out.println("An error occured while retrieving " + "Users: " 
          + e.toString());
    } catch (ClassNotFoundException e) {
      throw (new ServletException(e.toString()));
    } finally {
      try {
        if (stmt != null) {
          conn.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
      } 
    }
        
        
        
//        PrintWriter out = response.getWriter();
//            /* TODO output your page here. You may use following sample code. */
//            String submit = request.getParameter("submit");
//            
//            String userRegister = request.getParameter("registerUsername");
//            String passwordRegister = request.getParameter("registerPassword");
//            
//            String user = request.getParameter("username");
//            String password = request.getParameter("password");
//            HttpSession session = request.getSession();
//            
//            ArrayList<String> Username = (ArrayList<String>)session.getAttribute("sessionUsername");
//            ArrayList<String> Password = (ArrayList<String>)session.getAttribute("sessionPassword");
//            
//            
//                if(Username==null||Username.isEmpty()) 
//                {          
//                    Username = new ArrayList<>();
//                    Username.add("Fabio");
//                }
//                session.setAttribute("sessionUsername",Username);
//
//                if(Password==null||Password.isEmpty()) 
//                {
//                    Password = new ArrayList<>();
//                    Password.add("Gomes");
//                }
//                
//                if((submit.equals("Submit"))){
//                int n = -1;
//
//                while(n<Username.size())
//                {
//                    n++;
//                    if(userRegister.isEmpty()||passwordRegister.isEmpty()||userRegister.equals(Username.get(n)))
//                    {
//                        out.println("<!DOCTYPE html>");
//                        out.println("<html>");
//                        out.println("<head>");
//                        out.println("<title>Reqistration Failure</title>");            
//                        out.println("</head>");
//                        out.println("<body>");
//                        out.println("<a href='./Registration.jsp'>Registration</a>");
//                        out.println("<h1>Sorry your account registartion has failed please try again with a differnt username</h1>");
//                        out.println("</body>");
//                        out.println("</html>");
//                        break;
//                    }
//                    else if(n == Username.size()-1)
//                    {
//                        Username.add(userRegister);
//                        Password.add(passwordRegister);
//                        
//                        session.setAttribute("sessionUsername",Username);
//                        session.setAttribute("sessionPassword",Password);
//                        
//                        out.println("<!DOCTYPE html>");
//                        out.println("<html>");
//                        out.println("<head>");
//                        out.println("<title>Main Screen</title>");            
//                        out.println("</head>");
//                        out.println("<body>");
//                        out.println("<a href='./member.jsp'>Member Page</a>");
//                        out.println("<h1>Thank you for registering</h1>");
//                        out.println("</body>");
//                        out.println("</html>");
//                        break;
//                    }
//                }
//            }
//            else if((submit.equals("Login")))
//            {
//                int n = -1;
//                
//                while(n < Username.size())
//                {
//                    n++;
//                    if((user.equals(Username.get(n)))&&password.equals(Password.get(n))){
//                                        
//                    session.setAttribute("sessionUsername",Username);
//                    session.setAttribute("sessionPassword",Password);
//                    
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Main Screen</title>");            
//                    out.println("</head>");
//                    out.println("<body><center>");
//                    out.println("<h1> Welcome back "+Username.get(n)+"</h1>");    
//                    out.println("<form action='./member.jsp'");
//                    out.println("method=POST>");
//                    out.println("<br>");
//                    out.println("<input type=submit>");
//                    out.println("</form>");
//                    out.println("</body>");
//                    out.println("</html>");
//                   break;
//                }else{
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Main Screen</title>");            
//                    out.println("</head>");
//                    out.println("<body><center>");
//                    out.println("<h1>Invalid Login user doesn't exisit</h1>");
//                   
//                    out.println("<P>");
//                    out.println("<form action=./Login.jsp");
//                    out.println("method=POST>");
//                    out.println("<br>");
//                    out.println("<input type=submit value='Continue'>");
//                    out.println("</form>");
//                    
//                    out.println("</body>");
//                    out.println("</html>");
//                    break;
//                }
//                }
//            }
        
    }

}