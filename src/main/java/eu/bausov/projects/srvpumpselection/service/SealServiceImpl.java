package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Seal;
import eu.bausov.projects.srvpumpselection.repository.SealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class SealServiceImpl implements SealService {
    private final SealRepository sealRepository;

    @Autowired
    public SealServiceImpl(SealRepository sealRepository) {
        this.sealRepository = sealRepository;
    }

    @Override
    public List<Seal> findAllSeals() {
        return sealRepository.findAll();
    }
}
