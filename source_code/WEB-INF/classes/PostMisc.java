
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
import java.util.Date;
//import Utilities;

public class PostMisc extends HttpServlet 
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
	String maker= request.getParameter("maker");
	String adate=request.getParameter("date");
	String loc=request.getParameter("loc");
	String activity= request.getParameter("activity");
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String postdate=date.toString();
	
	try
		{
		
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt=conn.createStatement();
			int i=stmt.executeUpdate("insert into activities value('"+user+"','"+activity+"','"+maker+"','"+postdate+"','"+adate+"','"+loc+"')");
			if(i>0)
			{
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Your Activity for play is shared. If anyone wants you to be your partner they will be able to find you.');");  
				out.println("window.location.href = 'Misc';");
				out.println("</script>");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
	}
	

