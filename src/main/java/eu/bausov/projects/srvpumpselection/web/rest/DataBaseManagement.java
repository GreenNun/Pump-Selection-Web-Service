package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.bo.equipment.DriveAssembly;
import eu.bausov.projects.srvpumpselection.bo.equipment.Frame;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.bo.equipment.Seal;
import eu.bausov.projects.srvpumpselection.bo.equipment.requests.PumpCreateRequest;
import eu.bausov.projects.srvpumpselection.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/DataBaseManagement")
public class DataBaseManagement {
    private final Logger LOGGER = LoggerFactory.getLogger(DataBaseManagement.class);

    private final PumpService pumpService;
    private final SealService sealService;
    private final DriveAssemblyService driveAssemblyService;
    private final FrameService frameService;
    private final ConstantService constantService;
    private final ProducerService producerService;
    private final SpeedCorrectionCoefficientService speedCorrectionCoefficientService;

    @Autowired
    public DataBaseManagement(PumpService pumpService, SealService sealService, DriveAssemblyService driveAssemblyService, FrameService frameService, ConstantService constantService, ProducerService producerService, SpeedCorrectionCoefficientService speedCorrectionCoefficientService) {
        this.pumpService = pumpService;
        this.sealService = sealService;
        this.driveAssemblyService = driveAssemblyService;
        this.frameService = frameService;
        this.constantService = constantService;
        this.producerService = producerService;
        this.speedCorrectionCoefficientService = speedCorrectionCoefficientService;
    }

    @ResponseBody
    @RequestMapping(value = "/constants", method = RequestMethod.GET)
    public List<Constant> getConstantsList() {
        LOGGER.info("Constants list requested");

        return constantService.findAllConstants();
    }

    @ResponseBody
    @RequestMapping(value = "/producers", method = RequestMethod.GET)
    public List<Producer> getProducersList() {
        LOGGER.info("Producers list requested");

        return producerService.findAllProducers();
    }

    @ResponseBody
    @RequestMapping(value = "/seals", method = RequestMethod.GET)
    public List<Seal> getSealsList() {
        LOGGER.info("Seals list requested");

        return sealService.findAllSeals();
    }

    @ResponseBody
    @RequestMapping(value = "/frames", method = RequestMethod.GET)
    public List<Frame> getFramesList() {
        LOGGER.info("Frames list requested");

        return frameService.findAllFrames();
    }

    @ResponseBody
    @RequestMapping(value = "/assemblies", method = RequestMethod.GET)
    public List<DriveAssembly> getAssembliesList() {
        LOGGER.info("Drive Assemblies list requested");

        return driveAssemblyService.findAllDriveAssemblies();
    }

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/pumps", method = RequestMethod.GET)
    public List<Pump> getList() {
        LOGGER.info("Pumps list requested");

        return pumpService.findAllPumps();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pump getPump(@PathVariable("id") Long id) {
        LOGGER.info("Pump with id:{} requested", id);

        return pumpService.findOnePump(id);
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPump(@RequestBody PumpCreateRequest request) throws IllegalAccessException {
        LOGGER.info("Create pump requested, model: {}", request.getModelName());

        Pump pump = new Pump();
        pump.setModelName(request.getModelName());
        pump.setPrice(request.getPrice());
        pump.setProducer(producerService.findOneProducer(request.getProducerId()));
        pump.setConstPumpType(constantService.findOneConstant(request.getConstPumpTypeId()));
        pump.setReliefValve(request.isReliefValve());
        pump.setHeatingJacketOnCover(request.isHeatingJacketOnCover());
        pump.setHeatingJacketOnCasing(request.isHeatingJacketOnBracket());
        pump.setHeatingJacketOnBracket(request.isHeatingJacketOnBracket());
        pump.setConstCasingMaterial(constantService.findOneConstant(request.getConstCasingMaterialId()));
        pump.setConstRotorGearMaterial(constantService.findOneConstant(request.getConstRotorGearMaterialId()));
        pump.setConstIdlerGearMaterial(constantService.findOneConstant(request.getConstIdlerGearMaterialId()));
        pump.setConstShaftSupportMaterial(constantService.findOneConstant(request.getConstShaftSupportMaterialId()));
        pump.setConstShaftMaterial(constantService.findOneConstant(request.getConstShaftMaterialId()));
        pump.setConstConnectionsType(constantService.findOneConstant(request.getConstConnectionsTypeId()));
        pump.setConstDn(constantService.findOneConstant(request.getConstDnId()));
        pump.setConstConnectionsAngle(constantService.findOneConstant(request.getConstConnectionsAngleId()));
        pump.setConstMaxPressure(constantService.findOneConstant(request.getConstMaxPressureId()));
        pump.setConstMaxTemperature(constantService.findOneConstant(request.getConstMaxTemperatureId()));
        pump.setRpmCoefficient(request.getRpmCoefficient());

        // todo look here
        request.getSpeedCorrectionCoefficients().forEach(speedCorrectionCoefficientService::saveSpeedCorrectionCoefficient);
        pump.setSpeedCorrectionCoefficients(request.getSpeedCorrectionCoefficients());

        pumpService.saveOnePump(pump);

        // update in parts lists
        sealService.addToPartLists(pump, request.getSealsIdentifires());
        frameService.addToPartLists(pump, request.getFramesIdentifires());
        driveAssemblyService.addToPartLists(pump, request.getDriveAssembliesIdentifires());

        LOGGER.info("Pump with id {} created", pump.getId());

        return "CREATED pump with id: " + pump.getId();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updatePump(@RequestBody Pump pump) {

        pumpService.saveOnePump(pump);

        return "Pump updated";
    }
}
