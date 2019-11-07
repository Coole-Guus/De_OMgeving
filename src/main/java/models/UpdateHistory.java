package models;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import views.Observer;
import views.ViewUtilities;

import java.util.ArrayList;
import java.util.Date;

public class UpdateHistory implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    private ArrayList<UpdateMessage> updateList = new ArrayList<>();

    public ArrayList<VBox> updateCards = new ArrayList<>();

    public void makeList() {
        updateCards.clear();
        for(UpdateMessage update : updateList) {
            VBox card = new VBox();
            card.getStyleClass().add("update-card");

            card.getChildren().add(new Label(update.getMessage()));

            HBox info = new HBox();
            info.getStyleClass().add("update-info");
            info.getChildren().add(new Label("Posted by: " + update.getEditorName()));
            info.getChildren().add(new Label( "on: " + update.getMessageDate()));

            updateCards.add(card);
        }
    }

    public void addMessage() {

    }

    public void updateList() {
        fillList();
        makeList();
        notifyObservers();
    }

    public void fillList() {
        //replace with database baloney
        for (int i = 0; i < 10; i++) {
            UpdateMessage update = new UpdateMessage("Roses are red,\nViolets are blue,\n", new Date(2323223232L), "Henk van Damme");
            updateList.add(update);
        }
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}