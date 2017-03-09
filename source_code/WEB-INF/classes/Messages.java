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

public class Messages extends HttpServlet 
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

    String user=(String) session.getAttribute("username");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
		try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from message where msgto='"+user+"'");
		out.print("");
		out.print("<br><br><br><br><br><br><br>");
		out.println("<h3 align='center'>Your Messages</h3>");
		while(rs.next())
		{
			String msgfrom=rs.getString("msgfrom");
			String msg=rs.getString("msg");
			
		out.println("<form action='Reply'><table align='center'><tr><td>"+msgfrom+"</b> said <b>'"+msg+"'</td></tr>");
			out.println("<tr><td><textarea name='message' value='Enter message here'></textarea></td></tr>");
			out.println("<tr><input type='hidden' name='msgto' value='"+msgfrom+"'><input type='hidden' name='msgfrom' value='"+user+"'><td><input type='submit' value='reply'></td></tr></table></form>");
		}		
		
	}
	catch(Exception e)
	{
		out.print(e);
	}
out.println("<h3 align='center'><a href='MyProfile'>Go Back to your Profile</a></h3>");

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
		try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from message where msgto='"+user+"'");
		out.print("");
		out.print("<br><br><br><br><br><br><br>");
		out.println("<h3 align='center'>Your Messages</h3>");
		while(rs.next())
		{
			String msgfrom=rs.getString("msgfrom");
			String msg=rs.getString("msg");
			
			out.println("<form action='Reply'><table align='center'><tr><td>"+msgfrom+"</b> </td>: <td><b>'"+msg+"'</td></tr>");
			out.println("<tr><td><textarea name='message' value='Enter message here'></textarea></td></tr>");
			out.println("<tr><input type='hidden' name='msgto' value='"+msgfrom+"'><input type='hidden' name='msgfrom' value='"+user+"'><input type='submit' value='reply'></tr></table></form>");
		}
		
	}
	catch(Exception e)
	{
		out.print(e);
	}
out.println("<h3 align='center'><a href='MyProfile'>Go Back to your Profile</a></h3>");
}
}