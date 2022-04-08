package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_Ctrl {
	
	//method that input student details
	public void inputData (Student stu) throws SQLException{
		
		//establish connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1" ,"root","11271127");	
		Statement s = conn.createStatement();  
		
		//insert query
		s.executeUpdate("insert into student values('"+ stu.getStuID()+"','"+stu.getName()+"','"+stu.getEmail()+"','"+stu.getMath_m()+"','"+stu.getSc_m()+"')"); 
		System.out.print("\nData saved to database successfully!\n");
		
	}
	
	//method that display student details based on stuID
	public void getStudent(int stuID) throws SQLException {
		Student stu= new Student();
		
		// establish connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1" ,"root","11271127");	
		Statement s = conn.createStatement(); 
		
				//
				ResultSet rs = s.executeQuery ("select * from student where stuID= '"+stuID+"'"); 
				
				//pass data retrieved from view into model 
				if(rs.next()) {
					stu.setStuID(rs.getInt("stuID"));
					stu.setName(rs.getString("name"));
					stu.setEmail(rs.getString("email"));
					stu.setMath_m(rs.getInt("math_m"));
					stu.setSc_m(rs.getInt("sc_m"));
				}
		
		Student_UI view= new Student_UI();
		view.displayData(stu.getStuID(), stu.getName(), stu.getEmail(), stu.getMath_m(), stu.getSc_m());
		}

}
