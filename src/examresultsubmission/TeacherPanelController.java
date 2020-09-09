package examresultsubmission;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Touhedur Rahman
 */
public class TeacherPanelController implements Initializable 
{

    @FXML
    private AnchorPane teacherPanelMainPane;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }  
    
    @FXML
    private void StudentListButton(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("StudentListTPanel.fxml"));
        teacherPanelMainPane.getChildren().setAll(root1);
    }
    
    @FXML
    private void addTranscriptButton(ActionEvent event) throws IOException 
    {
        Parent root2 = FXMLLoader.load(getClass().getResource("AddTranscript.fxml"));
        teacherPanelMainPane.getChildren().setAll(root2);
    }
    
    @FXML
    private void TranscriptListButton(ActionEvent event) throws IOException 
    {

        Parent root2 = FXMLLoader.load(getClass().getResource("TranscriptListTPanel.fxml"));
        teacherPanelMainPane.getChildren().setAll(root2);
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException 
    {
        Parent root3 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        teacherPanelMainPane.getChildren().setAll(root3);
    }

    @FXML
    private void viewReportButton(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("Report.fxml"));
         teacherPanelMainPane.getChildren().setAll(root1);
    }
}
