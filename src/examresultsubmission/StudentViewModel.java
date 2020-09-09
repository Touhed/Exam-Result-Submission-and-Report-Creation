package examresultsubmission;

/**
 *
 * @author Touhedur Rahman
 */
public class StudentViewModel 
{
    private int SN;
    private int StudentId;
    private String StudentName;
    private String Department;
    private String Address;
    private String Email;
    private String Contact;

    public StudentViewModel() {
    }

    public StudentViewModel(int SN,int StudentId, String StudentName, String Department, String Address, String Email, String Contact) 
    {
        this.SN = SN;
        this.StudentId = StudentId;
        this.StudentName = StudentName;
        this.Department = Department;
        this.Address = Address;
        this.Email = Email;
        this.Contact = Contact;
    }

    public int getSN() {
        return SN;
    }

    public void setSN(int SN) {
        this.SN = SN;
    }
    
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }
    
    @Override
    public String toString() {
        return "ViewStudent{" + "StudentName=" + StudentName + ", StudentId=" + StudentId + ", Department=" + Department + ", Address=" + Address + ", Email=" + Email + ", Contact=" + Contact +"}";
    }
    
}
