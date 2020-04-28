/**
 * Sample Skeleton for 'VMemo_GalleryView.fxml' Controller Class
 */

package vmemo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Dutt2
 */

public class GalleryController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="memosTab"
    private Tab memosTab; // Value injected by FXMLLoader

    @FXML // fx:id="newMemoButton"
    private Button newMemoButton; // Value injected by FXMLLoader

    @FXML // fx:id="thumbnailsVBox"
    private VBox thumbnailsVBox; // Value injected by FXMLLoader

    @FXML // fx:id="eventsTab"
    private Tab eventsTab; // Value injected by FXMLLoader

    @FXML // fx:id="newEventButton"
    private Button newEventButton; // Value injected by FXMLLoader

    @FXML // fx:id="eventsVBox"
    private VBox eventsVBox; // Value injected by FXMLLoader

    @FXML // fx:id="testEventButton1"
    private Button testEventButton1; // Value injected by FXMLLoader

    @FXML // fx:id="testEventButton2"
    private Button testEventButton2; // Value injected by FXMLLoader

    @FXML
    void openEventCreationView(ActionEvent event) throws IOException {
        Stage window = VMemo.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("eventCreationView.fxml"));
        Pane layout = loader.load();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }

    @FXML
    void openMemoCreationView(ActionEvent event) throws IOException {
        Stage window = VMemo.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("memoCreationView.fxml"));
        Pane layout = loader.load();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert memosTab != null : "fx:id=\"memosTab\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";
        assert newMemoButton != null : "fx:id=\"newMemoButton\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";
        assert thumbnailsVBox != null : "fx:id=\"thumbnailsVBox\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";
        assert eventsTab != null : "fx:id=\"eventsTab\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";
        assert newEventButton != null : "fx:id=\"newEventButton\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";
        assert eventsVBox != null : "fx:id=\"eventsVBox\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";
        assert testEventButton1 != null : "fx:id=\"testEventButton1\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";
        assert testEventButton2 != null : "fx:id=\"testEventButton2\" was not injected: check your FXML file 'VMemo_GalleryView.fxml'.";

    }


    void setModel(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
