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

public class Utilities 
	{
	HttpServletRequest req;
	PrintWriter pw;
	String url;
	HttpSession session; 

	public Utilities(HttpServletRequest req, PrintWriter pw) {
		this.req = req;
		this.pw = pw;
		this.url = this.getFullURL();
		this.session = req.getSession(true);
	}

	public void printHtml(String file) {
		String result = HtmlToString(file);
		System.out.println(file);
		if (file == "header.html") {
			System.out.println(session.getAttribute("user"));
			if (session.getAttribute("user")!=null){
				
				String username = session.getAttribute("user").toString();
				//System.out.println(username);
				username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
				String resultset=null;
				resultset=resultset+"<!DOCTYPE html>"
+"<html lang='en'>"
  +"<head>"
			+" <meta charset='utf-8'>"
			+"<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
    +"<meta name='viewport' content='width=device-width, initial-scale=1'>"
    +"<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->"
    +"<title>Aptitude Test Beta</title>"
    +"<!-- Bootstrap -->"
    +"<link href='css/bootstrap.min.css' rel='stylesheet'>"
    +"<link href='css/style.css' rel='stylesheet'>"
    +"<link href='https://fonts.googleapis.com/css?family=Roboto:400,900,500' rel='stylesheet' type='text/css'>"
    +"<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,800,700' rel='stylesheet' type='text/css'>"
    +"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>"

  +"</head>"
  +"<body>"

    +"<!--________________________ NAVBAR__________________________-->"

    +"<div class='navbar navbar-default navbar-fixed-top' role='navigation'>"
      +"<div class='container'>"

        +"<div class='navbar-header'>"

          +"<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-collapse'>"
            +"<span class='sr-only'>Toggle Navigation</span>"
            +"<span class='icon-bar'></span>"
            +"<span class='icon-bar'></span>"
            +"<span class='icon-bar'></span>"


          +"</button>"

          +"<a class='navbar-brand' href='Home'>"
            +"<div class='logo'>"
              +"<img src='img/social.png' class='img-responsive' alt='Responsive image' width='110' height='auto'>"
            +"</div>"
        +"</a>"

        +"</div>"
 
        +"<div class='navbar-collapse collapse'>"
          +"<ul class='nav navbar-nav navbar-right'>"
			  + "<li><a href='MyProfile'>Hi, "+username+"</a></li>"
						+ "<li><a href='Products'>Products</a></li>"
						+ "<li><a href='PostActivity'>Post Activity</a></li>"
						+ "<li><a href='search.jsp'>Search</a></li>"
						+ "<li><a href='Logout.jsp'>Logout</a></li>"
         
          +"</ul>"
        +"</div>"
      +"</div>"
    +"</div>";
						
				System.out.println("Hello");
				System.out.println(username);
				System.out.println(resultset);
				pw.print(resultset);
			}
			else{
			pw.print(result);
			}
		} else
			pw.print(result);
	}
	

	public String getFullURL() {
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		StringBuffer url = new StringBuffer();
		url.append(scheme).append("://").append(serverName);

		if ((serverPort != 80) && (serverPort != 443)) {
			url.append(":").append(serverPort);
		}
		url.append(contextPath);
		url.append("/");
		return url.toString();
	}


	public String HtmlToString(String file) {
		String result = null;
		try {
			String webPage = url + file;
			URL urll = new URL(webPage);
			URLConnection urlConnection = urll.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			result = sb.toString();
		} catch (Exception e) {
		}
		return result;
	}


}