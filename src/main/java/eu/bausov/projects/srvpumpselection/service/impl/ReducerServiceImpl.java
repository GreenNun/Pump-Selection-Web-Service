package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.Reducer;
import eu.bausov.projects.srvpumpselection.repository.ReducerRepository;
import eu.bausov.projects.srvpumpselection.service.ReducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class ReducerServiceImpl implements ReducerService {
    private final ReducerRepository reducerRepository;

    @Autowired
    public ReducerServiceImpl(ReducerRepository reducerRepository) {
        this.reducerRepository = reducerRepository;
    }

    @Override
    public List<Reducer> findAllReducers() {
        return reducerRepository.findAll();
    }

    @Override
    public Reducer findOneReducer(Long id) {
        return reducerRepository.findOne(id);
    }

    @Override
    public Reducer saveOneReducer(Reducer reducer) {
        return reducerRepository.save(reducer);
    }

    @Override
    public void deleteOneReducer(Reducer reducer) {
        reducerRepository.delete(reducer);
    }
}
