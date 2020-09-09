package examresultsubmission;

/**
 *
 * @author Touhedur Rahman
 */
public class ReportViewModel 
{
    private int StudentId;
    private String StudentName;
    private String Email;
    private String Department;
    private String Subject;
    private String Section;
    private int Marks;

    public ReportViewModel() 
    {
        
    }

    public ReportViewModel(int StudentId, String StudentName, String Email, String Department, String Subject, String Section, int Marks) {
        this.StudentId = StudentId;
        this.StudentName = StudentName;
        this.Email = Email;
        this.Department = Department;
        this.Subject = Subject;
        this.Section = Section;
        this.Marks = Marks;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String Section) {
        this.Section = Section;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int Marks) {
        this.Marks = Marks;
    }
    
    @Override
    public String toString() 
    {
        return "Report{" + "StudentName=" + StudentName + ", StudentId=" + StudentId + ", Email =" + Email + ", Department =" + Department + ",+ Subject = "+Subject+", Section =" + Section + ", Marks =" + Marks +'}';
    }
    
}
