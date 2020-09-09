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
public class AddTranscriptController implements Initializable 
{
    @FXML
    private AnchorPane addTranscriptPane;
    @FXML
    private TextField ssn;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField section;
    @FXML
    private TextField subject;
    @FXML
    private TextField marks;
    

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
        int s = ViewStudentController.id;
        String hs = Integer.toString(s);
        ssn.setText(sln);
        id.setText(hs);
        name.setText(ViewStudentController.name);
    }    

    static ObservableList<TranscriptViewModel> transcriptlist=FXCollections.observableArrayList();
            
    @FXML
    private void addButton(ActionEvent event) throws SQLException 
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
        
        if(Name.equals("")&&Subject.equals("")&&Section.equals("")&&marks.equals(""))
        {
            return;
        }
        
        TranscriptViewModel transcript = new TranscriptViewModel(SN,Id,Name,Subject,Section,Marks);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Insert");
        alert.setContentText("Inserted Successfull!");
        alert.show();
        
        ssn.clear();
        id.clear();
        name.clear();
        subject.clear();
        section.clear();
        marks.clear();
        
        DatabaseControl dbAction=new DatabaseControl();
        dbAction.insertTranscript(transcript);
    }

    @FXML
    private void resetButton(ActionEvent event) 
    {
        ssn.clear();
        id.clear();
        name.clear();
        subject.clear();
        section.clear();
        marks.clear();
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        addTranscriptPane.getChildren().setAll(root1);
    }
    
}
