package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.service.ConstantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @Transactional
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public Constant findOneConstant(@RequestParam("id") Long id) {
        LOGGER.debug("Constant request");
        return constantService.findOneConstant(id);
    }

//    @Transactional
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public int delete(@RequestParam("id") Long id) {
//        LOGGER.debug("Constant remove request");
//        return constantService.deleteById(id);
//    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Constant constant) {
        LOGGER.debug("Constant remove request");
        constantService.deleteOneConstant(constant);
    }

    @Transactional
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Constant> findAllConstantsByName(@RequestParam("name") String name) {
        LOGGER.debug("Constants list request");
        return constantService.findAllConstantsByName(name);
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Constant saveConstant(@RequestBody Constant constant) {
        LOGGER.debug("Constant save request");
        return constantService.saveOneConstant(constant);
    }
}
