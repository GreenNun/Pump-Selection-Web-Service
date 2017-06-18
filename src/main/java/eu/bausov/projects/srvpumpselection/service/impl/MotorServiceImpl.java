package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.Motor;
import eu.bausov.projects.srvpumpselection.repository.MotorRepository;
import eu.bausov.projects.srvpumpselection.service.MotorService;
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

    @Override
    public Motor findOneMotor(Long id) {
        return motorRepository.findOne(id);
    }

    @Override
    public Motor saveOneMotor(Motor motor) {
        return motorRepository.save(motor);
    }

    @Override
    public void deleteOneMotor(Motor motor) {
        motorRepository.delete(motor);
    }
}
