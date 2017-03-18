package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.bo.SpeedCorrectionCoefficient;
import eu.bausov.projects.srvpumpselection.bo.equipment.*;
import eu.bausov.projects.srvpumpselection.bo.equipment.requests.PumpCreateRequest;
import eu.bausov.projects.srvpumpselection.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/DataBaseManagement")
public class DataBaseManagement {
    private final Logger LOGGER = LoggerFactory.getLogger(DataBaseManagement.class);

    private final PumpRepository pumpRepository;
    private final SealRepository sealRepository;
    private final DriverAssemblyRepository driverAssemblyRepository;
    private final FrameRepository frameRepository;
    private final ConstantRepository constantRepository;
    private final ProducerRepository producerRepository;
    private final SpeedCorrectionCoefficientRepository speedCorrectionCoefficientRepository;

    @Autowired
    public DataBaseManagement(PumpRepository pumpRepository, SealRepository sealRepository, DriverAssemblyRepository driverAssemblyRepository, FrameRepository frameRepository, ConstantRepository constantRepository, ProducerRepository producerRepository, SpeedCorrectionCoefficientRepository speedCorrectionCoefficientRepository) {
        this.pumpRepository = pumpRepository;
        this.sealRepository = sealRepository;
        this.driverAssemblyRepository = driverAssemblyRepository;
        this.frameRepository = frameRepository;
        this.constantRepository = constantRepository;
        this.producerRepository = producerRepository;
        this.speedCorrectionCoefficientRepository = speedCorrectionCoefficientRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/constants", method = RequestMethod.GET)
    public List<Constant> getConstantsList() {
        LOGGER.info("Constants list requested");

        return constantRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/producers", method = RequestMethod.GET)
    public List<Producer> getProducersList() {
        LOGGER.info("Producers list requested");

        return producerRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/seals", method = RequestMethod.GET)
    public List<Seal> getSealsList() {
        LOGGER.info("Seals list requested");

        return sealRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/frames", method = RequestMethod.GET)
    public List<Frame> getFramesList() {
        LOGGER.info("Frames list requested");

        return frameRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/assemblies", method = RequestMethod.GET)
    public List<DriverAssembly> getAssembliesList() {
        LOGGER.info("Driver Assemblies list requested");

        return driverAssemblyRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Pump> getList() {
        LOGGER.info("Pumps list requested");

        return pumpRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pump getPump(@PathVariable("id") Long id) {
        LOGGER.info("Pump with id:{} requested", id);

        return pumpRepository.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPump(@RequestBody PumpCreateRequest request) throws IllegalAccessException {
        LOGGER.info("createPump() invoked, model: {}", request.getModelName());

        Pump pump = new Pump();
        pump.setModelName(request.getModelName());
        pump.setPrice(request.getPrice());
        pump.setProducer(producerRepository.findOne(request.getProducer()));
        pump.setConstPumpType(constantRepository.findOne(request.getConstPumpType()));
        pump.setReliefValve(request.isReliefValve());
        pump.setHeatingJacketOnCover(request.isHeatingJacketOnCover());
        pump.setHeatingJacketOnCasing(request.isHeatingJacketOnBracket());
        pump.setHeatingJacketOnBracket(request.isHeatingJacketOnBracket());
        pump.setConstCasingMaterial(constantRepository.findOne(request.getConstCasingMaterial()));
        pump.setConstRotorGearMaterial(constantRepository.findOne(request.getConstRotorGearMaterial()));
        pump.setConstIdlerGearMaterial(constantRepository.findOne(request.getConstIdlerGearMaterial()));
        pump.setConstShaftSupportMaterial(constantRepository.findOne(request.getConstShaftSupportMaterial()));
        pump.setConstShaftMaterial(constantRepository.findOne(request.getConstShaftMaterial()));
        pump.setConstConnectionsType(constantRepository.findOne(request.getConstConnectionsType()));
        pump.setConstDn(constantRepository.findOne(request.getConstDn()));
        pump.setConstConnectionsAngle(constantRepository.findOne(request.getConstConnectionsAngle()));
        pump.setConstMaxPressure(constantRepository.findOne(request.getConstMaxPressure()));
        pump.setConstMaxTemperature(constantRepository.findOne(request.getConstMaxTemperature()));
        pump.setRpmCoefficient(request.getRpmCoefficient());

        for (SpeedCorrectionCoefficient speedCorrectionCoefficient : request.getSpeedCorrectionCoefficients()) {
            speedCorrectionCoefficientRepository.save(speedCorrectionCoefficient);
        }

        pump.setSpeedCorrectionCoefficients(request.getSpeedCorrectionCoefficients());
        pumpRepository.save(pump);

        // update in parts lists
        partsListUpdate(pump, sealRepository, request.getSeals());
        partsListUpdate(pump, frameRepository, request.getFrames());
        partsListUpdate(pump, driverAssemblyRepository, request.getDriverAssemblies());

        LOGGER.info("Pump with id {} created", pump.getId());

        return "CREATED pump with id: " + pump.getId();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Pump updatePump(@RequestBody Pump pump) {

        return pumpRepository.save(pump);
    }

    private <T extends PumpPart> void partsListUpdate(Pump pump, CrudRepository<T, Long> dao, long[] identifiers) {
        for (long identifier : identifiers) {
            T pumpPart = dao.findOne(identifier);
            pumpPart.getSuitablePumps().add(pump);
            dao.save(pumpPart);

            LOGGER.info("{}.class parts list UPDATED with pump id: {}");
        }
    }
}
