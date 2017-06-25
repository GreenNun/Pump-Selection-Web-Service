package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.DriveAssembly;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface DriveAssemblyService {
    List<DriveAssembly> findAllDriveAssemblies();
    DriveAssembly findOneDriveAssembly(Long id);
    void addToPartLists(Pump pump, long[] driveAssembliesIdentifiers);
}
