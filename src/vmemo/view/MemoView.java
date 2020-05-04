/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import vmemo.MemoRepository;
import vmemo.model.Memo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Dutt2 & 12
 */

public class MemoView {
    public final Memo databaseModel;

    public StringProperty imageDescription = new SimpleStringProperty();
    public StringProperty title = new SimpleStringProperty();
    public StringProperty description = new SimpleStringProperty();
    public ObjectProperty<URL> imageProperty = new SimpleObjectProperty<>(MemoView.class.getResource("/images/placeholder.png"));
    public StringProperty recordingUrl;

    //Stores the memo in the database & checks to see each value
    public MemoView(Memo databaseModel) {
        this.databaseModel = databaseModel;
        this.imageDescription.set(databaseModel.description);
        this.title.set(databaseModel.title);

        if (databaseModel.imageUrl != null) {
            try {
                this.imageProperty.set(new URL(databaseModel.imageUrl));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        this.title.addListener((observable, oldValue, newValue) -> {
            this.databaseModel.title = newValue;
        });

        this.imageDescription.addListener((observable, oldValue, newValue) -> {
            this.databaseModel.imageDescription = newValue;
        });
        this.description.addListener((observable, oldValue, newValue) -> {
            this.databaseModel.description = newValue;
        });
        this.imageProperty.addListener((observable, oldValue, newValue) -> {
            this.databaseModel.imageUrl = newValue.toString();
        });
    }

    public void save(MemoRepository repository) {
        repository.save(this.databaseModel);
    }
}
