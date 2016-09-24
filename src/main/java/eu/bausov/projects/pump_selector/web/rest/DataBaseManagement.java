package eu.bausov.projects.pump_selector.web.rest;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;
import eu.bausov.projects.pump_selector.bo.equipment.Pump;
import eu.bausov.projects.pump_selector.bo.equipment.Seal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/DataBaseManagement")
public class DataBaseManagement {

    @Autowired
    private SessionFactory sessionFactory;

    @ResponseBody
    @RequestMapping(value = "/constants", method = RequestMethod.GET)
    public List<Constant> getConstantsList() {

        Session session = sessionFactory.getCurrentSession();
        return (List<Constant>) session.createCriteria(Constant.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/producers", method = RequestMethod.GET)
    public List<Producer> getProducersList() {

        Session session = sessionFactory.getCurrentSession();
        return (List<Producer>) session.createCriteria(Producer.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/seals", method = RequestMethod.GET)
    public List<Seal> getSealsList() {

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
    public Pump createPump(@RequestBody Pump pump) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(pump);

        return pump;

    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Pump updatePump(@RequestBody Pump pump) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(pump);

        return pump;

    }
}
