/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo.controller.memo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vmemo.VMemo;
import vmemo.controller.GalleryController;
import vmemo.model.Memo;
import vmemo.view.MemoView;


/**
 * @author Dutt2 & 12
 */
public class MemoCreationViewController {


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

    private final ObjectProperty<URL> imageResultProperty = new SimpleObjectProperty<>();

    //Uses filechooser to navigate to file explorer & tests for selection type
    @FXML
    void OpenFileSelector(ActionEvent event) {
        try {
            URL fileUrl = this.selectImage();
            if (fileUrl == null) {
                return;
            }
            this.imageResultProperty.set(fileUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private URL selectImage() throws MalformedURLException {
        FileChooser chooser = this.createFileChooserForImages();

        File selectedFile = chooser.showOpenDialog(VMemo.primaryStage);
        if (selectedFile == null) {
            return null;
        }

        return selectedFile.toURI().toURL();
    }

    private FileChooser createFileChooserForImages() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("."));
        chooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Pictures", "png", "jpg"));
        return chooser;
    }

    //Displays the gallery view when returning to previous page
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

    //getting image listeners and setting basic view
    @FXML
    void initialize() {
        this.imageResultProperty.addListener((observable, oldValue, newValue) -> {
            Image image = new Image(newValue.toString());
            imageView.imageProperty().set(image);
        });
        this.importPicButton.opacityProperty().set(0.5);
    }

    //displays view of each functional button & saves to database
    public void setView(
            ObservableList<MemoView> target,
            MemoView view) {
        if (view == null) {
            view = new MemoView(new Memo());
        }
        MemoView finalView = view;
        //Binds the text areas to the properties inside of memoview
        this.memoTextArea.textProperty().bindBidirectional(view.imageDescription);
        this.titleTextArea.textProperty().bindBidirectional(view.title);
        this.imageResultProperty.bindBidirectional(view.imageProperty);

        //updates the target list from previous view and saves to the repository
        this.saveButton.setOnAction(event -> {
            if (!target.contains(finalView)) {
                target.add(finalView);
            }
            finalView.save(VMemo.repository);
        });
    }
}

