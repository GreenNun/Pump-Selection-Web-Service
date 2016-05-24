package eu.bausov.projects.pump_selector.bo.electric_motor;

import eu.bausov.projects.pump_selector.bo.Equipment;
import eu.bausov.projects.pump_selector.bo.ExplosionProofType;

/**
 * Created by Stanislav Bausov on 25.05.2016.
 */
public class Motor extends Equipment {
    double kWt;
    int voltage;
    int phases;
    int poles;
    IP ipType;
    ExplosionProofType explosionProofType;
}
