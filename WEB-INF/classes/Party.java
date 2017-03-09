
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
//import Utilities;

public class Party extends HttpServlet 
{
protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();

    String user=(String) session.getAttribute("username");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,pw);
	utility.printHtml("header.html");
	utility.printHtml("Party.jsp");
	utility.printHtml("footer.html");
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
	utility.printHtml("Party.jsp");
	utility.printHtml("footer.html");
	}
}
