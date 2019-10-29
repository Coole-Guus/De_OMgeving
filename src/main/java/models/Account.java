package models;

import views.Observer;

public class Account implements Observable {
    public String userName;
    public String passwd;
    public enum accountRole
    {
        gebruiker, medewerker, admin
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
