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
public class AddStudentController implements Initializable {

    @FXML
    private AnchorPane addstudentpane;
    @FXML
    private TextField ssn;
    @FXML
    private TextField sid;
    @FXML
    private TextField sname;
    @FXML
    private TextField saddress;
    @FXML
    private TextField semail;
    @FXML
    private TextField scontact;
    @FXML
    private TextField sdepartment;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    static ObservableList<StudentViewModel> studentlist=FXCollections.observableArrayList();

    @FXML
    private void addButton(ActionEvent event) throws SQLException 
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
        alert.setTitle("Insert");
        alert.setContentText("Inserted Successfull!");
        alert.show();
        
        ssn.clear();
        sid.clear();
        sname.clear();
        sdepartment.clear();
        saddress.clear();
        semail.clear();
        scontact.clear();
        
        DatabaseControl dbAction=new DatabaseControl();
        dbAction.insertStudent(student);
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        addstudentpane.getChildren().setAll(root1);
    }
    
}
