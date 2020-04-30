/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vmemo.controller.GalleryController;
import vmemo.model.Memo;
import vmemo.view.MemoView;

import java.util.List;

/**
 * @author 12
 */
public class VMemo extends Application {

    public static Stage primaryStage;
    public static final ObservableList<MemoView> memos = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        //Main initialization of the application
        Parent parent = FXMLLoader.load(GalleryController.class.getResource("VMemo_GalleryView.fxml"));
        primaryStage.setTitle("Testing");
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // fetching data from database
        List<Memo> memos = MemoRepository.fetch(); //Database representation

        //Preparing memo view
        for (Memo memo : memos) {
            MemoView view = new MemoView(memo);
            VMemo.memos.add(view);
        }

        // launching the application
        launch(args);
    }

}
