package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.DriverAssembly;
import eu.bausov.projects.srvpumpselection.repository.DriverAssemblyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class DriverAssemblyServiceImpl implements DriverAssemblyService {
    private final DriverAssemblyRepository driverAssemblyRepository;

    @Autowired
    public DriverAssemblyServiceImpl(DriverAssemblyRepository driverAssemblyRepository) {
        this.driverAssemblyRepository = driverAssemblyRepository;
    }

    @Override
    public List<DriverAssembly> findAllDriverAssemblies() {
        return driverAssemblyRepository.findAll();
    }
}
