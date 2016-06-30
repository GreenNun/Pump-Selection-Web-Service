package eu.bausov.projects.pump_selector.web.rest;

import eu.bausov.projects.pump_selector.bo.equipment.Pump;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/PumpService")
public class PumpService {

    @Autowired
    private SessionFactory sessionFactory;

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
    public Pump createPump(@RequestBody Pump pupm) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(pupm);

        return pupm;

    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Pump updatePump(@RequestBody Pump pupm) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(pupm);

        return pupm;

    }
}
