package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.service.ConstantService;
import eu.bausov.projects.srvpumpselection.utils.DBConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by GreenNun on 07.04.17.
 */
@RestController
@RequestMapping(value = "/constant")
public class ConstantController {
    private final Logger LOGGER = LoggerFactory.getLogger(ConstantController.class);

    private final ConstantService constantService;

    @Autowired
    public ConstantController(ConstantService constantService) {
        this.constantService = constantService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public Constant findOneConstant(@RequestBody Long id) {
        LOGGER.debug("Constant request");
        return constantService.findOneConstant(id);
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public List<Constant> findAllConstantsByName(@RequestBody String name) {
//        LOGGER.debug("Constants list request");
//        return constantService.findAllConstantsByName(name);
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Constant> findAllConstantsByName() {
        LOGGER.debug("Constants list request");
        return constantService.findAllConstantsByName(DBConst.COUNTRY);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Constant saveConstant(@RequestBody Constant constant) {
        LOGGER.debug("Constant save request");
        return constantService.saveOneConstant(constant);
    }

}
