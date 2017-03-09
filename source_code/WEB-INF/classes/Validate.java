import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String uname,String pass) 
     {
      //boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/socialdatabase","root","root");
         PreparedStatement ps =con.prepareStatement
                             ("select uname,password from register where uname=? and password=?");
         ps.setString(1, uname);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         if (rs.next()) {
                con.close();
               return  true;
             
            } 
            else {
                con.close();
                return false;
            }
        
      }
	  catch(Exception e)
      {
          e.printStackTrace();
      }
         return false;                 
  }   
}