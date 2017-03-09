
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
 
 
 
 public class SubmitReviews extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	
		 
		  boolean flag=false;
		 try
		   {
			
		     
		     HttpSession session1=request.getSession(true);
		     String productname=request.getParameter("ModelName");
			 String productcode=request.getParameter("productcode");
			 String rentalprice=request.getParameter("rentalprice");
			 
			 String userid=request.getParameter("userid");
			 String age=request.getParameter("age");
			 String gender=request.getParameter("gender");
			 String occupation=request.getParameter("occupation");
			 String rating=request.getParameter("rating"); 
			 String reviewdate=request.getParameter("reviewdate");
			 String review=request.getParameter("review");
			 
			 
			 			 
			 BasicDBObject myreviewdocument= new BasicDBObject();
			myreviewdocument.put("PRODUCT_NAME",productname);
			  myreviewdocument.put("PRODUCT_CODE",productcode); 
			 myreviewdocument.put("RENTAL_PRICE",rentalprice);
			 myreviewdocument.put("USER_ID",userid);
			 myreviewdocument.put("AGE",age);
			 myreviewdocument.put("GENDER",gender);
			 myreviewdocument.put("OCCUPATION",occupation);
			 myreviewdocument.put("RATING",rating);
			 myreviewdocument.put("REVIEW_DATE",reviewdate);
			 myreviewdocument.put("REVIEW_TEXT",review);
			 
			 ServletContext context = request.getSession().getServletContext();
			 MyMongoDBDataStoreUtilities myMongoDBDataStoreUtilities;
			 myMongoDBDataStoreUtilities = new MyMongoDBDataStoreUtilities();
			 flag= myMongoDBDataStoreUtilities.Reviewinsertion(myreviewdocument);
			 
			 if(flag=true)
			   {
			 	RequestDispatcher rd = request.getRequestDispatcher("Home");
			 	rd.forward(request, response);
			 	out.println("<h3><br><br>The Review has been added successfully </h3><br><br>");
			   } 
				
			} 
			catch (Exception e) 
			{
				out.println("<h3><br><br>Error</h3><br><br>");
			}
			
	  }
 }	  
	
              		 