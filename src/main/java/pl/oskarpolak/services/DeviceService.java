package pl.oskarpolak.services;

import org.springframework.data.repository.CrudRepository;
import pl.oskarpolak.models.DeviceModel;

/**
 * Created by OskarPraca on 2017-03-24.
 */
public interface DeviceService extends CrudRepository<DeviceModel, Integer> {
    DeviceModel findByFirebaseid(String firebase);
}
