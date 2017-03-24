package pl.oskarpolak.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by OskarPraca on 2017-03-23.
 */
@Entity(name = "user")
public class UserModel {

    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String facebookid;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userid")
    private List<DeviceModel> devices;

    private int defaultdevice;

    public boolean hasDeviceConnected() {
        return !devices.isEmpty();
    }

    public DeviceModel getDefaultDevice() {
        for (DeviceModel model : devices) {
            if (model.getId() == defaultdevice) {
                return model;
            }
        }
        return null;
    }

    public void registerDevice(DeviceModel deviceModel) {
          devices.add(deviceModel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookId() {
        return facebookid;
    }

    public void setFacebookId(String facebookid) {
        this.facebookid = facebookid;
    }

}
