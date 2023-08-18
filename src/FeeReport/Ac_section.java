
package FeeReport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ac_section 
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
    public int Add_Stu(Student s)
    {
        int status=0;
        Connection c1=getConnection();
        try
        {
            PreparedStatement ps;
            ps=c1.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getFees());
            ps.setInt(5, s.getPaid());
            ps.setInt(6, s.getDue());
            ps.setString(7,s.getAddr());
            ps.setString(8,s.getContact());
        
            status=ps.executeUpdate();
            c1.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return status;
    }
    public int Update_Stu(Student s)
    {
        int status=0;
        Connection c2=getConnection();
        try
        {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/feereport?useUnicode=true&usefeereportCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                PreparedStatement ps=c2.prepareStatement("update student set name=?"
                   +"course=?,fees=?,paid=?,due=?,addr=?,contact=? where id=?");
        
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setInt(3, s.getFees());
            ps.setInt(4, s.getPaid());
            ps.setInt(5, s.getDue());
            ps.setString(6,s.getAddr());
            ps.setString(7,s.getContact());
            ps.setInt(1, s.getId());
            
            status=ps.executeUpdate();
        }
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        return status;
    }
    public int Delete_Stu(int  c)
  {
      int status=0;
      Connection c2=getConnection();
        try
        {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/feereport?useUnicode=true&usefeereportCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                PreparedStatement ps=c2.prepareStatement("delete from student Where Stud_id=?");
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
