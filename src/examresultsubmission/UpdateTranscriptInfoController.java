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
public class UpdateTranscriptInfoController implements Initializable {

    @FXML
    private AnchorPane updateTranscriptPane;
    @FXML
    private TextField marks;
    @FXML
    private TextField subject;
    @FXML
    private TextField section;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private TextField ssn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        int sl = ViewTranscriptController.sn;
        String sln = Integer.toString(sl);
        int s = ViewTranscriptController.id;
        String hs = Integer.toString(s);
        int m = ViewTranscriptController.marks;
        String mark = Integer.toString(m);
        ssn.setText(sln);
        id.setText(hs);
        name.setText(ViewTranscriptController.name);
        subject.setText(ViewTranscriptController.subject);
        section.setText(ViewTranscriptController.section);
        marks.setText(mark);
    }    
    
    static ObservableList<TranscriptViewModel> transcriptlist=FXCollections.observableArrayList();

    @FXML
    private void updateTranscriptButton(ActionEvent event) throws SQLException 
    {
        if(id.getText().equals(""))
        {
            return;
        }
        int SN = Integer.parseInt(ssn.getText());
        int Id = Integer.parseInt(id.getText());
        String Name = name.getText();
        String Subject = subject.getText();
        String Section = section.getText();
        int Marks = Integer.parseInt(marks.getText());
        
        if(Name.equals("")&&Subject.equals("")&&Section.equals("")&&marks.getText().equals(""))
        {
            return;
        }
        
        TranscriptViewModel transcript = new TranscriptViewModel(SN,Id,Name,Subject,Section,Marks);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update");
        alert.setContentText("Update Successfull!");
        alert.show();
        
        ssn.clear();
        id.clear();
        name.clear();
        subject.clear();
        section.clear();
        marks.clear();
        
        DatabaseControl dbAction=new DatabaseControl();
        dbAction.updateTranscript(transcript);
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    { 
        Parent root1 = FXMLLoader.load(getClass().getResource("ViewTranscript.fxml"));
        updateTranscriptPane.getChildren().setAll(root1);    
    }

    @FXML
    private void showTableButton(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("ViewTranscript.fxml"));
        updateTranscriptPane.getChildren().setAll(root1);
    }
}
