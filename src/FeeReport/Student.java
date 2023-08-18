
package FeeReport;

public class Student 
{
    int id,fees,paid,due;
    String name,course,contact,addr;
    Student(int id,String name,String course,int fees,int paid,int due,String addr, String contact)
    {
        this.id=id;
        this.name=name;
        this.course=course;
        this.fees=fees;
        this.paid=paid;
        this.due=due;
        this.addr=addr;
        this.contact=contact;
    }
    Student()
    {
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
}
