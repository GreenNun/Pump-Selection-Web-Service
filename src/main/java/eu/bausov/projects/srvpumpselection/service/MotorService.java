package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Motor;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface MotorService {
    List<Motor> findAllMotors();
}
