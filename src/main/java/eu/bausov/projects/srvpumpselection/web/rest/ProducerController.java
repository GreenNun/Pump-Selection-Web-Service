package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.service.ProducerService;
import eu.bausov.projects.srvpumpselection.utils.DBConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by GreenNun on 14.04.17.
 */
@RestController
@RequestMapping(value = "/producer")
public class ProducerController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private final ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public Producer findOneConstant(@RequestBody Long id) {
        LOGGER.debug("Producer request");
        return producerService.findOneProducer(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Producer> findAllConstantsByName() {
        LOGGER.debug("Producer list request");
        return producerService.findAllProducers();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Producer saveConstant(@RequestBody Producer producer) {
        LOGGER.debug("Producer save request");
        return producerService.saveOneProducer(producer);
    }
}
