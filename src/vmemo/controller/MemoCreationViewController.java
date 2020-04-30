/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vmemo.VMemo;
import vmemo.model.Memo;
import vmemo.view.MemoView;


/**
 * @author Dutt2
 */
public class MemoCreationViewController {
    private MemoView model = new MemoView(
            new Memo()
    );

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="recordbutton"
    private Button recordbutton; // Value injected by FXMLLoader

    @FXML // fx:id="memoTextArea"
    private TextArea memoTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="BackButton1"
    private Button BackButton1; // Value injected by FXMLLoader

    @FXML // fx:id="titleTextArea"
    private TextField titleTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="importPicButton"
    private Button importPicButton; // Value injected by FXMLLoader

    @FXML // fx:id="saveButton"
    private Button saveButton; // Value injected by FXMLLoader

    @FXML
    private ImageView imageView;

    //Uses filechooser to navigate to file explorer & tests for selection type
    @FXML
    void OpenFileSelector(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Picures", "png", "jpg"));
        File selectedFile = chooser.showOpenDialog(VMemo.primaryStage);

        if(selectedFile == null){
            return;
        }

        try {
            URL fileUrl = selectedFile.toURI().toURL();
            model.imageProperty.set(fileUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //Displays the gallery view when returning back
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

    @FXML
    void initialize() {
        assert recordbutton != null : "fx:id=\"recordbutton\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert memoTextArea != null : "fx:id=\"memoTextArea\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert BackButton1 != null : "fx:id=\"BackButton1\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert titleTextArea != null : "fx:id=\"titleTextArea\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert importPicButton != null : "fx:id=\"importPicButton\" was not injected: check your FXML file 'eventCreationView.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'eventCreationView.fxml'.";

        this.model.imageDescription.bind(this.memoTextArea.textProperty());
        this.importPicButton.visibleProperty().bind(this.model.imageProperty.isNull());

        // listen for the url change
        this.model.imageProperty.addListener(new ChangeListener<URL>() {
            @Override
            public void changed(ObservableValue<? extends URL> observable, URL oldValue, URL newValue) {
                Image image = new Image(newValue.toString());
                imageView.imageProperty().set(image);
            }
        });
    }
//binds the memoview list and handles any errors - tests to check if empty
    public void bind(ObservableList<MemoView> target) {
        this.saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!target.contains(model)) {
                    target.add(model);
                }
            }
        });
    }
}

