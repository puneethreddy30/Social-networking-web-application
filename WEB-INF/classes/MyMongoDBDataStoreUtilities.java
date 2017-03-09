
import com.mongodb.DBCursor;  
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import org.bson.Document;
import com.mongodb.BasicDBObject;



public class MyMongoDBDataStoreUtilities
{
	public  DBCursor ReviewsViewing(BasicDBObject myreviewdocument) 
	{
		DBCursor cursor1=null;
		try 
		{
			MongoClient mongo = getConnection();
			DB db = mongo.getDB("ReviewsSocial");
			DBCollection Productreviews = db.getCollection("RentedProducts");
			cursor1 = Productreviews.find(myreviewdocument);
			System.out.println(cursor1);
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cursor1;
	}

	
	
	
	public boolean Reviewinsertion(BasicDBObject myreviewdocument) 
	{
		try 
		{
			MongoClient mongo = getConnection();
			DB db = mongo.getDB("ReviewsSocial");
			DBCollection Productreviews = db.getCollection("RentedProducts");
			Productreviews.insert(myreviewdocument);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static MongoClient getConnection()
	{
		MongoClient mongo = null;
		try 
		{
			mongo= new MongoClient("localhost", 27017);
			DB db= mongo.getDB("ReviewsSocial");
			DBCollection Productreviews= db.getCollection("RentedProducts");
		}
		catch (Exception e) 
		{
				System.out.println("Error Message");
		}
	return mongo;
	}
	
}