package pl.oskarpolak.services;

import org.springframework.data.repository.CrudRepository;
import pl.oskarpolak.models.UserModel;

import java.util.Optional;

/**
 * Created by OskarPraca on 2017-03-23.
 */
public interface UserService extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findOneByFacebookid(String facebookId);
}
