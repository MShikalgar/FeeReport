
package FeeReport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ac_login extends Accountant
{
    public void login()
    {
            Scanner sc= new Scanner(System.in);
            try
            {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/feereport?useUnicode=true&usefeereportCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            System.out.println("User name: ");
            String u_name=sc.next();
            System.out.println("Password: ");
            String u_pass=sc.next();
            PreparedStatement psl=con.prepareStatement("Select * from accountant where name=? and password=?");
            psl.setString(1,u_name);
            psl.setString(2,u_pass);
            ResultSet rs=psl.executeQuery();
            if(rs.next())
            {
                name=rs.getString(2);
                password=rs.getString(3);
            }
            if(u_name.equals(name) && u_pass.equals(password))
            {
                while(true)
                {
                System.out.println("\t\t----Accountant Section----");
                System.out.println("1.Add Student");
                System.out.println("2.Edit Student");
                System.out.println("3.Delete Student");
                System.out.println("4.Logout");  
                    System.out.println("\nPlease enter your choice: ");
                    int choice=sc.nextInt();
                    Ac_section e= new Ac_section();
                    Student s= new Student();
                    switch(choice)
                    {
                        case 1: System.out.println("\t\nADD STUDENT");
                            System.out.println("Student Id: ");
                            int id=sc.nextInt();
                            System.out.println("Student Name: ");
                            String name=sc.next();
                            System.out.println("Course: ");
                            String course= sc.next();
                            System.out.println("Fees: ");
                            int fees=sc.nextInt();
                            System.out.println("Paid: ");
                            int paid=sc.nextInt();
                            System.out.println("Due: ");
                            int due=sc.nextInt();
                            System.out.println("Address: ");
                            String addr=sc.next();
                            System.out.println("Contact: ");
                            String contact=sc.next();
                            s=new Student(id,name,course,fees,paid,due,addr,contact);
                            int status = e.Add_Stu(s);
                            if(status>0)
                               {
                                System.out.println("New Student successfully added");
                               }
                            else
                            {
                             System.out.println("Failed!!! Please try again");
                            }
                            break;
                            
                        case 2: 
                            System.out.println("Update the details");
                            System.out.println("Student Id: ");
                            id=sc.nextInt();
                            System.out.println("Student Name: ");
                            name=sc.next();
                            System.out.println("Course: ");
                            course= sc.next();
                            System.out.println("Fees: ");
                            fees=sc.nextInt();                            
                            System.out.println("Paid: ");
                            paid=sc.nextInt();
                            System.out.println("Due: ");
                            due=sc.nextInt();
                            System.out.println("Address: ");
                            addr=sc.next();
                            System.out.println("Contact: ");
                            contact=sc.next();
                            s=new Student(id,name,course,fees,paid,due,addr,contact);
                            status = e.Add_Stu(s);
                            if(status>0)
                               {
                                System.out.println("Update Successful ");
                               }
                            else
                            {
                             System.out.println("Failed!!! Please try again");
                            }
                            break;
                            
                        case 3:
                            System.out.println("Please enter the id of the Student to be deleted: ");
                            id=sc.nextInt();
                            status = e.Delete_Stu(id);
                            if(status>0)
                            {
                            System.out.println("Student successfully deleted");
                            }
                            else
                            {
                            System.out.println("Failed!! Please try again");
                            }
                            break;
                            
                        case 4:
                            Open f=new Open();
                            f.Fee_report();      
                            break;
                    }
                }
            }
            else
            {
                System.out.println("Login Failed");
            }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }    
     }
}
            
