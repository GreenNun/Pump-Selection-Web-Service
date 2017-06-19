package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.equipment.Reducer;
import eu.bausov.projects.srvpumpselection.service.ReducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by GreenNun on 19.06.17.
 */
@RestController
@RequestMapping(value = "/reducer")
public class ReducerController {
    private final Logger LOGGER = LoggerFactory.getLogger(ReducerController.class);

    private final ReducerService reducerService;

    @Autowired
    public ReducerController(ReducerService reducerService) {
        this.reducerService = reducerService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public Reducer findOneConstant(@RequestBody Long id) {
        LOGGER.debug("Reducer request");
        return reducerService.findOneReducer(id);
    }

    @Transactional
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Reducer> findAllReducers() {
        LOGGER.debug("Reducer list request");
        return reducerService.findAllReducers();
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Reducer saveConstant(@RequestBody Reducer reducer) {
        LOGGER.debug("Reducer save request");
        return reducerService.saveOneReducer(reducer);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Reducer reducer) {
        LOGGER.debug("Reducer remove request");
        reducerService.deleteOneReducer(reducer);
    }
}
