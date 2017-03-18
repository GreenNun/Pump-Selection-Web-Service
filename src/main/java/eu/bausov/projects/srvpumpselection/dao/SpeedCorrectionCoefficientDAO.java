package eu.bausov.projects.srvpumpselection.dao;

import eu.bausov.projects.srvpumpselection.bo.SpeedCorrectionCoefficient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface SpeedCorrectionCoefficientDAO extends CrudRepository<SpeedCorrectionCoefficient, Long> {
}
