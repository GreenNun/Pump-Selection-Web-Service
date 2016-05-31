package eu.bausov.projects.pump_selector.bo;

import eu.bausov.projects.pump_selector.bo.Equipment;
import eu.bausov.projects.pump_selector.bo.Pump;
import eu.bausov.projects.pump_selector.bo.Reductor;
import eu.bausov.projects.pump_selector.bo.electric_motor.Motor;

public class PumpAggregate extends Equipment {
    Pump pump;
    Reductor reductor;
    Motor motor;
    Coupling coupling;
    Frame frame;
    int speedOnShaft;
}
