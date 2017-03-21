package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Motor;
import eu.bausov.projects.srvpumpselection.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class MotorServiceImpl implements MotorService {
    private final MotorRepository motorRepository;

    @Autowired
    public MotorServiceImpl(MotorRepository motorRepository) {
        this.motorRepository = motorRepository;
    }

    @Override
    public List<Motor> findAllMotors() {
        return motorRepository.findAll();
    }
}
