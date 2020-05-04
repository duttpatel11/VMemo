package vmemo.controller.memo;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vmemo.view.MemoView;

import java.net.URL;


public class MemoListCellController {
    @FXML
    private ImageView thumbnail;
    @FXML
    private Label title;
        //Binds thumbnail and title to their properties
    public void bind(MemoView item) {
        this.thumbnail.imageProperty().bind(this.createImageBinding(item.imageProperty));
        this.title.textProperty().bind(item.title);
    }
        //converts URL object to image object
    private ObjectBinding<Image> createImageBinding(ObjectProperty<URL> imageURL) {
        return Bindings.createObjectBinding(() -> {
            URL value = imageURL.get();
            if (value == null) {
                value = MemoListCellController.class.getResource("/images/placeholder.png");
            }
            return new Image(value.toString());
        }, imageURL);

    }
}
