package examresultsubmission;

/**
 *
 * @author Touhedur Rahman
 */
public class StudentInfo 
{
    private  String name;
    private  int id;
    private  String department;
    private  String address;
    private  String contact;
    private  String email;

    public StudentInfo(String name, int id, String department, String address, String contact, String email) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public StudentInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     @Override
    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + ", department=" + department + ", address=" + address + "', contact=" + contact + ", email=" + email + '}';
    }
}
