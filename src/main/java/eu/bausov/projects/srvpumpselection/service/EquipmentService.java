package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Equipment;

import java.util.List;

/**
 * Created by GreenNun on 28.03.17.
 */
public interface EquipmentService {
    List<Equipment> findAllEquipmentByProducerName(String producerName);
}
