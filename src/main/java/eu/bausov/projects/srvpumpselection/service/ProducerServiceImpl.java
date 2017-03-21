package eu.bausov.projects.srvpumpselection.service;

import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Producer> findAllProducers() {
        return producerRepository.findAll();
    }
}
