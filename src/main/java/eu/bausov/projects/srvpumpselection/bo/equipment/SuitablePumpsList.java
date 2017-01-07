package eu.bausov.projects.srvpumpselection.bo.equipment;

import java.util.Set;

public interface SuitablePumpsList {
    Set<Pump> getSuitablePumps();
    void setSuitablePumps(Set<Pump> suitablePumps);
}
