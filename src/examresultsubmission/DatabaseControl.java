package examresultsubmission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Touhedur Rahman
 */
public class DatabaseControl 
{
    Connection dbConnection() throws SQLException
    {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examresult","root","");
        } 
	catch (SQLException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
   
    // Login Account start
    
    ObservableList<AccountViewModel> LoadAccount() throws SQLException
       {
          ObservableList<AccountViewModel> accountlist = FXCollections.observableArrayList();
          
          Connection con = dbConnection();
          
          String query = ("SELECT * FROM admin");
          ResultSet rs=con.createStatement().executeQuery(query);
         
          while(rs.next())
          {
             int userId = rs.getInt("UserId");
             String userName = rs.getString("UserName");
             String email = rs.getString("Email");
             String password = rs.getString("Password");
             String userType = rs.getString("UserType");

             AccountViewModel viewaccount = new AccountViewModel(userId,userName,email,password,userType);
             accountlist.add(viewaccount);
          }
          return accountlist;
       }
       
    String createAccount(AccountViewModel account) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement = con.createStatement();
      
        String query="insert into admin " +"values("+account.getUserId()+",'"+account.getUserName()+"','"+account.getEmail()+"','"+account.getPassword()+"','"+account.getUserType()+"')";
        statement.executeUpdate(query);
        
        if(statement.executeUpdate(query)>0)
        {
            return "New Account Created Successfully";
        }
        else
        {
            return "Failed";
        }
    }
    
    void deleteAccount(ObservableList<AccountViewModel> selectedAccount) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement=con.createStatement();
        
        for(AccountViewModel account:selectedAccount)
        {
            String query="delete from admin where userId = "+account.getUserId();
            statement.executeUpdate(query);
        }
    }
    
    // Student Info start
    
    ObservableList<StudentViewModel> LoadStudent() throws SQLException
       {
          ObservableList<StudentViewModel> studentlist = FXCollections.observableArrayList();
          
          Connection con = dbConnection();
          
          String query = ("SELECT * FROM studentinfo");
          ResultSet rs=con.createStatement().executeQuery(query);
         
          while(rs.next())
          {
             int sn = rs.getInt("SN");
             int studentId = rs.getInt("StudentId");
             String studentName = rs.getString("StudentName");
             String department = rs.getString("Department");
             String address = rs.getString("Address");
             String email = rs.getString("Email");
             String contact = rs.getString("Contact");

             StudentViewModel viewstudent = new StudentViewModel(sn,studentId,studentName,department,address,email,contact);
             studentlist.add(viewstudent);
          }
          return studentlist;
       }
       
    void insertStudent(StudentViewModel studentinfo) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement=con.createStatement();
      
        String query="insert into studentinfo (SN,StudentId,StudentName,Department,Address,Email,Contact) values("+studentinfo.getSN()+","+studentinfo.getStudentId()+",'"+studentinfo.getStudentName()+"','"+studentinfo.getDepartment()+"','"+studentinfo.getAddress()+"','"+studentinfo.getEmail()+"','"+studentinfo.getContact()+"')";
        statement.executeUpdate(query);
        
        if(statement.executeUpdate(query)>0)
        {
            System.out.println("New Student Added Successfully");
        }
        else
        {
            System.out.println("Failed");
        }
     }
    
    void updateStudent(StudentViewModel studentinfo) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement=con.createStatement();
      
        String query="update studentinfo set SN='"+studentinfo.getSN()+"',StudentId='"+studentinfo.getStudentId()+"', StudentName='"+studentinfo.getStudentName()+"', Department='"+studentinfo.getDepartment()+"', Address='"+studentinfo.getAddress()+"',Email='"+studentinfo.getEmail()+"', Contact='"+studentinfo.getContact()+"' where StudentId='"+studentinfo.getStudentId()+"'";
        statement.executeUpdate(query);
        
        if(statement.executeUpdate(query)>0)
        {
            System.out.println("New Student Updated Successfully");
        }
        else
        {
            System.out.println("Failed");
        }
     }
    
    void deleteStudent(ObservableList<StudentViewModel> selectedStudent) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement=con.createStatement();
        
        for(StudentViewModel studentinfo:selectedStudent)
        {
            String query="delete from studentinfo where StudentId = "+studentinfo.getStudentId();
            statement.executeUpdate(query);
        }
    }
    
     // Student Transcript start
    
    ObservableList<TranscriptViewModel> LoadTranscript() throws SQLException
    {
       ObservableList<TranscriptViewModel> transcriptlist = FXCollections.observableArrayList();

       Connection con = dbConnection();

       String query = ("SELECT * FROM transcript");
       ResultSet rs=con.createStatement().executeQuery(query);

       while(rs.next())
       {
          int ssn = rs.getInt("SN");
          int id = rs.getInt("Id");
          String name = rs.getString("Name");
          String subject = rs.getString("Subject");
          String section = rs.getString("Section");
          int marks = rs.getInt("Marks");

          TranscriptViewModel viewtranscript = new TranscriptViewModel(ssn,id,name,subject,section,marks);
          transcriptlist.add(viewtranscript);
       }
       return transcriptlist;
    }
       
    void insertTranscript(TranscriptViewModel transcript) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement=con.createStatement();
      
        String query="INSERT INTO transcript (SN,Id,Name,Subject,Section,Marks) VALUES ("+transcript.getSN()+","+transcript.getId()+",'"+transcript.getName()+"','"+transcript.getSubject()+"','"+transcript.getSection()+"','"+transcript.getMarks()+"')";
        statement.executeUpdate(query);
        
        if(statement.executeUpdate(query)>0)
        {
            System.out.println("New Student Transcript Added Successfully");
        }
        else
        {
            System.out.println("Failed");
        }
     }

    void updateTranscript(TranscriptViewModel transcript) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement=con.createStatement();
      
        String query=("update transcript set SN='"+transcript.getSN()+"', Id='"+transcript.getId()+"', Name='"+transcript.getName()+"', Subject='"+transcript.getSubject()+"', Section='"+transcript.getSection()+"', Marks='"+transcript.getMarks()+"'");
        statement.executeUpdate(query);
        
        if(statement.executeUpdate(query)>0)
        {
            System.out.println("New Student Transcript Updated Successfully");
        }
        else
        {
            System.out.println("Failed");
        }
     }
    
    void deleteTranscript(ObservableList<TranscriptViewModel> selectedStudent) throws SQLException
    {
        Connection con = dbConnection();
        Statement statement=con.createStatement();
        
        for(TranscriptViewModel transcript:selectedStudent)
        {
            String query="delete from transcript where Id = "+transcript.getId();
            statement.executeUpdate(query);
        }
    }
    
    ObservableList<ReportViewModel> LoadReport() throws SQLException
       {
          ObservableList<ReportViewModel> studentlist = FXCollections.observableArrayList();
          
          Connection con = dbConnection();
          
          String query=("SELECT studentinfo.StudentId, studentinfo.StudentName, studentinfo.Email, studentinfo.Department, transcript.Subject, transcript.Section, transcript.Marks FROM studentinfo, transcript WHERE studentinfo.StudentId = transcript.Id ORDER BY studentinfo.StudentId");
       
          ResultSet rs=con.createStatement().executeQuery(query);
         
          while(rs.next())
          {
             int studentId = rs.getInt("StudentId");
             String studentName = rs.getString("StudentName");
             String email = rs.getString("Email");
             String department = rs.getString("Department");
             String subject = rs.getString("Subject");
             String section = rs.getString("Section");
             int marks = rs.getInt("Marks");

             ReportViewModel studentReport = new ReportViewModel(studentId,studentName,email,department,subject,section,marks);
             studentlist.add(studentReport);
          }
          return studentlist;
       }
    
    
//    void Report() throws SQLException
//    {
//        ObservableList<ReportViewModel> studentlist = FXCollections.observableArrayList();
//        
//       Connection con = dbConnection();
//       Statement statement=con.createStatement(); 
//       String query=("SELECT studentinfo.StudentId, studentinfo.StudentName, studentinfo.Department, studentinfo.Email, transcript.Subject, transcript.Section, transcript.Marks FROM studentinfo, transcript WHERE studentinfo.StudentId = transcript.Id ORDER BY studentinfo.StudentId");
//       statement.executeUpdate(query);
//
//       if(statement.executeUpdate(query)>0)
//        {
//            System.out.println("Student Report View Successfully");
//        }
//       else
//        {
//            System.out.println("Failed");
//        }
//    }
}
