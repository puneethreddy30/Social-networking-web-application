
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MySqlDataStoreUtilities
{
	
	public boolean checkRent(String username,String productname)
	    {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase", "root", "root");
	            String checkLikes = "Select rent from RentNlikeProdUserUpdate where uname=? and productname=?";
				
	            PreparedStatement pst = conn.prepareStatement(checkLikes);
	            pst.setString(1, username);
				pst.setString(2, productname);
	            ResultSet resultSet = pst.executeQuery();
				if(resultSet.next())
				{
					return true;
				}
				else
					return false;
				
				
	          } 
	        catch (ClassNotFoundException | SQLException e) {
	            return false;
	        }
			
	    }
		
		public boolean insertRent(String productname,String username)
	    {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
				boolean a=true;
				boolean b=false;
	            
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase", "root", "root");
	            String checkRent = "Insert into RentNlikeProdUserUpdate VALUES(?,?,?,?)";
				
	            PreparedStatement pst = conn.prepareStatement(checkRent);
	            pst.setString(1, username);
				pst.setString(2, productname);
				pst.setBoolean(3,a );
				pst.setBoolean(4,b);
	            pst.executeUpdate();
				return true;
				
				
	          } 
	        catch (ClassNotFoundException | SQLException e) {
	            return false;
	        }
	    }			

	

		
	public boolean checkLike(String username,String productname)
	    {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase", "root", "root");
	            String checkLikes = "Select likes from RentNlikeProdUserUpdate where uname=? and productname=?";
				
	            PreparedStatement pst = conn.prepareStatement(checkLikes);
	            pst.setString(1, username);
				pst.setString(2, productname);
	            ResultSet resultSet = pst.executeQuery();
				if(resultSet.next())
				{
					return true;
				}
				else
					return false;
				
				
	          } 
	        catch (ClassNotFoundException | SQLException e) {
	            return false;
	        }
			
	    }


    public boolean insertliked(String productname,String username)
	    {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
				boolean a=false;
				boolean b=true;
	            
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase", "root", "root");
	            String checkLikes = "Insert into RentNlikeProdUserUpdate VALUES(?,?,?,?)";
				
	            PreparedStatement pst = conn.prepareStatement(checkLikes);
	            pst.setString(1, username);
				pst.setString(2, productname);
				pst.setBoolean(3,a );
				pst.setBoolean(4,b);
	            pst.executeUpdate();
				return true;
				
				
	          } 
	        catch (ClassNotFoundException | SQLException e) {
	            return false;
	        }
	    }			
	
	
	
	
	
	public boolean ProductLikeUpdate(String productid)
	    {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase", "root", "root");
	            String updateLikes = "UPDATE AllProducts SET likes=likes+1 where productcode=?";
				//String insertlike= "Insert into RentNlikeProdUserUpdate VALUES(?,?,?,?)";
	            PreparedStatement pst = conn.prepareStatement(updateLikes);
	            pst.setString(1, productid);
	            pst.executeUpdate();
	            
	          return true; 
	        } 
	        catch (ClassNotFoundException | SQLException e) {
	            
	        }
	         return false;
	    }					
			
	public boolean Loaddata(Map<String,List<String>> mymap)
    {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase", "root", "root");
            for (Map.Entry<String, List<String>> entry : mymap.entrySet()) 
       		 {
       	            String key1productcode = entry.getKey();
       	            int k=0;
       	           List<String> values = entry.getValue();
       	           String category=values.get(k);
       	           String productname=values.get(k+1);
       	           String rentalprice=values.get(k+2);
                   String description=values.get(k+3);
    	           Integer quantity=Integer.parseInt(values.get(k+4));
    	           
       	           
       	        	String querytoinsertinfo = "INSERT INTO ProductsXML (category,productcode,productname,rentalprice,description,quantity) VALUES (?,?,?,?,?,?)";
       	        	PreparedStatement pst = conn.prepareStatement(querytoinsertinfo);
       	        	pst.setString(1,category);
       	        	pst.setString(2,key1productcode);
       	        	pst.setString(3,productname);
    
       	        	pst.setString(4,rentalprice);
       	            pst.setString(5,description);
       	        	pst.setInt(6,quantity);
       	        	
       	        	pst.execute();
       	        
       	  } 
         }     
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         return false;
    }		
	
	
	 public List<List> Fetchproductlist() 
	 {
        List<List> CategoryItems = new ArrayList<List>();
           
        try {
              Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialdatabase", "root", "root");
            String fetchproduct = "SELECT productcode,productname,rentalprice,description,quantity FROM productsxml";
            PreparedStatement pst = conn.prepareStatement(fetchproduct);
            ResultSet resultSet = pst.executeQuery();
            
              int count2=-1;
              
            
            while(resultSet.next())
            {   
                
                count2++;
                ArrayList CatItems = new ArrayList();
                for(int i=0;i<5;i++)    
                {
                 CatItems.add(i, resultSet.getString(i+1));
                }
                
                CategoryItems.add(CatItems);
                
            }
           
  
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        
        return CategoryItems;
    }
    
    
}