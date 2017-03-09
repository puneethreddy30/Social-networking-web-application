
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

public class Home extends HttpServlet 
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
		if (session.getAttribute("user")!=null)
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from activities order by activitydate desc");
		out.print("<br><br><br><br><br><br><br><br>");
		while(rs.next())
		{
			String username=rs.getString("username");
			String activity=rs.getString("activity");
			String sport=rs.getString("sport");
			String postdate=rs.getString("postdate");
			String activitydate=rs.getString("activitydate");	
			String location=rs.getString("location");
			out.println("<h3 align='center'><a href='ViewProfile?maker="+username+"'>"+username+"</a> willing to "+activity+" "+sport+" on "+activitydate+" at <b>"+location+"</b></h3><br>");
		}
	}
	else
	{
		utility.printHtml("content.html");
	}
	utility.printHtml("footer.html");
	}
	catch(Exception e)
	{
		out.print(e);
	}
	
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	HttpSession session = request.getSession();
    String user=(String) session.getAttribute("username");
	session.setAttribute("user", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,pw);
	utility.printHtml("header.html");
	utility.printHtml("content.html");
	utility.printHtml("footer.html");
	}
}
