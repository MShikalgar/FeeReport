
package FeeReport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ad_section 
{  
    Connection con;
    public  Connection getConnection()
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/feereport?useUnicode=true&usefeereportCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            return con;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public int Add_Acc(Accountant e)
    {
        int status=0;
        Connection c1=getConnection();
        try
        {
            PreparedStatement ps;
            ps=c1.prepareStatement("insert into accountant values(?,?,?,?,?)");
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getPassword());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getContact());
        
            status=ps.executeUpdate();
            c1.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return status;
    }
    public int Update_emp(Accountant e)
    {
        int status=0;
        Connection c2=getConnection();
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/feereport?useUnicode=true&usefeereportCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            PreparedStatement ps=c2.prepareStatement("update accountant set name=?"
             +",password=?,email=?,contact=? where id=?");
            ps.setString(1,e.getName());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getContact());
            ps.setInt(5, e.getId());
            status=ps.executeUpdate();
         }
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }

      return status;
  }
public int Delete_Acc(int  c)
  {
      int status=0;
      Connection c2=getConnection();
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/feereport?useUnicode=true&usefeereportCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            PreparedStatement ps=c2.prepareStatement("delete from accountant Where id=?");
            ps.setInt(1,c);
             
            status=ps.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return status;
  }
}
    
    
    