package examresultsubmission;
/**
 *
 * @author Touhedur Rahman
 */
public class TranscriptViewModel 
{
    private int SN;
    private int Id;
    private String Name;
    private String Subject;
    private String Section;
    private int Marks;

    public TranscriptViewModel() {
    }

    public TranscriptViewModel(int SN,int Id, String Name, String Subject, String Section, int Marks) 
    {
        this.SN = SN;
        this.Id = Id;
        this.Name = Name;
        this.Subject = Subject;
        this.Section = Section;
        this.Marks = Marks;
    }
    
    public int getSN() {
        return SN;
    }

    public void setSN(int SN) {
        this.SN = SN;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
    public String toString() {
        return "ViewTranscript{" + "Name=" + Name + ", Id=" + Id + ", Subject=" + Subject + ", Section=" + Section + "', Marks=" + Marks + "}";
    }
    
}
