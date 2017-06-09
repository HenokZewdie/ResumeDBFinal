import java.sql.*;
import java.util.Scanner;

public class ResumeMainFinal{  
	public static void main(String [] args){  
		try{  

			
			String Response, query;


			Scanner input = new Scanner(System.in); 
			System.out.println("Would you like to add, update, delete or search a record.") ;
			Response = input.next(); 


			Class.forName("com.mysql.jdbc.Driver");  
			//System.out.println("Test connection");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resumeFriday","root","password");  
			PreparedStatement preparedStmt = null;

			switch(Response){

			case "add": ResumeMain resObj = new ResumeMain();
						resObj.add();
						break;
						
			case "update" :
				System.out.println("Enter the Employee ID");
				String EMPID = input.next(); 

				System.out.println("What is the your new name?");
				String update_cname = input.next(); 

				query = ("UPDATE Employee SET name  = ? WHERE Emp_ID = ? ");
				preparedStmt= con.prepareStatement(query); 
				preparedStmt.setString(1, update_cname); 
				preparedStmt.setString(2, EMPID); 

				preparedStmt.executeUpdate();
				System.out.println("All set!");


				break;	

			case "delete":  
			

				System.out.println("What is your Employee ID?");
				int ERLID = input.nextInt(); 

				query = (" Delete FROM Employee WHERE emp_ID = ?");
				preparedStmt= con.prepareStatement(query); 

				preparedStmt.setInt(1, ERLID);

				preparedStmt.executeUpdate();
				System.out.println("The Employee has been removed!"); 

				break;

			case "search": 

				System.out.println("Enter Employee ID:  ");
				int IDo = input.nextInt();
				//preparedStmt.setInt(1, IDo);
				query = ("SELECT * FROM Employee WHERE Emp_ID = "+IDo+";");
				Statement stmt=con.createStatement();  // to provide methods to execute different SQL queries
				
				ResultSet rs=stmt.executeQuery(query);  //cursor pointer to the row of the table
				
				//executeQuery: to execute the select query
				while(rs.next()){  // from the current pointer till the end of the table
					System.out.println(rs.getInt(1)+"  \t"+rs.getString(2)
					+" \t"+rs.getString(3) + "\t" + rs.getString(4) +"\t" + rs.getString(5)
				); } 
				con.close();  
		
				break; 

			}

			input.close();
			con.close(); 
		}catch(Exception e){ System.out.println(e);}  

	}  
}  