package examresultsubmission;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Touhedur Rahman
 */
public class StudentListSPanelController implements Initializable 
{
    @FXML
    private AnchorPane StudentListSPanelPane;
    @FXML
    private TableView<StudentViewModel> studentListTablePane;
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
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        studentListTablePane.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
    
        studentListTablePane.setItems(AddStudentController.studentlist);
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("StudentPanel.fxml"));
        StudentListSPanelPane.getChildren().setAll(root1);
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
    
}
