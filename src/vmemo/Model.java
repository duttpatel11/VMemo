/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Dutt2
 */
public class Model {

    private final IntegerProperty view = new SimpleIntegerProperty();

    public IntegerProperty ViewProperty() {
        return view;
    }

    public final int getView() {
        return ViewProperty().get();
    }

    public final void setView(int view) {
        ViewProperty().set(view);
    }

}
