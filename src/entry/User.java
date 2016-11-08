package entry;

import dao.Contact;

import java.util.Date;
import java.util.UUID;

/**
 * Created by hp123 on 2016/10/13.
 */
public class User extends Contact {
    private int id;
    private String message;
    private Date date;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(UUID id) {
        id = UUID.randomUUID();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public User(int id, String messageDetail, Date messageTime) {
        super();
        this.id = id;
        this.message = messageDetail;
        this.date = messageTime;
    }

    public String toString() {
        return "User [Id=" + this.id + ", message=" + this.message + ",date=" + this.date + "]";
    }

    public void setMessageTime(Date messageTime) {
        this.date = messageTime;
    }
}
