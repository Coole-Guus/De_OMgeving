package models;

import views.Observer;

public class AccountLogin implements Observable {

    public String username;
    public String accountrole;
    public AccountLogin(String username, String accountrole) {
        this.username = username;
        this.accountrole = accountrole;
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

    public String getUsername() {
        return username;
    }
}