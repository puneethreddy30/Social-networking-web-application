import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String email = request.getParameter("uname");
        String pass = request.getParameter("pass");
		
        if(email.equals("admin")&&pass.equals("admin"))
		{
			RequestDispatcher rs = request.getRequestDispatcher("Admin");
            rs.forward(request, response);
		}
        else if(Validate.checkUser(email, pass))
        {
			String uname = (String) request.getParameter("uname");
			session.setAttribute("username", uname);
            RequestDispatcher rs = request.getRequestDispatcher("Home");
            rs.forward(request, response);
        }
        else
        {
           RequestDispatcher rs = request.getRequestDispatcher("SignIn.html");
           rs.include(request, response);
		   out.println("Username or Password incorrect");
        }
		
		
    }  
}