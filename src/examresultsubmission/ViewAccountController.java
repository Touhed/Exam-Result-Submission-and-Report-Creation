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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Touhedur Rahman
 */
public class ViewAccountController implements Initializable {

    @FXML
    private AnchorPane viewAccountPane;
    @FXML
    private TableView<AccountViewModel> accountTablePane;
    @FXML
    private TableColumn<AccountViewModel, Integer> tUserId;
    @FXML
    private TableColumn<AccountViewModel, String> tUserName;
    @FXML
    private TableColumn<AccountViewModel, String> tEmail;
    @FXML
    private TableColumn<AccountViewModel, String> tPassword;
    @FXML
    private TableColumn<AccountViewModel, String> tUserType;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        accountTablePane.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        CreateAccountController.accountlist.clear();
        
        DatabaseControl dbAction=new DatabaseControl();
        try 
        {
            CreateAccountController.accountlist = dbAction.LoadAccount();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ViewAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tUserId.setCellValueFactory(new PropertyValueFactory<AccountViewModel,Integer>("UserId"));
        tUserName.setCellValueFactory(new PropertyValueFactory<AccountViewModel,String>("UserName"));
        tEmail.setCellValueFactory(new PropertyValueFactory<AccountViewModel,String>("Email"));
        tPassword.setCellValueFactory(new PropertyValueFactory<AccountViewModel,String>("Password"));
        tUserType.setCellValueFactory(new PropertyValueFactory<AccountViewModel,String>("UserType"));
    
        accountTablePane.setItems(CreateAccountController.accountlist);
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException 
    {
        
             Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
             viewAccountPane.getChildren().setAll(root1);
    }
    
    @FXML
    private void deleteButtonViewAccount(ActionEvent event) throws SQLException 
    {
        ObservableList<AccountViewModel> selectedAccount=FXCollections.observableArrayList();
        selectedAccount=accountTablePane.getSelectionModel().getSelectedItems();
        
        DatabaseControl dbc = new DatabaseControl();
        dbc.deleteAccount(selectedAccount);
        
        CreateAccountController.accountlist.removeAll(selectedAccount);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setContentText("Deleted Successfully");
        alert.show();
    }
}
