package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.repository.ProducerRepository;
import eu.bausov.projects.srvpumpselection.service.ProducerService;
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

    @Override
    public Producer findOneProducer(Long id) {
        return producerRepository.findOne(id);
    }

    @Override
    public Producer saveOneProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public void deleteOneProducer(Producer producer) {
        producerRepository.delete(producer);
    }
}
