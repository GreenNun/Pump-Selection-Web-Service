package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.SpeedCorrectionCoefficient;
import eu.bausov.projects.srvpumpselection.repository.SpeedCorrectionCoefficientRepository;
import eu.bausov.projects.srvpumpselection.service.SpeedCorrectionCoefficientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class SpeedCorrectionCoefficientServiceImpl implements SpeedCorrectionCoefficientService {
    private final SpeedCorrectionCoefficientRepository speedCorrectionCoefficientRepository;

    @Autowired
    public SpeedCorrectionCoefficientServiceImpl(SpeedCorrectionCoefficientRepository speedCorrectionCoefficientRepository) {
        this.speedCorrectionCoefficientRepository = speedCorrectionCoefficientRepository;
    }

    @Override
    public List<SpeedCorrectionCoefficient> findAllSpeedCorrectionCoefficients() {
        return speedCorrectionCoefficientRepository.findAll();
    }

    @Override
    public void saveSpeedCorrectionCoefficient(SpeedCorrectionCoefficient speedCorrectionCoefficient) {
        speedCorrectionCoefficientRepository.save(speedCorrectionCoefficient);
    }
}
