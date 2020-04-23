/**
 * Sample Skeleton for 'VMemo_MemoView.fxml' Controller Class
 */

package vmemo;

import java.awt.Image;
import java.awt.image.SampleModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class MemoViewController {
    private Model model;

  //  @FXML // ResourceBundle that was given to the FXMLLoader
  //  private ResourceBundle resources;

  //  @FXML // URL location of the FXML file that was given to the FXMLLoader
   // private URL location;
    
    private Label memoView;

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
        window.setTitle("Switch memo");
        
        window.setScene(scene);
        window.show();
      
        view2.setModel(model);
    

    }
}

    //@FXML // This method is called by the FXMLLoader when initialization is complete
   // void initialize() {

    //}
    
    
//
