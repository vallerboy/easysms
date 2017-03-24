package pl.oskarpolak.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;
import pl.oskarpolak.models.UserModel;
import pl.oskarpolak.services.UserService;

import java.util.Optional;

/**
 * Created by OskarPraca on 2017-03-23.
 */
@Component
public class FacebookInterceptor implements ConnectInterceptor<Facebook> {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private Facebook facebook;

    @Autowired
    private UserService userService;

    @Override
    public void preConnect(ConnectionFactory connectionFactory, MultiValueMap multiValueMap, WebRequest webRequest) {

    }

    @Override
    public void postConnect(Connection connection, WebRequest webRequest) {

        // Próba rejestracji po zalogowaniu

        Optional<UserModel> userModel = userService.findOneByFacebookid(facebook.userOperations().getUserProfile().getId());
        if (!userModel.isPresent()) {
            UserModel newUserModel = new UserModel();
            newUserModel.setFacebookId(facebook.userOperations().getUserProfile().getId());
            newUserModel.setUsername(facebook.userOperations().getUserProfile().getName());
            newUserModel.setEmail(facebook.userOperations().getUserProfile().getEmail());
            newUserModel.setPassword("");
            userService.save(newUserModel);
        }
    }
}