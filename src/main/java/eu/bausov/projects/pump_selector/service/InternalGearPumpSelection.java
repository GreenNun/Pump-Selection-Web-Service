package eu.bausov.projects.pump_selector.service;

import eu.bausov.projects.pump_selector.bo.Parameters;
import eu.bausov.projects.pump_selector.bo.SpeedCorrectionCoefficient;
import eu.bausov.projects.pump_selector.bo.equipment.*;

import java.util.List;
import java.util.TreeSet;

public class InternalGearPumpSelection {
    private Parameters parameters;
    private List<InternalGearPump> internalGearPumps;
    private List<Reducer> reducer;
    private List<Motor> motor;
    private List<Coupling> coupling;
    private List<Frame> frame;

    // static?
    public List<InternalGearPump> getInternalGearPumps(){


        return null;
    }

    public static void main(String[] args) {
        Parameters p = new Parameters();
        p.setViscosity(12);

        TreeSet<SpeedCorrectionCoefficient> set = new TreeSet<>();
        SpeedCorrectionCoefficient coef0 = new SpeedCorrectionCoefficient();
        coef0.setViscosity(20);
        coef0.setCoefficient(80);
        set.add(coef0);
        SpeedCorrectionCoefficient coef1 = new SpeedCorrectionCoefficient();
        coef1.setViscosity(10);
        coef1.setCoefficient(40);
        set.add(coef1);
        SpeedCorrectionCoefficient coef2 = new SpeedCorrectionCoefficient();
        coef2.setViscosity(30);
        coef2.setCoefficient(120);
        set.add(coef2);

        InternalGearPump pump = new InternalGearPump();
        pump.setSpeedCorrectionCoefficients(set);

        System.out.println(new InternalGearPumpSelection().getSpeedCorrectionCoefficient(pump, p));
    }

    /**
     * Calculates pump shaft speed for required parameters.
     *
     * @param internalGearPump InternalGearPump instance to take rpm coefficient
     * @param parameters Parameters instance to take capacity
     * @return shaft speed
     */
    private int getShaftSpeed(InternalGearPump internalGearPump, Parameters parameters){
        double c1 = internalGearPump.getRpmCoefficient();
        double c2 = parameters.getCapacity();
        int c3 = getSpeedCorrectionCoefficient(internalGearPump, parameters);
        return (int)(c1 * c2) + c3;
    }

    // TODO: 21.06.2016 finish method
    private int getSpeedCorrectionCoefficient(InternalGearPump internalGearPump, Parameters parameters){
        int v = 0;
        int c = 0;
        int count = 0;
        TreeSet<SpeedCorrectionCoefficient> set = internalGearPump.getSpeedCorrectionCoefficients();

        // Find coincident viscosity value in the set
        for (SpeedCorrectionCoefficient coefficient: set) {
            if (count == 2){
                break;
            } else {
                if (coefficient.getViscosity() > parameters.getViscosity()){
                    v = coefficient.getViscosity();
                    count++;
                } else {
                    break;
                }
            }
        }
        System.out.println("v = " + v);

        // Find coincident coefficient value to determinated viscosity
        for (SpeedCorrectionCoefficient coefficient: set) {
            if (coefficient.getViscosity().equals(v)){
                c = coefficient.getCoefficient();
            }
        }
        System.out.println("c = " + c);

        return c;
    }
}
