package pl.oskarpolak.models.cloud;

/**
 * Created by OskarPraca on 2017-03-23.
 */
public class CloudSmsModel {

    // do not change!
    private String message;
    private String number;

    public CloudSmsModel(String message, String number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
