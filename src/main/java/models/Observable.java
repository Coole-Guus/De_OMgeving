package models;

import views.Observer;

public interface Observable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
