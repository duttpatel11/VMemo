/**
 * Sample Skeleton for 'VMemo_GalleryView.fxml' Controller Class
 */

package vmemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 
 * @author Dutt2
 */

public class GalleryController {
    
       @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

   @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
    
   
   @FXML // This method is called by the FXMLLoader when initialization is complete
   void initialize() {

   }
   
    @FXML
    private Label controller2;
    
    private Model model;
    
    public void setModel(Model model) {
        this.model = model;
        controller2.textProperty().bind(model.ViewProperty().asString());
        
    }
    @FXML
    public void click() throws Exception {
        model.setView(0);
    }
}
