package views;

import models.Observable;

public interface Observer {
    public void update(Observable observable);
}
