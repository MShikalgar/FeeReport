
package FeeReport;

public class Accountant 
{
    String name,email,password,contact;
    int id;
    Accountant(int id,String name,String password,String email,String contact)
    {
        this.id=id;
        this.name=name;
        this.password=password;
        this.email=email;
        this.contact=contact;
    }
    Accountant()
    {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}