/**
 * Sample Skeleton for 'VMemo_MemoView.fxml' Controller Class
 */

package vmemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * 
 * @author Dutt2
 */
public class MemoViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="playButton"
    private Button playButton; // Value injected by FXMLLoader

    @FXML // fx:id="memoTextArea"
    private TextArea memoTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="BackButton2"
    private Button BackButton2; // Value injected by FXMLLoader

    @FXML // fx:id="titleTextArea"
    private TextField titleTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="deleteButton"
    private Button deleteButton; // Value injected by FXMLLoader

    @FXML // fx:id="favCheckBox"
    private CheckBox favCheckBox; // Value injected by FXMLLoader

     private Model model;

  //  @FXML // ResourceBundle that was given to the FXMLLoader
  //  private ResourceBundle resources;

  //  @FXML // URL location of the FXML file that was given to the FXMLLoader
   // private URL location;
    
    private Label memoView;
    @FXML
    void backToMemoGallery(ActionEvent event) {

    }

    @FXML
    void favMemo(ActionEvent event) {

    }

    @FXML
    void saveMemo(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'VMemo_MemoView.fxml'.";
        assert memoTextArea != null : "fx:id=\"memoTextArea\" was not injected: check your FXML file 'VMemo_MemoView.fxml'.";
        assert BackButton2 != null : "fx:id=\"BackButton2\" was not injected: check your FXML file 'VMemo_MemoView.fxml'.";
        assert titleTextArea != null : "fx:id=\"titleTextArea\" was not injected: check your FXML file 'VMemo_MemoView.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'VMemo_MemoView.fxml'.";
        assert favCheckBox != null : "fx:id=\"favCheckBox\" was not injected: check your FXML file 'VMemo_MemoView.fxml'.";

    }
    
   

    public void setModel(Model model) {
        this.model = model;
        memoView.textProperty().bind(model.ViewProperty().asString());
       
    }
    
    @FXML
    public void viewController() throws Exception {
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VMemo_MemoView.fxml"));
        
        Pane layout = loader.load();
        Scene scene = new Scene(layout);
        
        GalleryController view2 = loader.getController();
        window.setTitle("memoView");
        
        window.setScene(scene);
        window.show();
      
        view2.setModel(model);
    

    }
}