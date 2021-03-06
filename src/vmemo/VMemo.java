/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vmemo.controller.GalleryController;
import vmemo.model.Event;
import vmemo.model.Memo;
import vmemo.view.EventView;
import vmemo.view.MemoView;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Dutt2 & 12
 */
public class VMemo extends Application {

    public static Stage primaryStage;

    public static final ObservableList<MemoView> memos = FXCollections.observableArrayList();
    public static final ObservableList<EventView> events = FXCollections.observableArrayList();

    public static MemoRepository repository;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        //Main initialization of the application design
        Parent parent = FXMLLoader.load(GalleryController.class.getResource("VMemo_GalleryView.fxml"));
        primaryStage.setTitle("VMemo");
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("IST311ProjectPU").createEntityManager();
        repository = new MemoRepository(manager);
        fetchAllMemos();

        // launching the application
        launch(args);
    }

    private static void fetchAllMemos() {
        List<Memo> memos = repository.findAllMemos();
        //Preparing memo view
        for (Memo memo : memos) {
            MemoView view = new MemoView(memo);
            VMemo.memos.add(view);
        }

        List<Event> events = repository.findAllEvents();
        //Preparing events view
        for (Event event : events) {
            EventView view = new EventView(event);
            VMemo.events.add(view);
        }
    }
}
