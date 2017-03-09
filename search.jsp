<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.File" %>


<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>pied - Free CSS Template by ZyPOP</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<!--
pied, a free CSS web template by ZyPOP (zypopwebtemplates.com/)

Download: http://zypopwebtemplates.com/

License: Creative Commons Attribution
//-->
<script>
var request=new XMLHttpRequest();
function searchInfo(){
var name=document.vinform.name.value;
var url="Search?val="+name;

try{
request.onreadystatechange=function(){
if(request.readyState==4){
var val=request.responseText;
document.getElementById('mylocation').innerHTML=val;
}
}//end of function
request.open("GET",url,true);
request.send();
}catch(e){alert("Unable to connect to server");}
}
</script>
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>MEET-A-MATE</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,900,500' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,800,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

  </head>
  <body>

    <!--________________________ NAVBAR__________________________-->

    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">

        <div class="navbar-header">

          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>


          </button>

          <a class="navbar-brand" href="#">
            <div class="logo">
              <img src="img/social.png" class="img-responsive" href="#slider" alt="Responsive image" width="110" height="auto">
            </div>
        </a>

        </div>
 
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
		  <% session = request.getSession();%>
            <%if (session.getAttribute("user")!=null)
			{
			
			out.println("<li><a href='MyProfile'>HI,");
			%>
			<%= session.getAttribute("username")%>
			<%
			out.println("</a></li>");
			out.println("<li><a href='Products'>Products</a></li>");
			out.println("<li><a href='PostActivity'>Post Activity</a></li>");
			out.println("<li><a href='search.jsp'>Search</a></li>");
			out.println("<li><a href='Logout.jsp'>Logout</a></li>");
						
            
			}
			else
			{
				out.println("<li><a href='services' id='link2'>SERVICES</a></li>");
			out.println("<li><a id='link1' href='Search'>SEARCH</a></li>");
            out.println("<li><a href='#contact' id='link4'>CONTACT US</a></li>");
			  out.println("<li><a href='SignIn.html' id='link4'>SIGN IN</a></li>");
			   out.println("<li><a href='SignUp.html' id='link5'>REGISTER</a></li>");
			}
				
         %>
          </ul>
        </div>
      </div>
    </div>
 
  <!--________________________ NAVBAR__________________________--><br><br><br><br><br><br>
<h4 align="center">Meet-A-Mate provides dynamic search. Just start searching by entering an activity or sub-activity. <h4>
<h4 align="center">Search keyword here</h4>
<form align="center" name="vinform" action="Search">
<input type="text" name="name" onkeyup="searchInfo()">
</form>

<span id="mylocation"></span>
</section>


	<div class="post">
	
	<p><h1>Popular EVENTS in CHICAGO.</h1></p>
	<%String line=null;
	int k=0;
		
  			while(k<1)
  			{
  				BufferedReader reader=new BufferedReader(new FileReader(new File("C:/apache-tomcat-7.0.34/webapps/Social2/DealMatches.txt")));
  				line=reader.readLine();
  				System.out.println(line);
				int p=0;
  				if(line==null)
  				{%>
  					<h2 align='center'>NO EVENTS happening right now</h2>
  					<%break;
  				}
  				else
  				{
  					
  					do
  					{
						      if(p<5)
							  {%>
							<h3><%out.println(line);%></h3>
  							<br>
  							
  							<%
							p++;
  						      }
							  
							  else
							  {
							  break;
							  }
  						
  					}while((line=reader.readLine()) !=null);
  					
  				}
         k++;
		}%>

</body>
</html>