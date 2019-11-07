package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UpdateMessage {

    @Expose
    @SerializedName("bericht")
    private String message;

    @Expose
    @SerializedName("dateTime")
    private Date messageDate;

    @Expose
    @SerializedName("editorName")
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
