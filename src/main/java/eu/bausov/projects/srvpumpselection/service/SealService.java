package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.bo.equipment.Seal;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface SealService {
    List<Seal> findAllSeals();
    Seal findOneSeal(Long id);
    void addToPartLists(Pump pump, long[] sealsIdentifiers);
}
