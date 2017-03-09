import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
//import Utilities;

public class DeleteUser extends HttpServlet 
{
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost/socialdatabase";
	//Datase crudentials
	final String USER = "root";
	final String PASS = "root";
protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
		HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

    String user= request.getParameter("user");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt=con.createStatement();
				stmt.executeUpdate("delete from user where username='"+user+"'");
				RequestDispatcher dispatcher = request.getRequestDispatcher("sales");
				dispatcher.forward(request, response);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	
		HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

    String user= request.getParameter("user");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt=con.createStatement();
				stmt.executeUpdate("delete from user where username='"+user+"'");
				RequestDispatcher dispatcher = request.getRequestDispatcher("sales");
				dispatcher.forward(request, response);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

}
}