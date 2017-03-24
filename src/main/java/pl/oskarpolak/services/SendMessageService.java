package pl.oskarpolak.services;

import org.springframework.data.repository.CrudRepository;
import pl.oskarpolak.models.SmsModel;

import java.util.List;

/**
 * Created by OskarPraca on 2017-03-22.
 */
public interface SendMessageService extends CrudRepository<SmsModel, Integer> {
    List<SmsModel> findAllBySenderAndIssend(int senderId, int isSend);
}
