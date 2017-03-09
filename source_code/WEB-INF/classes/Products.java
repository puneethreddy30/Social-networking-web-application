
import java.sql.*;
import java.io.*;
//import bd.MySqlDataStoreUtilities; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import org.xml.sax.SAXException;
import java.util.HashMap;
import java.io.File;
import java.net.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





public class Products extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
		  HttpSession session = request.getSession();

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
        String user1= (String) session.getAttribute("username");
        out.println("<div class='navbar-collapse collapse'>");
          out.println("<ul class='nav navbar-nav navbar-right'>");
            out.println("<li><a href='MyProfile'>Hi, "+user1+"</a></li>");
out.println("<li><a href='Products' id='link4'>Products</a></li>");
            out.println("<li><a href='PostActivity' id='link4'>Post Activity</a></li>");
			   out.println("<li><a href='search.jsp' id='link4'>Search</a></li>");
			   
			   out.println("<li><a href='Logout.jsp' id='link5'>Logout</a></li>");
         
          out.println("</ul>");
        out.println("</div>");
      out.println("</div>");
    out.println("</div>");
	
	//String infoFile = "Products.xml"; 
	Document infoDoc = null;
	boolean flag=false;
	try {
         //Instantiate the parser and parse the file
         DocumentBuilderFactory docbuilderfactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docbuilder = docbuilderfactory.newDocumentBuilder();
         
         File file = new File("C:/apache-tomcat-7.0.34/webapps/Social/Prod.xml");
		 System.out.println("Hi");
         if(file.exists())
         {
         infoDoc = docbuilder.parse(file); 
		System.out.println("Hi");		 
         Element docEle = infoDoc.getDocumentElement();
         System.out.println(("Root element of the document: " + docEle.getNodeName()));
         
         NodeList ProdList = docEle.getElementsByTagName("Products");
         System.out.println("Total Products: " + ProdList.getLength());
         int k=ProdList.getLength();
         if (k > 0) 
         {
        	 for (int i = 0; i < ProdList.getLength(); i++) 
        	 {
        		 Node a=ProdList.item(i);
        		 if(a.getNodeType()==Node.ELEMENT_NODE)
        		 {
        			 HashMap<String,List<String>> hMap=new HashMap<String, List<String>>();
        			 List<String> val = new ArrayList<String>();
        		     System.out.println("=====================");
        		     Element e = (Element) a;
					 NodeList nodeList = e.getElementsByTagName("productcode");
					
					String productcode=nodeList.item(0).getChildNodes().item(0).getNodeValue();
					System.out.println("productcode: "+ productcode);

					nodeList = e.getElementsByTagName("category");
					val.add(nodeList.item(0).getChildNodes().item(0).getNodeValue());
					//System.out.println("Age: "+ values);
					
					nodeList = e.getElementsByTagName("productname");
					val.add(nodeList.item(0).getChildNodes().item(0).getNodeValue());
					//System.out.println("Gender: "+ values);
					
					nodeList = e.getElementsByTagName("rentalprice");
					val.add(nodeList.item(0).getChildNodes().item(0).getNodeValue());
					
					nodeList = e.getElementsByTagName("description");
					val.add(nodeList.item(0).getChildNodes().item(0).getNodeValue());
					
					nodeList = e.getElementsByTagName("quantity");
					val.add(nodeList.item(0).getChildNodes().item(0).getNodeValue());
					
					
					hMap.put(productcode,val);
					MySqlDataStoreUtilities mySqlDataStoreUtilities;
					mySqlDataStoreUtilities = new MySqlDataStoreUtilities();
					flag = mySqlDataStoreUtilities.Loaddata(hMap);
					
        		 }    
					
        	 }
        	 k--;
         }
         
        }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
	  
	  
	  
	  out.println("<table>");

	  
	  
	  String user=(String) session.getAttribute("username");
	  System.out.println("--------------------------------");
	  System.out.println(user);
	  
		
		MySqlDataStoreUtilities mySqlDataStoreUtilities;
  		mySqlDataStoreUtilities = new MySqlDataStoreUtilities();
		//boolean flaglike=mySqlDataStoreUtilities.checkLike(user);
  		List<List> detailsproduct = mySqlDataStoreUtilities.Fetchproductlist();
  		
  		for (List order: detailsproduct)
  		{
  			
  			out.println("<tr>");
  			out.println("<td><img src = 'img/"+order.get(1)+".jpg' width = '200' height = '200' alt = 'Product Model'></td>");
  			out.println("<td><p>Specifications <br>Model Name:" +order.get(1)+ "<br>Description: "+order.get(3)+"<br><br></p></td>");
			
			
			String abc=(String) order.get(1);
			System.out.println(abc);
			
  			out.println("<td>");
  			out.println("<form class = 'submit-button' method = 'get'>");
  			out.println("<input class = 'submit-button' type = 'submit' name = 'Smartphone_Original' value = 'Rent Item'>");
  			//out.println("<input type='hidden' name='model' value='"+order.get(1)+"'>");
  			//out.println("<input type='hidden' name='price' value='"+order.get(2)+"'>");
  			//out.println("<input type='hidden' name='quantity' value='"+1+"'>");
  			out.println("</form>");
			
			
			if (mySqlDataStoreUtilities.checkLike(user,abc))
			{
			out.println("<form class = 'submit-button' method = 'get' action = 'Likes'>");
			out.println("<input class = 'submit-button' type = 'submit' name = 'Smartphone_Original' value = 'Liked'>");
			//out.println("<input type='hidden' name='productid' value='"+order.get(0)+"'>");
			//out.println("<input type='hidden' name='productname' value='"+order.get(1)+"'>");
			out.println("</form>");
			}
			else
			{
				out.println("<form class = 'submit-button' method = 'get' action = 'Likes'>");
			out.println("<input class = 'submit-button' type = 'submit' name = 'Smartphone_Original' value = 'Like this Product'>");
			out.println("<input type='hidden' name='productid' value='"+order.get(0)+"'>");
			out.println("<input type='hidden' name='productname' value='"+order.get(1)+"'>");
			out.println("</form>");
			}
		    
			out.println("<form class = 'submit-button' method = 'get' action = 'ViewReviews'>");
			out.println("<input class = 'submit-button' type = 'submit' name = 'Product_Original' value = 'View Reviews'>");
			out.println("<input type='hidden' name='productid' value='"+order.get(0)+"'>");
			out.println("<input type='hidden' name='productname' value='"+order.get(1)+"'>");
			out.println("</form>");
			
			
			out.println("<form class = 'submit-button' method = 'get' action = 'WriteReviews'>");
			out.println("<input class = 'submit-button' type = 'submit' name = 'Product_Original' value = 'Write Review'>");
			out.println("<input type='hidden' name='Item' value='"+order.get(0)+"'>");
			out.println("</form>");
			out.println("</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		
	
	out.println("</body>");
	out.println("</html>");
	
	

out.println("<script>");

out.println("</script>");
out.println("</html>");

	  }
}