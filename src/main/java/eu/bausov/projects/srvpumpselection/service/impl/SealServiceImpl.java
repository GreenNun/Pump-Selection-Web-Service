package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.bo.equipment.Seal;
import eu.bausov.projects.srvpumpselection.repository.SealRepository;
import eu.bausov.projects.srvpumpselection.service.PartsUpdater;
import eu.bausov.projects.srvpumpselection.service.SealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class SealServiceImpl implements SealService, PartsUpdater {
    private final SealRepository sealRepository;

    @Autowired
    public SealServiceImpl(SealRepository sealRepository) {
        this.sealRepository = sealRepository;
    }

    @Override
    public List<Seal> findAllSeals() {
        return sealRepository.findAll();
    }

    @Override
    public Seal findOneSeal(Long id) {
        return sealRepository.findOne(id);
    }

    @Override
    public Seal saveOneSeal(Seal seal) {
        return sealRepository.save(seal);
    }

    @Override
    public void deleteOneSeal(Seal seal) {
        sealRepository.delete(seal);
    }

    @Override
    public void addToPartLists(Pump pump, long[] identifiers){
        add(pump, sealRepository, identifiers);
    }
}
