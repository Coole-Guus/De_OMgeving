package models;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import views.Observer;
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

            Label messageLabel = new Label(update.getMessage());
            messageLabel.setPadding(new Insets(10));
            messageLabel.setFont(new Font(15));
            card.getChildren().add(messageLabel);

            HBox info = new HBox();
            info.getStyleClass().add("update-info");
            info.getChildren().add(new Label("Posted by: " + update.getEditorName()));

            info.getChildren().add(new Label( "on: " + update.getMessageDate()));
            card.getChildren().add(info);
            info.setPadding(new Insets(0, 10, 0, 10));
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