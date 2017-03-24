package pl.oskarpolak.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by OskarPraca on 2017-03-22.
 */

@Entity(name = "messages")
public class SmsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String receivers;
    private String message;
    private int issend;
    private Timestamp date;
    private int sender;


    public SmsModel(String receivers, String message) {
        this.receivers = receivers;
        this.message = message;
    }

    public SmsModel() {
    }

    public boolean isSend() {
        return issend == 1 ? true : false;
    }

    public void setSend(int send) {
        issend = send;
    }

    public String getToWhoNumber() {
        return receivers;
    }

    public void setToWhoNumber(String toWhoNumber) {
        this.receivers = toWhoNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
