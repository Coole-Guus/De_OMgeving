package models;

import views.Observer;

public class AccountLogin implements Observable {

    public String username;

    public String getAccountRol() {
        return accountRol;
    }

    public String accountRol;
    public AccountLogin(String username, String accountRol) {
        this.username = username;
        this.accountRol = accountRol;
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