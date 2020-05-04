/**
 * Sample Skeleton for 'VMemo_GalleryView.fxml' Controller Class
 */

package vmemo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import vmemo.VMemo;
import vmemo.controller.event.EventCreationViewController;
import vmemo.controller.memo.MemoCreationViewController;
import vmemo.view.EventListCell;
import vmemo.view.EventView;
import vmemo.view.MemoListCell;
import vmemo.view.MemoView;

/**
 * @author Dutt2 & 12
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
    private ListView<MemoView> memoList;

    @FXML
    private ListView<EventView> eventListView;

    //Opens the EventCreationView interface and sets the scene
    @FXML
    void openEventCreationView(ActionEvent event) throws IOException {

        Stage window = VMemo.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EventCreationViewController.class.getResource("eventCreationView.fxml"));
        Pane layout = loader.load();
        EventCreationViewController controller = loader.getController();
        controller.setView(this.eventListView.getSelectionModel().getSelectedItem());
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    //Gets the MemoCreationView and displays the scene & binds it to the list
    @FXML
    void openMemoCreationView(ActionEvent event) throws IOException {
        Stage window = VMemo.primaryStage;

        FXMLLoader loader = new FXMLLoader(MemoCreationViewController.class.getResource("memoCreationView.fxml"));
        Scene scene = new Scene(loader.load());
        MemoCreationViewController controller = loader.getController();
        controller.setView(this.memoList.getItems(), this.memoList.getSelectionModel().getSelectedItem());
        window.setScene(scene);
        window.show();
    }

    //initializes & updates the cell views for memo and events
    @FXML
    void initialize() {
        this.memoList.setItems(VMemo.memos);
        this.memoList.setCellFactory(param -> new MemoListCell());

        this.eventListView.setItems(VMemo.events);
        this.eventListView.setCellFactory(param -> new EventListCell());
    }
}