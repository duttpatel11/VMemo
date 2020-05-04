package vmemo.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;
import vmemo.controller.memo.MemoCreationViewController;
import vmemo.controller.memo.MemoListCellController;
import vmemo.model.Memo;

import java.io.IOException;
import java.net.URL;

public class MemoListCell extends ListCell<MemoView> {

    //Sets the image size selected & updates the memoview
    @Override
    protected void updateItem(MemoView item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            Node root = this.loadListCellControllerNode(item);
            super.setGraphic(root);
        }
    }

    private Node loadListCellControllerNode(MemoView item) {
        try {
            FXMLLoader loader = new FXMLLoader(MemoListCellController.class.getResource("MemoListCellView.fxml"));
            Node root = loader.load();
            ((MemoListCellController) loader.getController()).bind(item);
            return root;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

