package models;

import java.util.Date;

public class UpdateMessage {
    private String message;
    private Date messageDate;
    private String editorName;

    public UpdateMessage(String message, Date messageDate, String editorName) {
        this.message = message;
        this.messageDate = messageDate;
        this.editorName = editorName;
    }

    public String getMessage() {
        return message;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public String getEditorName() {
        return editorName;
    }
}
