package eu.bausov.projects.pump_selector.bo.electric_motor;

import eu.bausov.projects.pump_selector.bo.Equipment;
import eu.bausov.projects.pump_selector.bo.Pump;
import eu.bausov.projects.pump_selector.bo.Reductor;

/**
 * Created by Stanislav Bausov on 25.05.2016.
 */
public class PumpAggregate extends Equipment {
    Pump pump;
    Reductor reductor;
    Motor motor;
    int speedOnShaft;
}
