package examresultsubmission;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.scene.web.WebEngine;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Touhedur Rahman
 */
public class ViewStudentController implements Initializable 
{

    @FXML
    private AnchorPane viewStudentMainPane;
    @FXML
    private TableView<StudentViewModel> studentTablePane;
    @FXML
    private TableColumn<StudentViewModel, Integer> tStudentId;
    @FXML
    private TableColumn<StudentViewModel, String> tStudentName;
    @FXML
    private TableColumn<StudentViewModel, String> tDepartment;
    @FXML
    private TableColumn<StudentViewModel, String> tAddress;
    @FXML
    private TableColumn<StudentViewModel, String> tEmail;
    @FXML
    private TableColumn<StudentViewModel, String> tContact;
  
    WebEngine engine = new WebEngine();
    Window owner;
    
    static public int sn;
    static public int StudentId;
    static public String StudentName;
    static public int id;
    static public String name;
    static public String department;
    static public String address;
    static public String email;
    static public String contact;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        studentTablePane.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        AddStudentController.studentlist.clear();
        
        DatabaseControl dbAction = new DatabaseControl();
        try
        {
            AddStudentController.studentlist = dbAction.LoadStudent();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ViewStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tStudentId.setCellValueFactory(new PropertyValueFactory<StudentViewModel,Integer>("StudentId"));
        tStudentName.setCellValueFactory(new PropertyValueFactory<StudentViewModel,String>("StudentName"));
        tDepartment.setCellValueFactory(new PropertyValueFactory<StudentViewModel,String>("Department"));
        tAddress.setCellValueFactory(new PropertyValueFactory<StudentViewModel,String>("Address"));
        tEmail.setCellValueFactory(new PropertyValueFactory<StudentViewModel,String>("Email"));
        tContact.setCellValueFactory(new PropertyValueFactory<StudentViewModel,String>("Contact"));
    
        studentTablePane.setItems(AddStudentController.studentlist);
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        viewStudentMainPane.getChildren().setAll(root1);
    }
    
    @FXML
    private void deleteButton(ActionEvent event) throws SQLException 
    {
        ObservableList<StudentViewModel> selectedStudent = FXCollections.observableArrayList();
        selectedStudent = studentTablePane.getSelectionModel().getSelectedItems();
        
        DatabaseControl dbc = new DatabaseControl();
        dbc.deleteStudent(selectedStudent);
        
        AddStudentController.studentlist.removeAll(selectedStudent);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setContentText("Deleted Successfully");
        alert.show();
    }

    @FXML
    private void printButton(ActionEvent event) 
    {
        try
        {
            Printer printer = Printer.getDefaultPrinter();
            printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.EQUAL);
            PrinterJob job = PrinterJob.createPrinterJob(printer);
            job.showPrintDialog(owner);
            if (job != null) 
            {
                engine.print(job);
                job.endJob();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void addTranscript(ActionEvent event) throws IOException 
    {
        StudentViewModel std = studentTablePane.getSelectionModel().getSelectedItem();
        sn = std.getSN();
        id = std.getStudentId();
        name = std.getStudentName();
        
        Parent root1 = FXMLLoader.load(getClass().getResource("AddTranscript.fxml"));
        viewStudentMainPane.getChildren().setAll(root1);
    }

    @FXML
    private void updateButton(ActionEvent event) throws IOException 
    {
        StudentViewModel std = studentTablePane.getSelectionModel().getSelectedItem();
        sn = std.getSN();
        StudentId = std.getStudentId();
        StudentName = std.getStudentName();
        department = std.getDepartment();
        address = std.getAddress();
        email = std.getEmail();
        contact = std.getContact();
        
        Parent root2 = FXMLLoader.load(getClass().getResource("UpdateStudentInfo.fxml"));
        viewStudentMainPane.getChildren().setAll(root2);
    }
}
