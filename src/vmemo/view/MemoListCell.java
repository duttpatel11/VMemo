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
                url = MemoListCell.class.getResource("/images/placeholder.png");
            }

            Image image = new Image(url.toString());
            ImageView imageView = new ImageView(image);
            imageView.resize(64, 64);
            imageView.maxHeight(64);
            imageView.maxWidth(64);
            imageView.setFitHeight(64);
            imageView.setFitWidth(64);

            Label title = new Label();
            title.textProperty().bind(item.title);
            HBox box = new HBox(imageView, title);
            setGraphic(box);
        }
    }
}

