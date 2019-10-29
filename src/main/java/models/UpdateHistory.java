package models;

import views.Observer;

import java.util.ArrayList;
import java.util.Date;

public class UpdateHistory implements Observable {

    private ArrayList<UpdateMessage> messageList;

    public void addMessage(String message, Date messageDate, String editorName) {
        messageList.add(new UpdateMessage(message, messageDate, editorName));
    }

    public UpdateMessage getMessage(int index) {
        return messageList.get(index);
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}