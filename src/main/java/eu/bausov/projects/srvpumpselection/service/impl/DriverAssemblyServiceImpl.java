package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.DriverAssembly;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.repository.DriverAssemblyRepository;
import eu.bausov.projects.srvpumpselection.service.DriverAssemblyService;
import eu.bausov.projects.srvpumpselection.service.PartsUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class DriverAssemblyServiceImpl implements DriverAssemblyService, PartsUpdater {
    private final DriverAssemblyRepository driverAssemblyRepository;

    @Autowired
    public DriverAssemblyServiceImpl(DriverAssemblyRepository driverAssemblyRepository) {
        this.driverAssemblyRepository = driverAssemblyRepository;
    }

    @Override
    public List<DriverAssembly> findAllDriverAssemblies() {
        return driverAssemblyRepository.findAll();
    }

    @Override
    public DriverAssembly findOneDriverAssembly(Long id) {
        return driverAssemblyRepository.findOne(id);
    }

    @Override
    public void addToPartLists(Pump pump, long[] driverAssembliesIdentifiers) {
        add(pump, driverAssemblyRepository, driverAssembliesIdentifiers);
    }
}
