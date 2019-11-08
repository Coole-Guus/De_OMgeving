package models;

import views.Observer;

public class AccountLogin implements Observable {

    public String username;
    public String accountRol;

    /**
     * @author Guus Kleinlein
     * AccountLogin model.
     * @param username
     * @param accountRol
     */
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

    public String getAccountRol() { return accountRol; }
}