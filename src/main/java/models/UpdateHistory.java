package models;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import views.Observer;
import views.ViewUtilities;

import java.util.ArrayList;
import java.util.Date;

public class UpdateHistory implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    public ArrayList<UpdateMessage> updateList = new ArrayList<>();

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
            card.getChildren().add(info);
            card.getChildren().add(new Separator());
            updateCards.add(card);
        }
    }

    public void addMessage() {

    }

    public void updateList() {
        notifyObservers();
    }



    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        makeList();
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}