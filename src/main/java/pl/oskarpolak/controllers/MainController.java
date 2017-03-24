package pl.oskarpolak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.oskarpolak.Logger;
import pl.oskarpolak.models.SmsModel;
import pl.oskarpolak.models.UserModel;
import pl.oskarpolak.models.forms.SendSmsForm;
import pl.oskarpolak.services.SendMessageService;
import pl.oskarpolak.services.UserService;

import java.util.Optional;

/**
 * Created by OskarPraca on 2017-03-22.
 */
@Controller
public class MainController {


    @Autowired
    SendMessageService sendMessageService;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private Facebook facebook;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        Optional<UserModel> user = userService.findOneByFacebookid(getFbUserId());

        Logger.log("Test", "Default device is " + user.get().getDefaultDevice().toString());

        // TODO usuniecie debugu
        model.addAttribute("smsform", new SendSmsForm());
        model.addAttribute("hasDeviceConnected", user.get().hasDeviceConnected());
        return "index";
    }

    @RequestMapping(value = "/sendsms", method = RequestMethod.POST)
    public String sendSmsForm(@ModelAttribute("sms") SendSmsForm sms) {
        SmsModel model = new SmsModel();
        model.setMessage(sms.getMessage());
        model.setToWhoNumber(sms.getToWhoNumber());

        sendMessageService.save(model);
        return "redirect:/index";
    }


    private String getFbUserId() {
        return facebook.userOperations().getUserProfile().getId();
    }
}
