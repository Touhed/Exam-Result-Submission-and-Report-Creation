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
public class ReportController implements Initializable 
{

    @FXML
    private AnchorPane reportMainPane;
    @FXML
    private TableView<ReportViewModel> studentReportTablePane;
    @FXML
    private TableColumn<ReportViewModel, Integer> rtStudentId;
    @FXML
    private TableColumn<ReportViewModel, String> rtStudentName;
    @FXML
    private TableColumn<ReportViewModel, String> rtEmail;
    @FXML
    private TableColumn<ReportViewModel, String> rtDepartment;
    @FXML
    private TableColumn<ReportViewModel, String> rtSubject;
    @FXML
    private TableColumn<ReportViewModel, String> rtSection;
    @FXML
    private TableColumn<ReportViewModel, Integer> rtMarks;
    
    WebEngine engine = new WebEngine();
    Window owner;
    
    
    static ObservableList<ReportViewModel> studentlist=FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       studentReportTablePane.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ReportController.studentlist.clear();
        
        DatabaseControl dbAction = new DatabaseControl();
        try
        {
            ReportController.studentlist = dbAction.LoadReport();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rtStudentId.setCellValueFactory(new PropertyValueFactory<ReportViewModel,Integer>("StudentId"));
        rtStudentName.setCellValueFactory(new PropertyValueFactory<ReportViewModel,String>("StudentName"));
        rtEmail.setCellValueFactory(new PropertyValueFactory<ReportViewModel,String>("Email"));
        rtDepartment.setCellValueFactory(new PropertyValueFactory<ReportViewModel,String>("Department"));
        rtSubject.setCellValueFactory(new PropertyValueFactory<ReportViewModel,String>("Subject"));
        rtSection.setCellValueFactory(new PropertyValueFactory<ReportViewModel,String>("Section"));
        rtMarks.setCellValueFactory(new PropertyValueFactory<ReportViewModel,Integer>("Marks"));
        
        studentReportTablePane.setItems(ReportController.studentlist);
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        reportMainPane.getChildren().setAll(root1);
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
