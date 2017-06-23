package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.service.PumpService;
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
@RequestMapping(value = "/pump")
public class PumpController {
    private final Logger LOGGER = LoggerFactory.getLogger(PumpController.class);

    private final PumpService pumpService;

    @Autowired
    public PumpController(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public Pump findOneConstant(@RequestBody Long id) {
        LOGGER.debug("Pump request");
        return pumpService.findOnePump(id);
    }

    @Transactional
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Pump> findAllPumps() {
        LOGGER.debug("Pump list request");
        return pumpService.findAllPumps();
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Pump saveConstant(@RequestBody Pump pump) {
        LOGGER.debug("Pump save request");
        return pumpService.saveOnePump(pump);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Pump pump) {
        LOGGER.debug("Pump remove request");
        pumpService.deleteOnePump(pump);
    }
}
