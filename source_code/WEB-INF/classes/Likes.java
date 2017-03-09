import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.RequestDispatcher;


public class Likes extends HttpServlet 
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
  {
 PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html>");
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
	out.println("</head>");	
	out.println("<html lang='en'>");
	out.println("<head>");
    out.println("<meta charset='utf-8'>");
    out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
    out.println("<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->");
    out.println("<title>MEET-A-MATE</title>");
    out.println("<!-- Bootstrap -->");
    out.println("<link href='css/bootstrap.min.css' rel='stylesheet'>");
    out.println("<link href='css/style.css' rel='stylesheet'>");
    out.println("<link href='https://fonts.googleapis.com/css?family=Roboto:400,900,500' rel='stylesheet' type='text/css'>");
    out.println("<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,800,700' rel='stylesheet' type='text/css'>");
    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>");
		
	
  out.println("</head>");
  out.println("<body>");

    out.println("<!--________________________ NAVBAR__________________________-->");

    out.println("<div class='navbar navbar-default navbar-fixed-center' role='navigation'>");
      out.println("<div class='container'>");

        out.println("<div class='navbar-header'>");

          out.println("<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-collapse'>");
            out.println("<span class='sr-only'>Toggle Navigation</span>");
            out.println("<span class='icon-bar'></span>");
            out.println("<span class='icon-bar'></span>");
            out.println("<span class='icon-bar'></span>");


          out.println("</button>");

          out.println("<a class='navbar-brand' href='#'>");
            out.println("<div class='logo'>");
              out.println("<img src='img/social.png' class='img-responsive' alt='Responsive image' width='110' height='auto'>");
            out.println("</div>");
        out.println("</a>");

        out.println("</div>");
 
        out.println("<div class='navbar-collapse collapse'>");
          out.println("<ul class='nav navbar-nav navbar-right'>");
            out.println("<li><a id='link1' href='Home#slider'>Account</a></li>");
            out.println("<li><a href='Home#services' id='link2'>Services</a></li>");

            out.println("<li><a href='PostActivity' id='link4'>Post Activity</a></li>");
			   out.println("<li><a href='Search' id='link4'>Search</a></li>");
			   out.println("<li><a href='Products' id='link4'>Products</a></li>");
			   out.println("<li><a href='Logout' id='link5'>Logout</a></li>");
         
          out.println("</ul>");
        out.println("</div>");
      out.println("</div>");
    out.println("</div>");
	
	HttpSession session = request.getSession();
	String role = (String) session.getAttribute("username");
		String user= (String)  session.getAttribute( "username" ); 
	
	if(role== null) 
		   {
		     out.println("<h1>Please Login to Like the ITEM/PRODUCT.</h1>");
		} 
		   else 
		   { 
			//String productid = request.getParameter("productid");
			String Q = request.getParameter("productid");
		     String productid = (Q.trim());
			String productname = request.getParameter("productname");
			String userid = (String) session.getAttribute( "username" );
			
			 MySqlDataStoreUtilities mySqlDataStoreUtilities;
             mySqlDataStoreUtilities = new MySqlDataStoreUtilities();

         
        	 if (userid != null)
        	 {	
		        //HttpSession session = request.getSession();
		       
				boolean flag = mySqlDataStoreUtilities.ProductLikeUpdate(productid);
				
				boolean flag1=mySqlDataStoreUtilities.insertliked(productname,userid);
         
				if(flag == true)
				{ 
				out.println("<h1>Thank you for Liking the product:- " +productname+ "</h1>");
					
				RequestDispatcher rd = request.getRequestDispatcher("Products");
			 	rd.forward(request, response);
				
				
				
				out.println("</body>");
				out.println("</html>");
					
					
					
				}
				else 
				{ 
			    out.println("<h1>Error Updating</h1>");
				}
            }
         
  
		} 	
	
		
	}
}	