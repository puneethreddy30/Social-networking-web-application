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

public class Message extends HttpServlet 
{
	int i;
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

    String user=(String) session.getAttribute("username");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
	String msgto=request.getParameter("msgto");
	String msgfrom=request.getParameter("msgfrom");
	String message=request.getParameter("msg");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		stmt.executeUpdate("insert into message values('"+msgto+"','"+msgfrom+"','"+message+"')");
		
			
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Your Message has been send.');");  
				out.println("window.location.href = 'Home';");
				out.println("</script>");
			
		
	}
	catch(Exception e)
	{
		out.print(e);
	}
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	
		HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

    String user=(String) session.getAttribute("username");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
	String msgto=request.getParameter("msgto");
	String msgfrom=request.getParameter("msgfrom");
	String message=request.getParameter("msg");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		stmt.executeUpdate("insert into message values('"+msgto+"','"+msgfrom+"','"+message+"')");
		
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Your Message has been sent to "+msgto+"');");  
				out.println("window.location.href = 'ViewProfile?maker="+msgto+"';");
				out.println("</script>");
			
		
	}
	catch(Exception e)
	{
		out.print(e);
	}
	}

}
