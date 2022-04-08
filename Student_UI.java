package assignment2;

import java.sql.SQLException;
import java.util.Scanner;

public class Student_UI {
	public static void main (String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Please choose one of below option:"
				+ "\n1. Input Student Details " +"\n2. Check Student Details" + "\n3. Exit");
		
		int opt= sc.nextInt();
			
			//save data retrieve from view into model
			while(opt!=3) {
			Student stu= new Student();
			if (opt==1) {
				System.out.print("Student ID: ");
				stu.setStuID(sc.nextInt());
				System.out.print("Name: ");
				stu.setName(sc.next());
				System.out.print("Email: ");
				stu.setEmail(sc.next());
				System.out.print("Math Mark: ");
				stu.setMath_m(sc.nextDouble());
				System.out.print("Science Mark: ");
				stu.setSc_m(sc.nextDouble());
				
				Student_Ctrl ctrl= new Student_Ctrl();
				ctrl.inputData(stu);
			}
			
			else if (opt==2) {
				System.out.print("\nEnter Student ID: ");
				int stuID=sc.nextInt();
				Student_Ctrl ctrl= new Student_Ctrl();
				ctrl.getStudent(stuID);
			}
			
			System.out.println("\nPlease choose one of below option:"
					+ "\n1. Input Student Details " +"\n2. Check Student Details" + "\n3. Exit");
			opt= sc.nextInt();
		}
			System.out.print("\nExited the system!");
	}
	
	//method that print out student details
	public void displayData(int stuID,String name,String email,double math_m,double sc_m) {
		System.out.println("\nStudent ID: "+stuID+"\nName: "+name+"\nEmail: "+email +"\nMath Mark: "+math_m+"\nScience Mark: "+sc_m);
		
	}
}
