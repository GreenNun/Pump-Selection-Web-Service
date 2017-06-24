package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.equipment.Seal;
import eu.bausov.projects.srvpumpselection.service.SealService;
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
 * Created by GreenNun on 23.06.17.
 */
@RestController
@RequestMapping(value = "/seal")
public class SealController {
    private final Logger LOGGER = LoggerFactory.getLogger(SealController.class);

    private final SealService sealService;

    @Autowired
    public SealController(SealService sealService) {
        this.sealService = sealService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public Seal findOneConstant(@RequestBody Long id) {
        LOGGER.debug("Seal request");
        return sealService.findOneSeal(id);
    }

    @Transactional
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Seal> findAllSeals() {
        LOGGER.debug("Seal list request");
        return sealService.findAllSeals();
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Seal saveConstant(@RequestBody Seal seal) {
        LOGGER.debug("Seal save request");
        return sealService.saveOneSeal(seal);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Seal seal) {
        LOGGER.debug("Seal remove request");
        sealService.deleteOneSeal(seal);
    }
}
