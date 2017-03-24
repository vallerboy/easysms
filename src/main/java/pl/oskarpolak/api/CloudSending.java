package pl.oskarpolak.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.oskarpolak.models.DeviceModel;
import pl.oskarpolak.models.cloud.CloudDataModel;
import pl.oskarpolak.models.cloud.CloudPongModel;
import pl.oskarpolak.models.cloud.CloudSmsModel;
import pl.oskarpolak.services.DeviceService;

import java.util.Arrays;

/**
 * Created by OskarPraca on 2017-03-23.
 */

@Service
public class CloudSending {

    @Autowired
    DeviceService deviceService;


    public final String appKey = "AAAA4tODNco:APA91bGKTQQiUBuV4INYGaj8k9UMcRcINYlBiqIWiFr4kVo3o_pXV0Bp9DrnhRyR1lSNSIeTnt63os9-AFiGZSU6CxNV8w1R5shtLiPM25jOvjZv6ETBtfRoo5hK9aqyyHaZnhX-YzYe";
    public final String cloudUrl = "https://fcm.googleapis.com/fcm/send";


    public ResponseEntity sendMessage(String to, CloudSmsModel smsModel) {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.put("Authorization", Arrays.asList("key=" + appKey));

        CloudDataModel model = new CloudDataModel();
        model.setTo(to);
        model.setData(smsModel);


        HttpEntity<CloudDataModel> entity = new HttpEntity<CloudDataModel>(model, headers);

        return template.postForEntity(cloudUrl, entity, String.class);
    }


    public ResponseEntity ping(String firebaseId) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.put("Authorization", Arrays.asList("key=" + appKey));

        CloudPongModel model = new CloudPongModel();
        model.setTo(firebaseId);

        HttpEntity<CloudPongModel> entity = new HttpEntity<>(model, headers);

        return template.postForEntity(cloudUrl, entity, String.class);
    }


    public long pong(String firebaseId, long time) {
        // dostano odpowiedź
        //todo handle answer from client
        DeviceModel deviceModel = deviceService.findByFirebaseid(firebaseId);
        deviceModel.setOnline(true);
        deviceService.save(deviceModel);
        return System.currentTimeMillis() - time;
    }


}
