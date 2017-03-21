package eu.bausov.projects.srvpumpselection.repository;

import eu.bausov.projects.srvpumpselection.bo.SpeedCorrectionCoefficient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface SpeedCorrectionCoefficientRepository extends CrudRepository<SpeedCorrectionCoefficient, Long> {
    List<SpeedCorrectionCoefficient> findAll();
}
