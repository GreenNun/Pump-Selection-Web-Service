package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.equipment.DriveAssembly;
import eu.bausov.projects.srvpumpselection.service.DriveAssemblyService;
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
 * Created by GreenNun on 25.06.17.
 */
@RestController
@RequestMapping(value = "/assembly")
public class DriveAssemblyController {
    private final Logger LOGGER = LoggerFactory.getLogger(DriveAssemblyController.class);

    private final DriveAssemblyService driveAssemblyService;

    @Autowired
    public DriveAssemblyController(DriveAssemblyService driveAssemblyService) {
        this.driveAssemblyService = driveAssemblyService;
    }

    @RequestMapping(value = "/(id)", method = RequestMethod.GET)
    public DriveAssembly findOneConstant(@RequestBody Long id) {
        LOGGER.debug("DriveAssembly request");
        return driveAssemblyService.findOneDriveAssembly(id);
    }

    @Transactional
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<DriveAssembly> findAllDriveAssemblies() {
        LOGGER.debug("DriveAssembly list request");
        return driveAssemblyService.findAllDriveAssemblies();
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DriveAssembly saveConstant(@RequestBody DriveAssembly driveAssembly) {
        LOGGER.debug("DriveAssembly save request");
        return driveAssemblyService.saveOneDriveAssembly(driveAssembly);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody DriveAssembly driveAssembly) {
        LOGGER.debug("DriveAssembly remove request");
        driveAssemblyService.deleteOneDriveAssembly(driveAssembly);
    }
}
