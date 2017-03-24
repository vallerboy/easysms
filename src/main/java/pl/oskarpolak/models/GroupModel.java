package pl.oskarpolak.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by OskarPraca on 2017-03-23.
 */
@Entity(name = "group")
public class GroupModel {

    @Id
    private int id;
    private String name;
    private int userId;
    private String recipients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }
}
