package eu.bausov.projects.pump_selector.service;

import eu.bausov.projects.pump_selector.bo.Parameters;
import eu.bausov.projects.pump_selector.bo.equipment.*;

import java.util.ArrayList;
import java.util.List;

public class PumpSelectionService {
    private Parameters parameters;
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
    }

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
    public List<PumpAggregate> getSuitableInternalGearPumps() {
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


}
