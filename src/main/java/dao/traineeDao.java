package dao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.trainee;
public class traineeDao {

	
	public int registerTrainee(trainee traine)throws ClassNotFoundException{
		String Insert_user="INSERT INTO trainee"+
	"(idtrainee,first_name,last_name,username,password,address,contact)"+"VALUES(?,?,?,?,?,?,?);";
	
	   int result=0;
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   
	   try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useSSL=false","root","Roshni@2003");
			   
			   PreparedStatement stmt=connection.prepareStatement(Insert_user))
	   {
		   stmt.setInt(1,1);
		      stmt.setString(2, traine.getFirstName());
		      stmt.setString(3, traine.getLastName());
		      stmt.setString(4, traine.getUsername());
		      stmt.setString(5, traine.getPassword());
		      stmt.setString(6, traine.getAddress());
		      stmt.setInt(7, traine.getContact());
		      
		      System.out.println(stmt);
		      // Execute the query
		      result=stmt.executeUpdate();
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
			   
	  return result;
	
	}
}
