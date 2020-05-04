package vmemo.view;

import javafx.scene.control.ListCell;

public class EventListCell extends ListCell<EventView> {
    //Updates the title and description to the new title and description
    @Override
    protected void updateItem(EventView item, boolean empty) {
        super.updateItem(item, empty);
        if(item == null) return;
        setText(item.title.get() + " " + item.description.get());
    }
}
