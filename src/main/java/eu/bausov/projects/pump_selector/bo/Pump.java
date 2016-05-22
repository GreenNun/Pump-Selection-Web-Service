package eu.bausov.projects.pump_selector.bo;

/**
 * Created by Stanislav Bausov on 21.05.2016.
 */
abstract class Pump extends Equipment {
    String modelName;
    Material castingMaterial;
    Material shaftMaterial;
    Seal seal;
}
