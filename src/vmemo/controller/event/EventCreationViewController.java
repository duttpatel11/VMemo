/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo.controller.event;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vmemo.VMemo;
import vmemo.controller.GalleryController;
import vmemo.model.Event;
import vmemo.view.EventView;

/**
 * @author Dutt2
 */
public class EventCreationViewController {
    private EventView view = new EventView(new Event());

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="memoTextArea"
    private TextArea memoTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="BackButton1"
    private Button BackButton1; // Value injected by FXMLLoader

    @FXML // fx:id="titleTextArea"
    private TextField titleTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="saveButton"
    private Button saveButton; // Value injected by FXMLLoader

    //Displays the startup design when hitting the back button
    @FXML
    void backToMemoGallery(ActionEvent event) throws IOException {
        Stage window = VMemo.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GalleryController.class.getResource("VMemo_GalleryView.fxml"));
        Pane layout = loader.load();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    //displays the opening view of the item that is selected
    public void setView(EventView selectedItem) {
        if (selectedItem == null) {
            this.view = new EventView(new Event());
        } else {
            this.view = selectedItem;
        }
        this.bind(this.view);
    }

    //binds text area to description and title
    private void bind(EventView into) {
        this.memoTextArea.textProperty().bindBidirectional(into.description);
        this.titleTextArea.textProperty().bindBidirectional(into.title);
        this.saveButton.setOnAction(event -> {
            if (!VMemo.events.contains(into)) {
                VMemo.events.add(into);
            }
            into.save(VMemo.repository);
        });
    }
}
