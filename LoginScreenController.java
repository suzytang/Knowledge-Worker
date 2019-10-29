/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indiefy;

//TODO: Add Import Statements

import Resources.Database;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginScreenController implements Initializable{

    //TODO: Add FXML Fields
    @FXML
    private Button login;
    
    @FXML
    private PasswordField passwordBox;
    
    @FXML
    private TextField usernameBox;
    
    @FXML
    private Label prompt;
    
    @FXML
    private Button music;
    
    //TODO: Instatiate the database class
    Database d = new Database();
        
    //TODO: Instatiate the PageSwitchHelper class
    PageSwitchHelper p = new PageSwitchHelper();
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws SQLException {
        //TODO: Get the username and password from the GUI

        String query = "SELECT username, password FROM LoginTable WHERE "
            + "username = '" + usernameBox.getText() + "'"
            + "AND password = '" + passwordBox.getText() + "'";

        try {
            ResultSet rs = d.getResultSet(query); //TODO: Fill in this query
            if (!rs.next()) {
               //TODO: What should happen if there is no result?
                prompt.setText("Incorrect Username or Password");
            } else {
               //TODO: What should happen if there is a result?
                prompt.setText("Login Success");
                music.setVisible(true);
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void handleNextButtonAction(ActionEvent event) throws IOException {
        //TODO: Look at the PageSwitcherHelper class. How do we use this class?
        p.switcher(event, "MusicList.fxml");
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //TODO: What should the screen look like when it loads?
        
    }

}