package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.equipment.Frame;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.repository.FrameRepository;
import eu.bausov.projects.srvpumpselection.service.FrameService;
import eu.bausov.projects.srvpumpselection.service.PartsUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class FrameServiceImpl implements FrameService, PartsUpdater {
    private final FrameRepository frameRepository;

    @Autowired
    public FrameServiceImpl(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    @Override
    public List<Frame> findAllFrames() {
        return frameRepository.findAll();
    }

    @Override
    public Frame findOneFrame(Long id) {
        return frameRepository.findOne(id);
    }

    @Override
    public void addToPartLists(Pump pump, long[] framesIdentifiers) {
        add(pump, frameRepository, framesIdentifiers);
    }
}
