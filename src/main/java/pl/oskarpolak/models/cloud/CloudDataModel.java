package pl.oskarpolak.models.cloud;

/**
 * Created by OskarPraca on 2017-03-23.
 */
public class CloudDataModel {

    // do not change!
    private String to;
    private CloudSmsModel data;


    public CloudSmsModel getData() {
        return data;
    }

    public void setData(CloudSmsModel data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CloudDataModel that = (CloudDataModel) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return to != null ? to.equals(that.to) : that.to == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }
}
