package eu.bausov.projects.pump_selector.bo;

/**
 * Created by Stanislav Bausov on 21.05.2016.
 */
public abstract class Pump extends Equipment {
    Material castingMaterial;
    Material shaftMaterial;
    Seal seal;
    int maxTemperature;
}
