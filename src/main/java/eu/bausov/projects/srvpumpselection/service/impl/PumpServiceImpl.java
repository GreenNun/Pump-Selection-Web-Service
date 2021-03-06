package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.repository.PumpRepository;
import eu.bausov.projects.srvpumpselection.service.PumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class PumpServiceImpl implements PumpService {
    private final PumpRepository pumpRepository;

    @Autowired
    public PumpServiceImpl(PumpRepository pumpRepository) {
        this.pumpRepository = pumpRepository;
    }

    @Override
    public List<Pump> findAllPumps() {
        return pumpRepository.findAll();
    }

    @Override
    public Pump findOnePump(Long id) {
        return pumpRepository.findOne(id);
    }

    @Override
    public Pump saveOnePump(Pump pump) {
        return pumpRepository.save(pump);
    }

    @Override
    public void deleteOnePump(Pump pump) {
        pumpRepository.delete(pump);
    }
}
