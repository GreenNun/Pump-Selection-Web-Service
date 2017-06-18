package eu.bausov.projects.srvpumpselection.web.rest;

/**
 * Created by GreenNun on 18.06.17.
 */

import eu.bausov.projects.srvpumpselection.bo.equipment.Motor;
import eu.bausov.projects.srvpumpselection.service.MotorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/motor")
public class MotorController {
    private final Logger LOGGER = LoggerFactory.getLogger(MotorController.class);

    private final MotorService motorService;

    @Autowired
    public MotorController(MotorService motorService) {
        this.motorService = motorService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public Motor findOneConstant(@RequestBody Long id) {
        LOGGER.debug("Motor request");
        return motorService.findOneMotor(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Motor> findAllProducers() {
        LOGGER.debug("Motor list request");
        return motorService.findAllMotors();
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Motor saveConstant(@RequestBody Motor motor) {
        LOGGER.debug("Motor save request");
        return motorService.saveOneMotor(motor);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Motor motor) {
        LOGGER.debug("Motor remove request");
        motorService.deleteOneMotor(motor);
    }
}
