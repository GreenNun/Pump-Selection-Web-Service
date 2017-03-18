package eu.bausov.projects.srvpumpselection.dao;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface PumpDAO extends CrudRepository<Pump, Long> {
    List<Pump> findAll();
}
