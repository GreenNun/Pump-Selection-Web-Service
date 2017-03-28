package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.Equipment;
import eu.bausov.projects.srvpumpselection.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 28.03.17.
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentServiceImpl(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public List<Equipment> findAllEquipmentByProducerName(String producerName) {
        return equipmentService.findAllEquipmentByProducerName(producerName);
    }
}
