package eu.bausov.projects.pump_selector.service;

import eu.bausov.projects.pump_selector.bo.Parameters;
import eu.bausov.projects.pump_selector.bo.equipment.*;

import java.util.*;

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
     private Pump pump; +
     private Seal seal; +
     private ReliefValve reliefValve;
     private HeatingJacket heatingJacket;
     private Reducer reducer; +
     private Motor motor; +
     private Coupling coupling;
     private Frame frame;
     */
    public List<PumpAggregate> getSuitableInternalGearPumps() {
        List<PumpAggregate> list = new ArrayList<>();

        PumpAggregate aggregate = null;

        for (Pump pump : pumps) {
            if (isPressureValid(pump) && isTemperatureValid(pump)) {
                for (Reducer reducer : reducers) {
                    if (pump.isSuitableReducer(reducer, parameters)) {
                        for (Motor motor : motors) {
                            if (motor.isMotorValid(reducer) &&
                                    parameters.isExplosionProofed() == motor.isExplosionProofAvailable()) {
                                for (Seal seal : seals){
                                    if (seal.isSealValid(pump)){

                                        //

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

    private boolean isPressureValid(Pump pump) {
        return pump.getConstMaxPressure().getIntegerValue() <= parameters.getPressure();
    }

    private boolean isTemperatureValid(Pump pump) {
        return pump.getConstMaxTemperature().getIntegerValue() <= parameters.getTemperature();
    }

    private boolean isSealTypeValid(Seal seal){
        return seal.getSealType().getValue().equals(parameters.getConstSealType().getValue());
    }
}
