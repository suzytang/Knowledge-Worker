
package indiefy;
//TODO: Add Import Statements

import Resources.Database;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Indiefy extends Application{ //TODO: What class do you need to extend?
    
    @Override
    public void start(Stage stage) throws Exception {
        loadDatabase();
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }

    private void loadDatabase() throws SQLException {
        Database db = new Database();
        db.createLoginTable();
        db.insertStatement("INSERT INTO loginTable VALUES ('Pretentious', 'Hipster')");
        //TODO: Call Database methods here to create the database
    }
    
}