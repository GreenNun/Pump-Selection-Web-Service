package eu.bausov.projects.srvpumpselection.repository;

import eu.bausov.projects.srvpumpselection.bo.equipment.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GreenNun on 28.03.17.
 */
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
    List<Equipment> findAllByProducerProducerName(String producerName);
}
