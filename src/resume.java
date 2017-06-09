

import java.sql.*;
//import java.util.Scanner;
import java.util.ArrayList;

//prompt(name, email, eduAchieve,experiance,skill);
public class resume{  
	public void prompt(String name, String email, ArrayList<String> eduAchieve, ArrayList<String> experiance, ArrayList<String> skill){  
		try{  
		
			//System.out.println(sb);
			Class.forName("com.mysql.jdbc.Driver"); 
			
			//System.out.println("Test");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resumeFriday","root","password");  
			//Statement stmt = con.createStatement();
			String query = ("INSERT into `resumeFriday`.`Employee`(`name`, `email`,`eduAchieve`, `experiance`, skill) VALUES (?,?,?,?,? )");
			//String national = ("INSERT into `Student`.`new_table`(`StudNational`) VALUES  (?)");

			//Convert Education Arraylist to String
			String separator="";
			 StringBuilder educString = new StringBuilder();
			 for (String edu: eduAchieve) {
				 educString.append(separator);
				 educString.append(edu);
				 separator = ", ";
			 }
			 StringBuilder expString = new StringBuilder();
			 separator="";
			 for (String exp: experiance) {
				 expString.append(separator);
				 expString.append(exp);
				 separator = ", ";
			 }
			
			 StringBuilder skillString = new StringBuilder();
			 separator="";
			 for (String ski: skill) {
				 skillString.append(separator);
				 skillString.append(ski);
				 separator = ", ";
			 }
			 
			 
			PreparedStatement ps = con.prepareStatement(query);
			//PreparedStatement psAL = con.prepareStatement(national);
			ps.setString(1, name);	
			ps.setString(2, email);
			ps.setString(3, educString.toString());
			ps.setString(4, expString.toString());
			ps.setString(5, skillString.toString());
			ps.executeUpdate();
			
			  //psAL.executeUpdate(); 
			  
			System.out.println("The Data Inserted Successfully");
			//input.close();
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
}  
