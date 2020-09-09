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
public class AdminPanelController implements Initializable 
{
    @FXML
    private AnchorPane adminpanelpane;

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
    private void addStudentButton(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
        adminpanelpane.getChildren().setAll(root1);  
    }

    @FXML
    private void viewStudentButton(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
        adminpanelpane.getChildren().setAll(root1);  
    }
    
    @FXML
    private void addTranscriptButton(ActionEvent event) throws IOException 
    {
        Parent root2 = FXMLLoader.load(getClass().getResource("AddTranscript.fxml"));
        adminpanelpane.getChildren().setAll(root2);  
    }

    @FXML
    private void viewTranscriptButton(ActionEvent event) throws IOException 
    {
        Parent root2 = FXMLLoader.load(getClass().getResource("ViewTranscript.fxml"));
        adminpanelpane.getChildren().setAll(root2);  
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException 
    {
        Parent root3 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        adminpanelpane.getChildren().setAll(root3); 
    }

    @FXML
    private void viewAccountButton(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("ViewAccount.fxml"));
        adminpanelpane.getChildren().setAll(root1); 
    }

    @FXML
    private void viewReportButton(ActionEvent event) throws IOException 
    {
         Parent root1 = FXMLLoader.load(getClass().getResource("Report.fxml"));
         adminpanelpane.getChildren().setAll(root1); 
    }
}
