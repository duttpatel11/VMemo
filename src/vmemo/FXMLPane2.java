/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Dutt2
 */
public class FXMLPane2 implements Initializable {
    private AnchorPane rootPane1;
    @FXML
    Button rootPane;


     /*   @FXML
    void loadSecond(ActionEvent event) throws IOException {
 AnchorPane pane = FXMLLoader.load(getClass().getResource("VMemo_MemoView.fxml"));
        rootPane.getChildren().setAll(pane);
    }*/

    @FXML
    private void handleNewButton(ActionEvent event) {
        System.out.println("New");
    }
    
       @Override
    public void initialize(URL location, ResourceBundle resources) {
    //    rootPane.setOnAction(this::newButton);


    }
    
}