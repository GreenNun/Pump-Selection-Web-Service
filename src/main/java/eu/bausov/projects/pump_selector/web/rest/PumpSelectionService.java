package eu.bausov.projects.pump_selector.web.rest;

import eu.bausov.projects.pump_selector.bo.equipment.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/PumpSelectionService")
public class PumpSelectionService {

    @Autowired
    private SessionFactory sessionFactory;

    @ResponseBody
    @RequestMapping(value = "/pumps", method = RequestMethod.GET)
    public List<PumpAggregate> getSuitablePumps(
            @RequestParam(required = false, value = "queryParam1") Integer p1,
            @RequestParam(required = true, value = "queryParam2") String p2,
            HttpSession httpSession
    ) {

        Session currentSession = sessionFactory.getCurrentSession();

        //Get all pumps from DB
        //List<Pump> list = currentSession.createCriteria(Pump.class).list();


        List<PumpAggregate> pumpAggregates = new ArrayList<>();

        Pump pump = new Pump();
        pump.setModelName("Model name");

        PumpAggregate tmp = new PumpAggregate();
        tmp.setPump(pump);

        pumpAggregates.add(tmp);


        return pumpAggregates;

    }


   /* private Parameters parameters;
    private List<Pump> pumps;
    private List<Reducer> reducers;
    private List<Motor> motors;
    private List<Seal> seals;
    private List<ReliefValve> reliefValves;
    private List<HeatingJacket> heatingJackets;
    private List<Coupling> couplings;
    private List<Frame> frames;

    public PumpSelectionService(Parameters parameters,
                                List<Pump> pumps,
                                List<Reducer> reducers,
                                List<Motor> motors,
                                List<Seal> seals,
                                List<ReliefValve> reliefValves,
                                List<HeatingJacket> heatingJackets,
                                List<Coupling> couplings,
                                List<Frame> frames) {
        this.parameters = parameters;
        this.pumps = pumps;
        this.reducers = reducers;
        this.motors = motors;
        this.seals = seals;
        this.reliefValves = reliefValves;
        this.heatingJackets = heatingJackets;
        this.couplings = couplings;
        this.frames = frames;
    }*/




    /**
     * private Pump pump; +
     * private Seal seal; +
     * private ReliefValve reliefValve;+
     * private HeatingJacket heatingJacket; +
     * private Reducer reducer; +
     * private Motor motor; +
     * private Coupling coupling;
     * private Frame frame;
     */
   /* public List<PumpAggregate> getSuitableInternalGearPumps() {
        List<PumpAggregate> list = new ArrayList<>();

        PumpAggregate aggregate = null;

        for (Pump pump : pumps) {
            if (pump.isPressureValid(parameters) && pump.isTemperatureValid(parameters)) {
                for (Reducer reducer : reducers) {
                    if (pump.isReducerValid(reducer, parameters)) {
                        for (Motor motor : motors) {
                            if (motor.isMotorValid(reducer) &&
                                    parameters.isExplosionProofed() == motor.isExplosionProofAvailable()) {
                                for (Seal seal : seals) {
                                    if (pump.isValidTo(seal.getSuitablePumps())) {
                                        for (ReliefValve reliefValve : reliefValves) {
                                            if (pump.isValidTo(reliefValve.getSuitablePumps())){
                                                for (HeatingJacket heatingJacket : heatingJackets){
                                                    if (pump.isValidTo(heatingJacket.getSuitablePumps())){
                                                        for (Coupling coupling : couplings){
                                                            if (pump.isValidTo(coupling.getSuitablePumps())){
                                                                for (Frame frame : frames){
                                                                    if (pump.isValidTo(frame.getSuitablePumps())){
                                                                        aggregate = new PumpAggregate();
                                                                        aggregate.setPump(pump);
                                                                        aggregate.setReducer(reducer);
                                                                        aggregate.setMotor(motor);
                                                                        aggregate.setSeal(seal);
                                                                        aggregate.setReliefValve(reliefValve);
                                                                        aggregate.setHeatingJacket(heatingJacket);
                                                                        aggregate.setCoupling(coupling);
                                                                        aggregate.setFrame(frame);

                                                                        list.add(aggregate);
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
                    }
                }
            }
        }


        return list;
    }
    */


}