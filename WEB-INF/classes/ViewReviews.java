
  import java.sql.*;
  import java.io.*;
  import java.io.PrintWriter;
 import com.mongodb.BasicDBObject;
  import javax.servlet.*;
  import javax.servlet.http.*;
  import java.util.*;
  import java.util.Date;
  import java.text.SimpleDateFormat;
  import java.util.Calendar;
  import java.util.HashMap;
  import javax.servlet.RequestDispatcher;
  import com.mongodb.DB;
 import com.mongodb.DBObject;
import com.mongodb.ServerAddress;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
 
 public class ViewReviews extends HttpServlet 
 {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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

            out.println("<li><a href='Home#contact' id='link4'>Post Activity</a></li>");
			   out.println("<li><a href='SignIn.html' id='link4'>Search</a></li>");
			   out.println("<li><a href='Products' id='link4'>Products</a></li>");
			   out.println("<li><a href='SignUp.html' id='link5'>Logout</a></li>");
         
          out.println("</ul>");
        out.println("</div>");
      out.println("</div>");
    out.println("</div>");
		
		
		DBCursor cursor2=null;
		  try
		   {
			
		     
		     HttpSession session1=request.getSession(true);
		     String Q = request.getParameter("productid");
		     String productcode = (Q.trim());
			 BasicDBObject myreviewdocument= new BasicDBObject();
			
			 myreviewdocument.put("PRODUCT_CODE",productcode);
			 System.out.println(myreviewdocument);
			 
			 ServletContext context = request.getSession().getServletContext();
			 MyMongoDBDataStoreUtilities myMongoDBDataStoreUtilities;
			 myMongoDBDataStoreUtilities = new MyMongoDBDataStoreUtilities();
			 
			 cursor2= myMongoDBDataStoreUtilities.ReviewsViewing(myreviewdocument);
			 String productname=request.getParameter("productname");
			 //RequestDispatcher rd = request.getRequestDispatcher("Showreviews.jsp");
			 
			// rd.forward(request, response);
			
			 out.println("<h2><br><br>Reviews for:"+productname+"</h2><br><br>");
			 
		
              
              while(cursor2.hasNext())
              {
                
				//String category="";
				String pcode="";
				String pname="";
				String rprice="";
				

				String uid="";
				String age="";
				String gen="";
				
				String occ="";
				String rating="";
				String rdate="";
				String rtext="";
				
		        DBObject obj = cursor2.next();
				  
				  //category=(String) obj.get("PRODUCT_CATEGORY");
				  //out.println("<p>Category:"+category+"</p>");
				  
				  out.println("<table>");
				  pname=(String) obj.get("PRODUCT_NAME"); 
				  out.println("<tr><td><p>Pro Name:"+pname+"</p></tr></td>");
				  
				  
				  pcode=(String) obj.get("PRODUCT_CODE"); 
				   out.println("<tr><td><p>Product Code:"+pcode+"</p></tr></td>");
				  
				  rprice=(String) obj.get("RENTAL_PRICE"); 
				  out.println("<tr><td><p>Price:"+rprice+"</p></tr></td>");
				  
				  
				   uid=(String) obj.get("USER_ID"); 
				  out.println("<tr><td><p>User:"+uid+"</p></tr></td>");
				  
				   age=(String) obj.get("AGE"); 
				  out.println("<tr><td><p>AGE:"+age+"</p></tr></td>");
				  
				   gen=(String) obj.get("GENDER");  
				  out.println("<tr><td><p>GENDER:"+gen+"</p></tr></td>");
				  
				   occ=(String) obj.get("OCCUPATION");  
				  out.println("<tr><td><p>OCCUPATION: "+occ+"</p></tr></td>");
				  
				   rating=(String) obj.get("RATING");  
				  out.println("<tr><td><p>Rating: "+rating+"</p></tr></td>");
				  
				   rdate=(String) obj.get("REVIEW_DATE"); 
				  out.println("<tr><td><p>Date: "+rdate+"</p></tr></td>");
				  
				   rtext=(String) obj.get("REVIEW_TEXT");  
				  out.println("<tr><td><p>Review: "+rtext+"</p></tr></td>");
				  
				 
				  
				  
				  out.println("</table>");
				   out.println("<br><br><br><br>");
				  
			} 
         }

		  catch (Exception e) {
				out.println("<h2><br><br>Error</h2><br><br>");
			}
	
			out.println("</body>");
			out.println("</html>");
	  }
 }	  
		 
		 