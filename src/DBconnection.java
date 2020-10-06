
import java.sql.*;
public class DBconnection {
	static Connection con=null;
	public static Connection connectiondb(){
	
	try {
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mticket","root", "");
	if (!con.isClosed())
	System.out.println("Successfully connected to MySQL server...");
	return con;
	} catch(Exception e) {
	System.err.println("Exception: " + e.getMessage());
	return null;
	} 
	
	}

}
