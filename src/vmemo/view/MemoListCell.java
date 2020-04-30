package vmemo.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import vmemo.model.Memo;

import java.net.URL;

public class MemoListCell extends ListCell<MemoView> {

    //Sets the image size selected & updates the memoview
    @Override
    protected void updateItem(MemoView item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            URL url = item.imageProperty.get();
            if (url == null) {
                return;
            }

            Image image = new Image(url.toString());
            ImageView value = new ImageView(image);
            value.resize(64, 64);
            value.maxHeight(64);
            value.maxWidth(64);
            value.setFitHeight(64);
            value.setFitWidth(64);
            setGraphic(value);
        }
    }
}
