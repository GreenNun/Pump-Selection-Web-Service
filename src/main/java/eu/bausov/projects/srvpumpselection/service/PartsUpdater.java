package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.bo.equipment.PumpPart;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GreenNun on 22.03.17.
 */
public interface PartsUpdater {
    default <T extends PumpPart> void add(Pump pump, CrudRepository<T, Long> repository, long[] identifiers) {
        if (identifiers != null && identifiers.length > 0) {
            for (long identifier : identifiers) {
                T pumpPart = repository.findOne(identifier);
                pumpPart.getSuitablePumps().add(pump);
                repository.save(pumpPart);
            }
        }
    }
}
