package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Reducer;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface ReducerService {
    List<Reducer> findAllReducers();
    Reducer findOneReducer(Long id);
}
