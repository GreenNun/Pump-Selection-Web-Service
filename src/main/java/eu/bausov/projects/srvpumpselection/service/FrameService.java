package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Frame;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
public interface FrameService {
    List<Frame> findAllFrames();
    Frame findOneFrame(Long id);
    Frame saveOneFrame(Frame frame);
    void deleteOneFrame(Frame frame);
    void addToPartLists(Pump pump, long[] framesIdentifiers);
}
