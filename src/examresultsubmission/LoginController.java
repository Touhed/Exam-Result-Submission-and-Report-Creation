package examresultsubmission;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Touhedur Rahman
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane maincontentpane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void loginButton(ActionEvent event) throws SQLException, IOException
    {
        DatabaseControl dbc = new DatabaseControl();
        Connection con = dbc.dbConnection();
        
        String UserName = username.getText();
        String Password = password.getText();
        
        String admin = "SELECT * FROM admin where UserName = '"+UserName+"' AND Password = '"+Password+"' AND UserType = 'Admin'";
        String teacher = "SELECT * FROM admin where UserName = '"+UserName+"' AND Password = '"+Password+"' AND UserType = 'Teacher'";
        String student = "SELECT * FROM admin where UserName = '"+UserName+"' AND Password = '"+Password+"' AND UserType = 'Student'";
        
        ResultSet rsadmin = con.createStatement().executeQuery(admin);
        ResultSet rsteacher = con.createStatement().executeQuery(teacher);
        ResultSet rsstudent = con.createStatement().executeQuery(student);

        if(rsadmin.next())
        {
             Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
             maincontentpane.getChildren().setAll(root1);
        }
        else if(rsteacher.next())
        {
         Parent root1 = FXMLLoader.load(getClass().getResource("TeacherPanel.fxml"));
          maincontentpane.getChildren().setAll(root1);
        }
        else if(rsstudent.next())
        {
         Parent root1 = FXMLLoader.load(getClass().getResource("StudentPanel.fxml"));
          maincontentpane.getChildren().setAll(root1);
        }
        else
        {
           username.clear();
           password.clear();

           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setContentText("Invaild Username or Password !");
           alert.show();
        }
        
    }
    
    
    @FXML
    private void createButton(ActionEvent event) throws SQLException
    {
        try
        {
            DatabaseControl dbc =new DatabaseControl();
            Connection con = dbc.dbConnection();
            String sql="Select  * from admin";
            ResultSet rs=con.createStatement().executeQuery(sql);
             
             if(rs.next())
             {
                Parent root= FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
                maincontentpane.getChildren().setAll(root);
             }
             else
             {
                 System.out.println("Failed");
             }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
