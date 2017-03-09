import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Registration extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String uname = request.getParameter("uname");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
		String play = request.getParameter("play");
		String study = request.getParameter("study");
		String party = request.getParameter("party");
		String movie = request.getParameter("movie");
		String age= request.getParameter("age");
		String gender= request.getParameter("gender");
		String department= request.getParameter("department");
		String contact= request.getParameter("contact");
        try{
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase","root","root");

        Statement ps=con.createStatement();
		ps.executeUpdate("insert into register values('"+uname+"','"+fname+"','"+lname+"','"+gender+"','"+play+"','"+study+"','"+party+"','"+movie+"','"+department+"','"+age+"','"+contact+"','"+email+"','"+pass+"')");
        
        
        
            RequestDispatcher rs = request.getRequestDispatcher("Registered.html");
				   rs.include(request, response);
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }