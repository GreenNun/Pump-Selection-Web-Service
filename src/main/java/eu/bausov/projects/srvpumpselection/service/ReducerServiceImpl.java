package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Reducer;
import eu.bausov.projects.srvpumpselection.repository.ReducerRepository;
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
}
