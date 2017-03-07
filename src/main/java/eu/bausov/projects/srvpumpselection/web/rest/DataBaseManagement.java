package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.JPA;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.bo.equipment.*;
import eu.bausov.projects.srvpumpselection.bo.equipment.requests.PumpCreateRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/DataBaseManagement")
public class DataBaseManagement {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @ResponseBody
    @RequestMapping(value = "/constants", method = RequestMethod.GET)
    public List<Constant> getConstantsList() {
        LOGGER.info("Constants list requested");

        Session session = sessionFactory.getCurrentSession();
        return (List<Constant>) session.createCriteria(Constant.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/producers", method = RequestMethod.GET)
    public List<Producer> getProducersList() {
        LOGGER.info("Producers list requested");

        Session session = sessionFactory.getCurrentSession();
        return (List<Producer>) session.createCriteria(Producer.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/seals", method = RequestMethod.GET)
    public List<Seal> getSealsList() {
        LOGGER.info("Seals list requested");

        Session session = sessionFactory.getCurrentSession();
        return (List<Seal>) session.createCriteria(Seal.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/frames", method = RequestMethod.GET)
    public List<Frame> getFramesList() {
        LOGGER.info("Frames list requested");

        Session session = sessionFactory.getCurrentSession();
        return (List<Frame>) session.createCriteria(Frame.class).list();
    }

    @ResponseBody
    @RequestMapping(value = "/assemblies", method = RequestMethod.GET)
    public List<DriverAssembly> getAssembliesList() {
        LOGGER.info("Driver Assemblies list requested");

        Session session = sessionFactory.getCurrentSession();
        return (List<DriverAssembly>) session.createCriteria(DriverAssembly.class).list();
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
    public String createPump(@RequestBody PumpCreateRequest request) throws IllegalAccessException {
        LOGGER.info("createPump() invoked, model: {}", request.getModelName());

        Session session = sessionFactory.getCurrentSession();

        Pump pump = new Pump();
        pump.setModelName(request.getModelName());
        pump.setPrice(request.getPrice());
        pump.setProducer((Producer) session.load(Producer.class, request.getProducer()));
        pump.setConstPumpType((Constant) session.load(Constant.class, request.getConstPumpType()));
        pump.setReliefValve(request.isReliefValve());
        pump.setHeatingJacketOnCover(request.isHeatingJacketOnCover());
        pump.setHeatingJacketOnCasing(request.isHeatingJacketOnBracket());
        pump.setHeatingJacketOnBracket(request.isHeatingJacketOnBracket());
        pump.setConstCasingMaterial((Constant) session.load(Constant.class, request.getConstCasingMaterial()));
        pump.setConstRotorGearMaterial((Constant) session.load(Constant.class, request.getConstRotorGearMaterial()));
        pump.setConstIdlerGearMaterial((Constant) session.load(Constant.class, request.getConstIdlerGearMaterial()));
        pump.setConstShaftSupportMaterial((Constant) session.load(Constant.class, request.getConstShaftSupportMaterial()));
        pump.setConstShaftMaterial((Constant) session.load(Constant.class, request.getConstShaftMaterial()));
        pump.setConstConnectionsType((Constant) session.load(Constant.class, request.getConstConnectionsType()));
        pump.setConstDn((Constant) session.load(Constant.class, request.getConstDn()));
        pump.setConstConnectionsAngle((Constant) session.load(Constant.class, request.getConstConnectionsAngle()));
        pump.setConstMaxPressure((Constant) session.load(Constant.class, request.getConstMaxPressure()));
        pump.setConstMaxTemperature((Constant) session.load(Constant.class, request.getConstMaxTemperature()));
        pump.setRpmCoefficient(request.getRpmCoefficient());

        // transaction starts here
        try {
            Transaction transaction = session.beginTransaction();

            pump.setSpeedCorrectionCoefficients(persistOrCreate(session, request.getSpeedCorrectionCoefficients()));
            session.persist(pump);

            // update in parts lists
            partsListUpdate(session, pump, Seal.class, request.getSeals());
            partsListUpdate(session, pump, Frame.class, request.getFrames());
            partsListUpdate(session, pump, DriverAssembly.class, request.getDriverAssemblies());

            session.flush();
            session.clear();
            transaction.commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();

            LOGGER.warn("Transaction ROLLBACK");
            return e.getMessage() + "\n" + e.toString();
        }

        LOGGER.info("Pump with id {} has been created", pump.getId());

//        session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.flush();
        session.clear();
        transaction.commit();

        return "CREATED pump with id: " + pump.getId();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Pump updatePump(@RequestBody Pump pump) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(pump);

        return pump;

    }

    /**
     * Takes objects from set and add to result set persisted (if exist in db) ro creates new in db and add.
     * Method resolves problem when hibernate cannot persist object because of database unique keys restriction.
     *
     * @param session
     * @param set
     * @param <T>
     * @throws IllegalAccessException
     */
    private <T extends JPA> Set<T> persistOrCreate(Session session, Set<T> set) throws IllegalAccessException {
        Set<T> result = new HashSet<T>();

        for (T object : set) {
            Criteria criteria = session.createCriteria(object.getClass());
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                criteria.add(Restrictions.eq(f.getName(), f.get(object)));
            }
            T object1 = (T) criteria.uniqueResult();
            if (object1 == null) {
                session.persist(object);
                result.add(object);
                LOGGER.info("JPA object persisted and added to Set");
            } else {
                result.add(object1);
                LOGGER.info("JPA object loaded from database and added to Set");
            }
        }
        return result;
    }

    private <T extends Equipment> void partsListUpdate(Session session, Pump pump, Class<T> clazz, long[] identifiers) {
        for (long identifier : identifiers) {
            PumpPart equipment = (PumpPart) session.load(clazz, identifier);
            equipment.getSuitablePumps().add(pump);

            LOGGER.info("{}.class parts list UPDATED with pump id: {}", clazz.getSimpleName(), pump.getId());
        }
    }
}
