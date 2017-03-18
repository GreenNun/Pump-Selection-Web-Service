package eu.bausov.projects.srvpumpselection.repository;

import eu.bausov.projects.srvpumpselection.bo.equipment.DriverAssembly;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface DriverAssemblyRepository extends CrudRepository<DriverAssembly, Long> {
    List<DriverAssembly> findAll();
}
