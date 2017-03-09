import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;





public class WriteReviews extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

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
	
	

		out.println("<form method = 'get' action = 'SubmitReviews'>");
		out.println("<hr>");
	
				out.println("<table>");		
				out.println("<tr>");
				out.println("<td> Product Model Name :-</td>");
				out.println("<td><input type='text' name='ModelName' required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td> Product Code :-</td>");
				out.println("<td> <input type='text' name='productcode' required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td> Rental Price :-</td>");
				out.println("<td><input type='text' name='rentalprice' required> </td>");
				out.println("</tr>");
	
				//out.println("</tr></table>");
				 Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String DATE_FORMAT = "MM/dd/yyyy"; 
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);				
		String todaydate = sdf.format(date);
		
				
				
				out.println("<h1>Reviews:</h1>");
		
			out.println("<tr>");
				out.println("<td> User Id:-</td>");
				out.println("<td><input type='text' name='userid' /></td>");
				out.println("</tr>");
				
			out.println("<tr>");
				out.println("<td> User Age:-</td>");
				out.println("<td><input type='text' name='age'/></td>");
				out.println("</tr>");
	
			out.println("<tr>");
				out.println("<td> User Gender:-</td>");
				out.println("<td><select name='gender'><option value='Male' selected>Male</option><option value='Female'>Female</option></select></td>");
				out.println("</tr>");
    
			out.println("<tr>");
				out.println("<td> User Occupation:-</td>");
				out.println("<td><input type='text' name='occupation'/></td>");
				out.println("</tr>");
	
            out.println("<tr>");
				out.println("<td> Review Rating:-</td>");
				out.println("<td><select name='rating'><option value='1' >1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5' selected>5</option></select></td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td> Review Date-</td>");
				out.println("<td><input type='text' name='reviewdate'/></td>");
				out.println("</tr>");
				
            
				out.println("<tr>");
				out.println("<td> Review Text:-</td>");
				out.println("<td><textarea name='review' rows='4' cols='50'/></textarea></td>");
				out.println("</tr>");
				out.println("<tr><td align='left' ><input type='submit' value='Submit'></td></tr>");
			out.println("</table>");
			out.println("</form>");
	  }
}
