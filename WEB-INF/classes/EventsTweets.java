

import java.io.IOException;    
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.io.*;
import java.lang.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EventsTweets extends HttpServlet  {

	
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
throws ServletException, IOException {

		

PrintWriter out = response.getWriter();
response.setContentType("text/html;charset=UTF-8");
out.println("<html><head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
out.println("<body>");

try
{
	out.println("<div class='post'>");
	
	out.println("<p><h1>Popular EVENTS in CHICAGO.</h1></p>");
	String line=null;
	boolean flag=true;
	//ArrayList CategoryItems = new ArrayList();
		int k=0;
		
  			while(k<5)
  			{
  				BufferedReader reader=new BufferedReader(new FileReader(new File("C:/apache-tomcat-7.0.34/webapps/Social2/DealMatches.txt")));
  				line=reader.readLine();
  				System.out.println(line);
  				if(line==null)
  				{
  					out.println("<h2 align='center'>NO EVENTS happening right now</h2>");
  					break;
  				}
  				else
  				{
  					
  					do
  					{
  							//out.println("<h3>"+line.substring(0, index)+"<a href="+line.substring(index,line.length())+">"+line.substring(index,line.length())+"</a></h3>");
  							out.println("<h3>"+line+"</h3>");
  							out.println("<br>");
  							
  							break;
  						
  						
  					}while((line=reader.readLine()) !=null);
  					
  				}
         k++;
		}

  	}
catch(Exception e)
{
	System.out.println(e);
}

out.println("</div>");	
out.println("</body>");	
out.println("</html>");	

}


	
}
