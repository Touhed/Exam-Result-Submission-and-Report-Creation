package examresultsubmission;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Touhedur Rahman
 */
public class UpdateStudentInfoController implements Initializable {

    @FXML
    private AnchorPane updateStudentMainPane;
    @FXML
    private AnchorPane updateContentPane;
    @FXML
    private TextField ssn;
    @FXML
    private TextField sid;
    @FXML
    private TextField sname;
    @FXML
    private TextField sdepartment;
    @FXML
    private TextField saddress;
    @FXML
    private TextField semail;
    @FXML
    private TextField scontact;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        int sl = ViewStudentController.sn;
        String sln = Integer.toString(sl);
        int s = ViewStudentController.StudentId;
        String hs = Integer.toString(s);
        ssn.setText(sln);
        sid.setText(hs);
        sname.setText(ViewStudentController.StudentName);
        sdepartment.setText(ViewStudentController.department);
        saddress.setText(ViewStudentController.address);
        semail.setText(ViewStudentController.email);
        scontact.setText(ViewStudentController.contact);
    }    

    static ObservableList<StudentViewModel> studentlist = FXCollections.observableArrayList();
    
    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
        updateStudentMainPane.getChildren().setAll(root1);
    }

    @FXML
    private void saveUpdateButton(ActionEvent event) throws SQLException 
    {
        if(sid.getText().equals(""))
        {
            return;
        }
        int SN = Integer.parseInt(ssn.getText());
        int StudentId = Integer.parseInt(sid.getText());
        String StudentName = sname.getText();
        String Department = sdepartment.getText();
        String Address = saddress.getText();
        String Email = semail.getText();
        String Contact = scontact.getText();
        
        if(StudentName.equals("")&&Department.equals("")&&Address.equals("")&&Email.equals("")&&Contact.equals(""))
        {
            return;
        }
        
        StudentViewModel student = new StudentViewModel(SN,StudentId,StudentName,Department,Address,Email,Contact);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update");
        alert.setContentText("Update Successfull!");
        alert.show();
        
        ssn.clear();
        sid.clear();
        sname.clear();
        sdepartment.clear();
        saddress.clear();
        semail.clear();
        scontact.clear();
        
        DatabaseControl dbAction=new DatabaseControl();
        dbAction.updateStudent(student); 
    }

    @FXML
    private void showTableButton(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
        updateStudentMainPane.getChildren().setAll(root1);
    }
    
}
