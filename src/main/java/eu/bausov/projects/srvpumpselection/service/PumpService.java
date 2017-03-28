package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.bo.equipment.PumpPart;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface PumpService {
    List<Pump> findAllPumps();
    Pump findOnePump(Long id);
    void savePump(Pump pump);
}
