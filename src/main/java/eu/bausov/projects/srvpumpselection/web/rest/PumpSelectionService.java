package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Parameters;
import eu.bausov.projects.srvpumpselection.bo.equipment.*;
import eu.bausov.projects.srvpumpselection.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/select")
//@PreAuthorize("hasRole('ADMIN')")
public class PumpSelectionService {
    private final Logger LOGGER = LoggerFactory.getLogger(PumpSelectionService.class);

    private final PumpService pumpService;
    private final ReducerService reducerService;
    private final MotorService motorService;
    private final SealService sealService;
    private final DriveAssemblyService driveAssemblyService;
    private final FrameService frameService;
    private final ConstantService constantService;

    @Autowired
    public PumpSelectionService(PumpService pumpService, ReducerService reducerService, MotorService motorService, SealService sealService, DriveAssemblyService driveAssemblyService, FrameService frameService, ConstantService constantService) {
        this.pumpService = pumpService;
        this.reducerService = reducerService;
        this.motorService = motorService;
        this.sealService = sealService;
        this.driveAssemblyService = driveAssemblyService;
        this.frameService = frameService;
        this.constantService = constantService;
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Transactional
    public List<PumpAggregate> getSuitablePumps(@RequestBody Parameters parameters) {
        LOGGER.info("Current session received '{}'", this.getClass());

        // Get all equipment lists from DB
        List<Pump> pumps = pumpService.findAllPumps();
        List<Reducer> reducers = reducerService.findAllReducers();
        List<Motor> motors = motorService.findAllMotors();
        List<Seal> seals = sealService.findAllSeals();
        List<DriveAssembly> driveAssemblies = driveAssemblyService.findAllDriveAssemblies();
        List<Frame> frames = frameService.findAllFrames();

        List<PumpAggregate> pumpAggregates = new ArrayList<>();
        // Pump
        for (Pump pump : pumps) {
            if (pump.isViscosityValid(parameters) &&                                                        // viscosity
                    pump.getConstPumpType().getValue().equals(parameters.getPumpType()) &&                  // pumpType
                    pump.getReliefValve() == parameters.isReliefValve() &&                                  // reliefValve
                    (pump.getHeatingJacketOnCover() || pump.getHeatingJacketOnCasing() ||
                            pump.getHeatingJacketOnBracket()) == parameters.isHeatingJacket() &&            // heatingJacket
                    pump.getConstCasingMaterial().getValue().contains(parameters.getCasingMaterial()) &&    // casingMaterial
                    pump.isPressureValid(parameters) &&                                                     // pressure
                    pump.isTemperatureValid(parameters)) {                                                  // temperature
                // Reducer
                for (Reducer reducer : reducers) {
                    if (pump.getProducer().equals(reducer.getVendor()) &&                                   // vendor check
                            pump.isReducerValid(reducer, parameters)) {
                        // Motor
                        for (Motor motor : motors) {
                            if (pump.getProducer().equals(motor.getVendor()) &&                             // vendor check
                                    motor.isMotorValid(reducer) &&
                                    motor.isExplosionProofAvailable() == parameters.isExplosionProof()) {
                                // Seal
                                for (Seal seal : seals) {                                                   // seal
                                    // TODO: 11.07.2016 oRing check
                                    // TODO: 07.08.2016 Connections placement angle check
                                    if (seal.getSealType().getValue().equals(parameters.getSealType()) &&   // seal type
                                            pump.isValidTo(seal.getSuitablePumps())) {
                                        // DriveAssembly
                                        for (DriveAssembly driveAssembly : driveAssemblies) {            // drive assembly
                                            if (driveAssembly.getConstDriveAssemblyType().getValue().equals    // drive assembly type
                                                    (parameters.getDriveAssemblyType()) &&
                                                    pump.isValidTo(driveAssembly.getSuitablePumps())) {
                                                // Frame
                                                for (Frame frame : frames) {                                // frame
                                                    if (pump.isValidTo(frame.getSuitablePumps())) {
                                                        PumpAggregate aggregate = new PumpAggregate();
                                                        aggregate.setPump(pump);
                                                        aggregate.setReducer(reducer);
                                                        aggregate.setMotor(motor);
                                                        aggregate.setSeal(seal);
                                                        aggregate.setDriveAssembly(driveAssembly);
                                                        aggregate.setFrame(frame);

                                                        // Write shaft speed to PumpAggregate field.
                                                        aggregate.setShaftSpeed(pump.getShaftSpeed(parameters));
                                                        // Write parameters to PumpAggregate field.
                                                        aggregate.setParameters(parameters.toString());
                                                        // Calculate and write Total Price.
                                                        aggregate.setTotalPrice(2);

                                                        pumpAggregates.add(aggregate);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return pumpAggregates;
    }

    @ResponseBody
    @RequestMapping(value = "/constants", method = RequestMethod.GET)
    public List<Constant> getConstantsList() {
        LOGGER.info("Constants list requested");

        return constantService.findAllConstants();
    }
}