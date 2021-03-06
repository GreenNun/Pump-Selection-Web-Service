package eu.bausov.projects.srvpumpselection.repository;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface PumpRepository extends CrudRepository<Pump, Long> {
    List<Pump> findAll();
}
