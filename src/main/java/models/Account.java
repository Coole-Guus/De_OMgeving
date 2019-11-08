package models;

import com.google.gson.annotations.Expose;
import views.Observer;


public class Account implements Observable {

    public String getAccountNaam() {
        return accountNaam;
    }

    public accountRole getAccountRol() {
        return accountRol;
    }

    public int getAccountId() {
        return accountId;
    }

    @Expose
    public int accountId;
    @Expose
    public String accountNaam;
    @Expose
    public String accountWachtwoord;
    @Expose
    public accountRole accountRol;

    public enum accountRole
    {
        Gebruiker,
        Medewerker,
        Admin
    }

    /**
     * @author Guus Kleinlein
     * Account model.
     * @param userName
     * @param passwd
     * @param accountRole
     * @param accountId
     */
    public Account(String userName, String passwd, String accountRole, int accountId) {
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
