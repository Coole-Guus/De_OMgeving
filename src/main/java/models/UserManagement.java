package models;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import views.Observer;

import java.util.ArrayList;

public class UserManagement implements Observable {

    private ArrayList<Observer> observers = new ArrayList<> ();

    private Account[] accounts;

    public GridPane accountCard;

    @Override
    public void registerObserver(Observer observer) {
        System.out.println ("register observer");
        observers.add (observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println ("notifyObservers");
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    public void createAccountList(Account[] accounts) {
        this.accounts = accounts;
        makeList ();
        notifyObservers ();
    }

    public void makeList() {
        int currRow = 1;

        GridPane card = new GridPane();
        card.setId("accountGrid");
        card.getStyleClass().add("accoount-card");
        card.setMinWidth (300);
        card.setMinHeight (200);

        ColumnConstraints col1 = new ColumnConstraints ();
        col1.setPercentWidth (50);

        ColumnConstraints col2 = new ColumnConstraints ();
        col2.setPercentWidth (50);

        card.getColumnConstraints ().addAll (col1, col2);

        Label nameLabel = new Label();
        nameLabel.setText("accounts");
        nameLabel.getStyleClass().add("title");
        card.add(nameLabel, 0, 0, 2, 1);

        for (Account account : accounts) {
            card.add(new Label(account.getAccountNaam ()), 0, currRow);
            card.add(new Label(account.getAccountRol ().toString ()), 1, currRow);
            currRow++;
        }
        this.accountCard = card;
        System.out.println ("set card");
    }
}
