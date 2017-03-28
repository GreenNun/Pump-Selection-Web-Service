package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.DriverAssembly;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface DriverAssemblyService {
    List<DriverAssembly> findAllDriverAssemblies();
    DriverAssembly findOneDriverAssembly(Long id);
    void addToPartLists(Pump pump, long[] driverAssembliesIdentifiers);
}
