package vmemo.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import vmemo.MemoRepository;
import vmemo.model.Event;

public class EventView {
    private final Event databaseModel;

    public final StringProperty title = new SimpleStringProperty();
    public final StringProperty description = new SimpleStringProperty();

    //database setup for saving information
    public EventView(Event databaseModel) {
        this.databaseModel = databaseModel;
        this.title.addListener((observable, oldValue, newValue) -> databaseModel.title = newValue);
        this.description.addListener((observable, oldValue, newValue) -> databaseModel.description = newValue);
        this.title.set(databaseModel.title);
        this.description.set(databaseModel.description);
    }
//saving the updated information
    public void save(MemoRepository repository) {
        repository.save(this.databaseModel);
    }
}
