/**
 * Sample Skeleton for 'VMemo_GalleryView.fxml' Controller Class
 */

package vmemo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import vmemo.MemoRepository;
import vmemo.VMemo;
import vmemo.model.Memo;
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

    //Opens the EventCreationView interface and sets the scene
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

    //Gets the MemoCreationView and displays the scene & binds it to the list
    @FXML
    void openMemoCreationView(ActionEvent event) throws IOException {
        Stage window = VMemo.primaryStage;

        FXMLLoader loader = new FXMLLoader(MemoCreationViewController.class.getResource("memoCreationView.fxml"));
        Scene scene = new Scene(loader.load());
        MemoCreationViewController controller = loader.getController();
        controller.bind(this.memoList.getItems(), VMemo.repository);

        window.setScene(scene);
        window.show();
    }

    //Initialization stage for the list
    @FXML
    void initialize() {
        this.memoList.setItems(VMemo.memos);
        this.memoList.setCellFactory(new Callback<ListView<MemoView>, ListCell<MemoView>>() {
            @Override
            public ListCell<MemoView> call(ListView<MemoView> param) {

                return new MemoListCell();
            }
        });
    }
}