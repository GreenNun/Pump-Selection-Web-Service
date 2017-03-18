package eu.bausov.projects.srvpumpselection.repository;

import eu.bausov.projects.srvpumpselection.bo.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface ProducerRepository extends CrudRepository<Producer, Long> {
    List<Producer> findAll();
}
