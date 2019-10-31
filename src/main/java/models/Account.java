package models;

import views.Observer;

public class Account implements Observable {

    public String getAccountNaam() {
        return accountNaam;
    }

    public String getAccountWachtwoord() {
        return accountWachtwoord;
    }

    public accountRole getAccountRol() {
        return accountRol;
    }

    public String getAccountId() {
        return accountId;
    }

    public String accountId;
    public String accountNaam;
    public String accountWachtwoord;
    public accountRole accountRol;

    public enum accountRole
    {
        Gebruiker, Medewerker, Admin
    }

    public Account(String userName, String passwd, String accountRole, String accountId) {
        this.accountNaam = userName;
        this.accountWachtwoord = passwd;
        this.accountId = accountId;

        if(accountRole.contains ("Gebruiker")) {
            this.accountRol = Account.accountRole.Gebruiker;
        } else if(accountRole.contains ("Admin")) {
            this.accountRol = Account.accountRole.Admin;
        } else if(accountRole.contains ("Medewerker")) {
            this.accountRol = Account.accountRole.Medewerker;
        }
    }


    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
