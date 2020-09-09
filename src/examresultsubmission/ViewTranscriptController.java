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
import javafx.scene.control.Alert;
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
public class ViewTranscriptController implements Initializable 
{
    @FXML
    private AnchorPane studentTranscriptmainpane;
    @FXML
    private TableView<TranscriptViewModel> transcriptTablePane;
    @FXML
    private TableColumn<TranscriptViewModel, Integer> tId;
    @FXML
    private TableColumn<TranscriptViewModel, String> tName;
    @FXML
    private TableColumn<TranscriptViewModel, String> tSubject;
    @FXML
    private TableColumn<TranscriptViewModel, String> tSection;
    @FXML
    private TableColumn<TranscriptViewModel, Integer> tMarks;
    
    WebEngine engine = new WebEngine();
    Window owner;
    
    static public int sn;
    static public int id;
    static public String name;
    static public String subject;
    static public String section;
    static public int marks;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        transcriptTablePane.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        AddTranscriptController.transcriptlist.clear();
        
        DatabaseControl dbAction = new DatabaseControl();
        try 
        {
            AddTranscriptController.transcriptlist = dbAction.LoadTranscript();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ViewTranscriptController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tId.setCellValueFactory(new PropertyValueFactory<TranscriptViewModel,Integer>("Id"));
        tName.setCellValueFactory(new PropertyValueFactory<TranscriptViewModel,String>("Name"));
        tSubject.setCellValueFactory(new PropertyValueFactory<TranscriptViewModel,String>("Subject"));
        tSection.setCellValueFactory(new PropertyValueFactory<TranscriptViewModel,String>("Section"));
        tMarks.setCellValueFactory(new PropertyValueFactory<TranscriptViewModel,Integer>("Marks"));
    
        transcriptTablePane.setItems(AddTranscriptController.transcriptlist);
    }   
    
    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        studentTranscriptmainpane.getChildren().setAll(root1);
    }

    @FXML
    private void deleteButton(ActionEvent event) throws SQLException 
    {
        ObservableList<TranscriptViewModel> selectedStudent = FXCollections.observableArrayList();
        selectedStudent = transcriptTablePane.getSelectionModel().getSelectedItems();
        
        DatabaseControl dbc = new DatabaseControl();
        dbc.deleteTranscript(selectedStudent);
        
        AddTranscriptController.transcriptlist.removeAll(selectedStudent);
        
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
    private void updateButton(ActionEvent event) throws IOException
    {
        TranscriptViewModel trnc = transcriptTablePane.getSelectionModel().getSelectedItem();
        sn = trnc.getSN();
        id = trnc.getId();
        name = trnc.getName();
        subject = trnc.getSubject();
        section = trnc.getSection();
        marks = trnc.getMarks();
        
        Parent root1 = FXMLLoader.load(getClass().getResource("UpdateTranscriptInfo.fxml"));
        studentTranscriptmainpane.getChildren().setAll(root1);
    }

}
