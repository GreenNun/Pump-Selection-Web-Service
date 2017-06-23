package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.equipment.Frame;
import eu.bausov.projects.srvpumpselection.service.FrameService;
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
@RequestMapping(value = "/frame")
public class FrameController {
    private final Logger LOGGER = LoggerFactory.getLogger(FrameController.class);

    private final FrameService frameService;

    @Autowired
    public FrameController(FrameService frameService) {
        this.frameService = frameService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public Frame findOneConstant(@RequestBody Long id) {
        LOGGER.debug("Frame request");
        return frameService.findOneFrame(id);
    }

    @Transactional
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Frame> findAllFrames() {
        LOGGER.debug("Frame list request");
        return frameService.findAllFrames();
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Frame saveConstant(@RequestBody Frame frame) {
        LOGGER.debug("Frame save request");
        return frameService.saveOneFrame(frame);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Frame frame) {
        LOGGER.debug("Frame remove request");
        frameService.deleteOneFrame(frame);
    }
}
