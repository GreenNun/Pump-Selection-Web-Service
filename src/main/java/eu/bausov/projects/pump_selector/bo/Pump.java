package eu.bausov.projects.pump_selector.bo;

import eu.bausov.projects.pump_selector.bo.parameters.Capacity;
import eu.bausov.projects.pump_selector.bo.parameters.Pressure;
import eu.bausov.projects.pump_selector.bo.parameters.Temperature;

public abstract class Pump extends Equipment {
    Type castingMaterial;
    Type shaftMaterial;
    Seal seal;
    Capacity capacity;
    Pressure pressure;
    Temperature maxTemperature;
}
