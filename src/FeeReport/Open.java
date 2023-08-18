package FeeReport;

import java.util.Scanner;

public class Open 
{
    public void Fee_report()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
          System.out.println("\t\t-------FEE REPORT-------");
          System.out.println("\n1.Admin Login");
          System.out.println("2.Accountant Login");
          System.out.println("3.Exit");
          System.out.println("\nPlease enter your choice: ");
          int choice=sc.nextInt();
          Ad_login ad=new Ad_login();
          Ac_login ac=new Ac_login();
          switch(choice)
            {
                case 1: ad.login();    
                        break;
                case 2: ac.login();
                        break;
                case 3: System.exit(0);
                        break;
            }
        }
    }
    public static void main(String[] args)
    {
        Open f=new Open();
        f.Fee_report();      
    }
}
