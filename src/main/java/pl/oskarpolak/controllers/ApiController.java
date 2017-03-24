package pl.oskarpolak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.oskarpolak.api.CloudSending;
import pl.oskarpolak.models.DeviceModel;
import pl.oskarpolak.models.SmsModel;
import pl.oskarpolak.models.UserModel;
import pl.oskarpolak.services.SendMessageService;
import pl.oskarpolak.services.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Created by OskarPraca on 2017-03-22.
 */
@Controller
public class ApiController {

    @Autowired
    SendMessageService serviceMessageService;

    @Autowired
    UserService userService;

    @Autowired
    CloudSending cloudSending;



    @RequestMapping(value = "/api/messages/{userId}")
    public ResponseEntity getMessages(@PathVariable("userId") int userId) {
        List<SmsModel> smsList = serviceMessageService.findAllBySenderAndIssend(userId, 1);
        return new ResponseEntity(smsList, HttpStatus.OK);
    }



    ////////// REGISTER USER DEVICE BY FACEBOOK ID //////////

    @RequestMapping(value = "/api/registerDevice/{userId}/{firebaseId}/{deviceName}")
    public ResponseEntity registerFirebaseDevice(@PathVariable("userId") String userId, @PathVariable("firebaseId") String firebaseId, @PathVariable("deviceName") String name) {
        Optional<UserModel> userModel = userService.findOneByFacebookid(userId);
        if(userModel.isPresent()) {
            DeviceModel deviceModel = new DeviceModel();
            deviceModel.setFirebaseId(firebaseId);
            deviceModel.setName(name);
            userModel.get().registerDevice(deviceModel);
            userService.save(userModel.get());
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    ////////// PONG REQUEST //////////

    @RequestMapping(value = "/api/pong/{firebaseId}/{time}")
    public ResponseEntity pong(@PathVariable("firebaseId") String firebaseId, @PathVariable("time") long time) {
        cloudSending.pong(firebaseId, time);
        return new ResponseEntity(HttpStatus.OK);
    }


}
