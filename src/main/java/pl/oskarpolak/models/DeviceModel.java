package pl.oskarpolak.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by OskarPraca on 2017-03-23.
 */
@Entity(name = "device")
public class DeviceModel {

    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserModel userid;

    private int isonline;

    private String firebaseid;


    /////////////////////////////////

    public boolean isOnline() {
        return isonline == 1 ? true : false;
    }

    public void setOnline(boolean isOnline){
        if(isOnline) {
            isonline = 1;
            return;
        }
        isonline = 0;
    }

    public void setUser(UserModel userid) {
        this.userid = userid;
    }

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

    public UserModel getUser() {
        return userid;
    }

    public String getFirebaseId() {
        return firebaseid;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseid = firebaseId;
    }

    @Override
    public String toString() {
        return "DeviceModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userid +
                ", firebaseId='" + firebaseid + '\'' +
                '}';
    }
}

