package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Parameters;
import eu.bausov.projects.srvpumpselection.bo.equipment.*;
import eu.bausov.projects.srvpumpselection.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/PumpSelectionService")
//@PreAuthorize("hasRole('ADMIN')")
public class PumpSelectionService {
    private final Logger LOGGER = LoggerFactory.getLogger(PumpSelectionService.class);

    private final PumpDAO pumpDAO;
    private final ReducerDAO reducerDAO;
    private final MotorDAO motorDAO;
    private final SealDAO sealDAO;
    private final DriverAssemblyDAO driverAssemblyDAO;
    private final FrameDAO frameDAO;

    @Autowired
    public PumpSelectionService(PumpDAO pumpDAO, ReducerDAO reducerDAO, MotorDAO motorDAO, SealDAO sealDAO, DriverAssemblyDAO driverAssemblyDAO, FrameDAO frameDAO) {
        this.pumpDAO = pumpDAO;
        this.reducerDAO = reducerDAO;
        this.motorDAO = motorDAO;
        this.sealDAO = sealDAO;
        this.driverAssemblyDAO = driverAssemblyDAO;
        this.frameDAO = frameDAO;
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<PumpAggregate> getSuitablePumps(@RequestBody Parameters parameters) {
        LOGGER.info("Current session received '{}'", this.getClass());

        // Get all equipment lists from DB
        List<Pump> pumps = pumpDAO.findAll();
        List<Reducer> reducers = reducerDAO.findAll();
        List<Motor> motors = motorDAO.findAll();
        List<Seal> seals = sealDAO.findAll();
        List<DriverAssembly> driverAssemblies = driverAssemblyDAO.findAll();
        List<Frame> frames = frameDAO.findAll();

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
                                        // DriverAssembly
                                        for (DriverAssembly driverAssembly : driverAssemblies) {            // driver assembly
                                            if (driverAssembly.getDriverAssemblyType().getValue().equals    // driver assembly type
                                                    (parameters.getDriverAssemblyType()) &&
                                                    pump.isValidTo(driverAssembly.getSuitablePumps())) {
                                                // Frame
                                                for (Frame frame : frames) {                                // frame
                                                    if (pump.isValidTo(frame.getSuitablePumps())) {
                                                        PumpAggregate aggregate = new PumpAggregate();
                                                        aggregate.setPump(pump);
                                                        aggregate.setReducer(reducer);
                                                        aggregate.setMotor(motor);
                                                        aggregate.setSeal(seal);
                                                        aggregate.setDriverAssembly(driverAssembly);
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
}

//@ResponseBody
    /*@RequestMapping(value = "/pumps", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public void getSuitablePumps(@RequestBody PumpAggregate aggregate) {
    }*/

//    @ResponseBody
//    @RequestMapping(value = "/pumps", method = RequestMethod.POST)
//    public String getSuitablePumps(@RequestBody Parameters params
//    ) {
//
//
//        return params.toString();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/pumps", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ADMIN')")
//    //public List<String> getSuitablePumps(
//    public List<PumpAggregate> getSuitablePumps(
//            @RequestParam(required = false, value = "queryParam1") Integer p1,
//            @RequestParam(required = true, value = "queryParam2") String p2,
//            HttpSession httpSession
//    )

//    Constant res = (Constant) session.createCriteria(Constant.class)
//            .add(Restrictions.eq("name", "country"))
//            .add(Restrictions.eq("value", "Germany")).uniqueResult();