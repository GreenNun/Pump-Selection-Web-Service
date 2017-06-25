package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.DriveAssembly;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.repository.DriveAssemblyRepository;
import eu.bausov.projects.srvpumpselection.service.DriveAssemblyService;
import eu.bausov.projects.srvpumpselection.service.PartsUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class DriveAssemblyServiceImpl implements DriveAssemblyService, PartsUpdater {
    private final DriveAssemblyRepository driveAssemblyRepository;

    @Autowired
    public DriveAssemblyServiceImpl(DriveAssemblyRepository driveAssemblyRepository) {
        this.driveAssemblyRepository = driveAssemblyRepository;
    }

    @Override
    public List<DriveAssembly> findAllDriveAssemblies() {
        return driveAssemblyRepository.findAll();
    }

    @Override
    public DriveAssembly findOneDriveAssembly(Long id) {
        return driveAssemblyRepository.findOne(id);
    }

    @Override
    public void addToPartLists(Pump pump, long[] driveAssembliesIdentifiers) {
        add(pump, driveAssemblyRepository, driveAssembliesIdentifiers);
    }
}
