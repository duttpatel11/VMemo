/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vmemo.VMemo;

/**
 *
 * @author Dutt2
 */
public class EventCreationViewController {

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
        loader.setLocation(getClass().getResource("VMemo_GalleryView.fxml"));
        Pane layout = loader.load();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }

    @FXML
    void saveMemo(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert memoTextArea != null : "fx:id=\"memoTextArea\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert BackButton1 != null : "fx:id=\"BackButton1\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert titleTextArea != null : "fx:id=\"titleTextArea\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'eventCreationView.fxml'.";

    }
}
