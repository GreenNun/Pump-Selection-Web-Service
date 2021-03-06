package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.repository.ConstantRepository;
import eu.bausov.projects.srvpumpselection.service.ConstantService;
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
    public List<Constant> findAllConstants() {
        return constantRepository.findAll();
    }

    @Override
    public List<Constant> findAllConstantsByName(String name) {
        return constantRepository.findAllByName(name);
    }

    @Override
    public Constant findOneConstant(Long id) {
        return constantRepository.findOne(id);
    }

    @Override // return id
    public Constant saveOneConstant(Constant constant) {
        return constantRepository.save(constant);
    }

    @Override
    public void deleteOneConstant(Constant constant) {
        constantRepository.delete(constant);
    }
}
