
package indiefy;

//TODO: Add Import Statements

import Model.Music;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class MusicListController {
    
    @FXML
    private TableView<Music> musicList; //TODO: What type of data will populate the TableView? Replace "E"
	
    @FXML
    private TableColumn<Music, String> artistColumn;
    
    @FXML
    private TableColumn<Music, String> albumColumn; //TODO: What type of data will populate the TableView? Replace "E"
    
    @FXML
    private TableColumn<Music, String> genreColumn;
    
    @FXML
    private TableColumn<Music, String> yearColumn;
    
    //TODO: Add the other TableColumns
    
    @FXML
    public void initialize() {
        artistColumn.setCellValueFactory(
                cellData -> cellData.getValue().getArtistProperty());
        albumColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAlbumProperty());
        genreColumn.setCellValueFactory(
                cellData -> cellData.getValue().getGenreProperty());
        yearColumn.setCellValueFactory(
                cellData -> cellData.getValue().getYearProperty());

        musicList.setItems(getMusicListData()); //TODO: Populate the TableView
    }
    
    private final ObservableList<Music> musicData = FXCollections.observableArrayList();
    
    private ObservableList<Music> getMusicListData() {
       //TODO: Complete the method.     
       musicData.add(new Music("Feels","Animal Collective","Experimental Pop","2005"));
       musicData.add(new Music("The Money Store","Death Grips","Experimental HipHop","2012"));
       musicData.add(new Music("No Now","Clarence Clarity","Experimental Pop","2015"));
       musicData.add(new Music("My Gangsta Mixtape","Andrew Zhao","HipHop","2019"));    
       
       return musicData;
       
    }
    
}