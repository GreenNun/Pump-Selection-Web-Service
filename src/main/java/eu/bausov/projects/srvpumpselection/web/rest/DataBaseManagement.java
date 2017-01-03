package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.bo.equipment.Pump;
import eu.bausov.projects.srvpumpselection.bo.equipment.requests.PumpCreateRequest;
import eu.bausov.projects.srvpumpselection.bo.equipment.Seal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/DataBaseManagement")
public class DataBaseManagement {

    private Logger LOGGER = LoggerFactory.getLogger(DataBaseManagement.class);

    @Autowired
    private SessionFactory sessionFactory;

    @ResponseBody
    @RequestMapping(value = "/constants", method = RequestMethod.GET)
    public List<Constant> getConstantsList() {
        LOGGER.info("Constants list request");

        Session session = sessionFactory.getCurrentSession();
        return (List<Constant>) session.createCriteria(Constant.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/producers", method = RequestMethod.GET)
    public List<Producer> getProducersList() {
        LOGGER.info("Producers list request");

        Session session = sessionFactory.getCurrentSession();
        return (List<Producer>) session.createCriteria(Producer.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/seals", method = RequestMethod.GET)
    public List<Seal> getSealsList() {
        LOGGER.info("Seals list request");

        Session session = sessionFactory.getCurrentSession();
        return (List<Seal>) session.createCriteria(Seal.class).list();
    }

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Pump> getList() {

        Session session = sessionFactory.getCurrentSession();
        return (List<Pump>) session.createCriteria(Pump.class).list();

    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pump getPump(@PathVariable("id") Long id) {

        Session session = sessionFactory.getCurrentSession();
        return (Pump) session.load(Pump.class, id);

    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PumpCreateRequest createPump(@RequestBody PumpCreateRequest pumpCreateRequest) {
        LOGGER.info("New pump creation request, model: {}", pumpCreateRequest.getModelName());

        // TODO: 04.01.2017 transaction and request logic

        LOGGER.info("New pump created with id {}", 10L);

        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Pump updatePump(@RequestBody Pump pump) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(pump);

        return pump;

    }
}
