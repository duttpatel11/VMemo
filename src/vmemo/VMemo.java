/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 12
 */
public class VMemo extends Application {
    
    static Stage primaryStage;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Model model = new Model(); 
        
        Parent parent = FXMLLoader.load(getClass().getResource("VMemo_GalleryView.fxml"));
        primaryStage.setTitle("Testing");
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
        
       /* FXMLLoader newLoader = new FXMLLoader();   
newLoader.setLocation(getClass().getResource("VMemo_GalleryView.fxml"));
    Parent root = newLoader.load();
    
    MemoViewController newView = newLoader.getController();
    newView.setModel(model);
    
    
    primaryStage.setTitle("VMemo Testing");
    primaryStage.setScene(new Scene(root, 1024, 768));
    primaryStage.show();
    }
    */
        
     /*   Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
