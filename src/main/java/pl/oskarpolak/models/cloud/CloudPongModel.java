package pl.oskarpolak.models.cloud;

/**
 * Created by OskarPraca on 2017-03-24.
 */
public class CloudPongModel {
    private String to;
    private CloudPongModelInit data;

    public CloudPongModel() {
        data = new CloudPongModelInit();
    }

    public void setTo(String to) {
        this.to = to;
    }

    private class CloudPongModelInit {
        private long time = System.currentTimeMillis();
    }
}
