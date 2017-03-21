package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.repository.ConstantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class ConstantServiceImpl implements ConstantService {
    private final ConstantRepository constantRepository;

    @Autowired
    public ConstantServiceImpl(ConstantRepository constantRepository) {
        this.constantRepository = constantRepository;
    }

    @Override
    public List<Constant> getAllConstants() {
        return constantRepository.findAll();
    }
}
