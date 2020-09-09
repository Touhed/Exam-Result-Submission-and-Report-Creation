package examresultsubmission;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Touhedur Rahman
 */
public class ExamResultSubmission extends Application 
{
    
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
    
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Welcome To My Project");
            stage.show();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
