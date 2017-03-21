package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.equipment.Frame;
import eu.bausov.projects.srvpumpselection.repository.FrameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class FrameServiceImpl implements FrameService {
    private final FrameRepository frameRepository;

    @Autowired
    public FrameServiceImpl(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    @Override
    public List<Frame> findAllFrames() {
        return frameRepository.findAll();
    }
}
