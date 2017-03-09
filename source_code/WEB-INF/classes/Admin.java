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

public class Admin extends HttpServlet 
{
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost/socialdatabase";
	//Datase crudentials
	final String USER = "puneethreddy30";
	final String PASS = "puneethreddy";
protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
		response.setContentType("text/html");
	PrintWriter out = response.getWriter();
		try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from register");
		out.print("");
		out.print("<br><br><br><br><br><br><br>");
		
		while(rs.next())
		{
			String username=rs.getString("uname");
			String gender=rs.getString("gender");
			String sport=rs.getString("play");
			String firstname=rs.getString("firstname");
			String lastname=rs.getString("lastname");
			String study=rs.getString("study");
			String party=rs.getString("party");	
			String movie=rs.getString("movie");
			String contactno=rs.getString("contactno");
			String email=rs.getString("email");
			String dob=rs.getString("dob");
			
			out.println("<h3 align='center'>Personal Details</h3>");
			out.println("<form action='DeleteUser'><table border='1px'align='center'><tr><td>Username</td><td>"+username+"</td></tr>");
			out.println("<tr><td>Gender</td><td>"+gender+"</td></tr>");
			out.println("<tr><td>Firstname</td><td>"+firstname+"</td></tr>");
			out.println("<tr><td>Lastname</td><td>"+lastname+"</td></tr>");
			out.println("<tr><td>Date of Birth</td><td>"+dob+"</td></tr><table>");
			out.println("<tr><td>Email id</td><td>"+email+"</td></tr><tr><td><input type='hidden' name='user' value='"+username+"'><input type='submit' value='delete user'></td></tr></form>");
			
			
		}
		out.println("<h3 align='center'><a href='Messages'>Messages</a></h3>");
		
	}
	catch(Exception e)
	{
		out.print(e);
	}
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
		try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from register");
		out.print("");
		out.print("<br><br><br><br><br><br><br>");
		
		while(rs.next())
		{
			String username=rs.getString("uname");
			String gender=rs.getString("gender");
			String sport=rs.getString("play");
			String firstname=rs.getString("firstname");
			String lastname=rs.getString("lastname");
			String study=rs.getString("study");
			String party=rs.getString("party");	
			String movie=rs.getString("movie");
			String contactno=rs.getString("contactno");
			String email=rs.getString("email");
			String dob=rs.getString("dob");
			
			out.println("<h3 align='center'>Personal Details</h3>");
			out.println("<form action='DeleteUser'><table border='1px'align='center'><tr><td>Username</td><td>"+username+"</td></tr>");
			out.println("<tr><td>Gender</td><td>"+gender+"</td></tr>");
			out.println("<tr><td>Firstname</td><td>"+firstname+"</td></tr>");
			out.println("<tr><td>Lastname</td><td>"+lastname+"</td></tr>");
			out.println("<tr><td>Date of Birth</td><td>"+dob+"</td></tr><table>");
			out.println("<tr><td>Email id</td><td>"+email+"</td></tr><tr><td><input type='hidden' name='user' value='"+username+"'><input type='submit' value='delete user'></td></tr></form>");
			
			
		}
		out.println("<h3 align='center'><a href='Messages'>Messages</a></h3>");
		
	}
	catch(Exception e)
	{
		out.print(e);
	}

}
}