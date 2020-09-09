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
public class CreateAccountController implements Initializable 
{
    @FXML
    private AnchorPane createAccountPane;
    @FXML
    private TextField userName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField userId;
    @FXML
    private TextField userType;

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
    static ObservableList<AccountViewModel> accountlist = FXCollections.observableArrayList();

    @FXML
    private void saveAccountButton(ActionEvent event) throws SQLException, IOException 
    {
        if(userId.getText().equals(""))
        {
            return;
        }
        int UserId = Integer.parseInt(userId.getText());
        String UserName = userName.getText();
        String Email = email.getText();
        String Password = password.getText();
        String UserType = userType.getText();
               
        
        if(UserName.equals("")||Email.equals("")||Password.equals("")||UserType.equals(""))
        {
            return;
        }
        AccountViewModel ca = new AccountViewModel(UserId,UserName,Email,Password,UserType);
        
        userId.clear();
        userName.clear();
        email.clear();
        password.clear();
        userType.clear();
        
        DatabaseControl dbc = new DatabaseControl();
        dbc.createAccount(ca);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Successful");
        alert.setContentText("Inserted Successfull");
        alert.show();
        
        Parent root1 = FXMLLoader.load(getClass().getResource("ViewAccount.fxml"));
        createAccountPane.getChildren().setAll(root1);  
    }

    @FXML
    private void resetAccountButton(ActionEvent event) 
    {
        userId.clear();
        userName.clear();
        email.clear();
        password.clear(); 
        userType.clear();
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        createAccountPane.getChildren().setAll(root1);
    }
    
}
