package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

public class PumpAggregate extends Equipment {
    Pump pump;
    Reducer reducer;
    Motor motor;
    Coupling coupling;
    Frame frame;
    Integer speedOnShaft;
    Constant totalPrice;
}
