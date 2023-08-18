
package FeeReport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ad_login
{
    String u_name,u_pass;
    public  void login()
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("User Name: ");
       String u_name=sc.nextLine();
       System.out.println("Password: ");
       String u_pass=sc.next();
       
            if(u_name.equals("admin") && u_pass.equals("admin123"))
            {
                while(true)
                {
                System.out.println("\t\t----Admin Section----");
                System.out.println("\n1.Add Acountant");
                System.out.println("2.Update Accountant");
                System.out.println("3.Delete Accountant ");
                System.out.println("4.Logout");
                System.out.println("Please enter your choice: ");
                int choice=sc.nextInt();
                Ad_section e= new Ad_section();
                Accountant a= new Accountant();
                switch(choice)
                {
                    case 1: 
                    System.out.println("Id: ");
                    int id=sc.nextInt();
                    System.out.println("Name: ");
                    String name=sc.next();
                    System.out.println("Password: ");
                    String password=sc.next();
                    System.out.println("Email: ");
                    String email=sc.next();
                    System.out.println("Contact: ");
                    String contact=sc.next();
                    a=new Accountant(id,name,password,email,contact);
                    int status = e.Add_Acc(a);
                    if(status>0)
                    {
                        System.out.println("New Accountant successfully added");
                    }
                    else
                    {
                        System.out.println("Failed!! Please try again");
                    }
                    break;
                    
                    case 2:
                        System.out.println("Update the details");
                        System.out.println("Id: ");
                        id=sc.nextInt();
                        System.out.println("Name: ");
                        name=sc.next();
                        System.out.println("Password: ");
                        password=sc.next();
                        System.out.println("Email: ");
                        email=sc.next();
                        System.out.println("Contact: ");
                        contact=sc.next();
                        a=new Accountant(id,name,password,email,contact);
                        status=e.Update_emp(a);
                        if(status>0)
                        {
                        System.out.println("Update successful");
                        }
                    else
                        {
                        System.out.println("Update Failed!!!");
                        }
                        break;
                        
                    case 3: 
                        System.out.println("Please enter the id of the accountant to be deleted: ");
                        id=sc.nextInt();
                        status = e.Delete_Acc(id);
                        if(status>0)
                        {
                        System.out.println(" Accountant successfully deleted");
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
}
