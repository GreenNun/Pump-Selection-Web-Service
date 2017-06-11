package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.Constant;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface ConstantService {
    List<Constant> findAllConstants();
    List<Constant> findAllConstantsByName(String name);
    Constant findOneConstant(Long id);
    Constant saveOneConstant(Constant constant);
    void deleteOneConstant(Constant constant);
}
