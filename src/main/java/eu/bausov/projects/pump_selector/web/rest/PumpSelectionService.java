package eu.bausov.projects.pump_selector.web.rest;

import eu.bausov.projects.pump_selector.bo.*;
import eu.bausov.projects.pump_selector.bo.equipment.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping(value = "/PumpSelectionService")
@PreAuthorize("hasRole('ADMIN')")
public class PumpSelectionService {

    Logger logger = LoggerFactory.getLogger(PumpSelectionService.class);

    @Autowired
    private SessionFactory sessionFactory;

//    @ResponseBody
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public List<PumpAggregate> searchPumps(@RequestBody Parameters parameters) {
//        List<PumpAggregate> pumpAggregates = new ArrayList<>();
//
//        PumpAggregate e = new PumpAggregate();
//        e.setId(100L);
//        e.setVersion(new Date());
//
//        Seal seal = new Seal();
//        seal.setModelName("Model");
//        e.setSeal(seal);
//
//        pumpAggregates.add(e);
//
//        return pumpAggregates;
//    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<PumpAggregate> getSuitablePumps(@RequestBody Parameters parameters) {

        Session currentSession = sessionFactory.getCurrentSession();

        logger.info("Current session received '{}'", currentSession.getClass());

        // Get all equipment lists from DB
        List<Pump> pumps = currentSession.createCriteria(Pump.class).list();
        List<Reducer> reducers = currentSession.createCriteria(Reducer.class).list();
        List<Motor> motors = currentSession.createCriteria(Motor.class).list();
        List<Seal> seals = currentSession.createCriteria(Seal.class).list();
        List<DriverAssembly> driverAssemblies = currentSession.createCriteria(DriverAssembly.class).list();
        List<Frame> frames = currentSession.createCriteria(Frame.class).list();

        /**
         * JSON Example
         */
//        {
//            "medium": "liquid",
//                "constPumpType": {
//            "name": "pump type",
//                    "value": "Internal Eccentric Gear Pump"
//        },
//            "capacity": 25,
//                "pressure": 4,
//                "viscosity": 250000,
//                "sg": 50,
//                "temperature": 200,
//                "constCastingMaterial": {
//            "name": "material",
//                    "value": "GG 25 Cast Iron"
//        },
//            "seal": {
//            "sealType": {
//                "name": "seal type",
//                        "value": "Packing"
//            },
//            "oringMaterial": {
//                "name": "material",
//                        "value": "none"
//            }
//        },
//            "driverAssembly": {
//            "driverAssemblyType": {
//                "name": "driver assembly type",
//                        "value": "Flexible Coupling"
//            },
//            "constExplosionProof": {
//                "name": "explosion proof",
//                        "value": "none"
//            }
//        },
//            "reliefValve": true,
//                "heatingJacketed": true,
//                "explosionProof": false
//        }

        List<PumpAggregate> pumpAggregates = new ArrayList<>();
        // Pump
        for (Pump pump : pumps) {
            if (pump.isViscosityValid(parameters) &&                                                        // viscosity
                    pump.getConstPumpType().getValue().equals(parameters.getPumpType()) &&                  // pumpType
                    pump.getReliefValve() == parameters.isReliefValve() &&                                  // reliefValve
                    (pump.getHeatingJacketOnCover() || pump.getHeatingJacketOnCasting() ||
                            pump.getHeatingJacketOnBracket()) == parameters.isHeatingJacket() &&            // heatingJacket
                    pump.getConstCastingMaterial().getValue().contains(parameters.getCastingMaterial()) &&    // castingMaterial
                    pump.isPressureValid(parameters) &&                                                     // pressure
                    pump.isTemperatureValid(parameters)) {                                                  // temperature
                // Reducer
                for (Reducer reducer : reducers) {
                    if (pump.getProducer().equals(reducer.getVendor()) &&                                   // vendor check
                            pump.isReducerValid(reducer, parameters)) {
                        // Motor
                        for (Motor motor : motors) {
                            if (pump.getProducer().equals(motor.getVendor()) &&                             // vendor check
                                    motor.isMotorValid(reducer) &&
                                    motor.isExplosionProofAvailable() == parameters.isExplosionProof()) {
                                // Seal
                                for (Seal seal : seals) {                                                   // seal
                                    // TODO: 11.07.2016 oRing check
                                    if (seal.getSealType().getValue().equals(parameters.getSealType()) &&   // seal type
                                            pump.isValidTo(seal.getSuitablePumps())) {
                                        // DriverAssembly
                                        for (DriverAssembly driverAssembly : driverAssemblies) {            // driver assembly
                                            if (driverAssembly.getDriverAssemblyType().getValue().equals    // driver assembly type
                                                    (parameters.getDriverAssemblyType()) &&
                                                    pump.isValidTo(driverAssembly.getSuitablePumps())) {
                                                // Frame
                                                for (Frame frame : frames) {
                                                    if (pump.isValidTo(frame.getSuitablePumps())) {
                                                        PumpAggregate aggregate = new PumpAggregate();
                                                        aggregate.setPump(pump);
                                                        aggregate.setReducer(reducer);
                                                        aggregate.setMotor(motor);
                                                        aggregate.setSeal(seal);
                                                        aggregate.setDriverAssembly(driverAssembly);
                                                        aggregate.setFrame(frame);

                                                        // Write shaft speed to PumpAggregate field.
                                                        aggregate.setShaftSpeed(pump.getShaftSpeed(parameters));
                                                        // Write parameters to PumpAggregate field.
                                                        aggregate.setParameters(parameters.toString());
                                                        // Calculate and write Total Price.
                                                        aggregate.setTotalPrice(2);

                                                        pumpAggregates.add(aggregate);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return pumpAggregates;
    }

//    @ResponseBody
//    @RequestMapping(value = "/filldatabase", method = RequestMethod.GET)
//    public String test() {
//
//    //http://127.0.0.1:8080/pump/api/PumpSelectionService/filldatabase
//
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//
//        /**
//         * COUNTRIES
//         */
//        Constant wonderland = new Constant("country", "Wonderland");
//        session.persist(wonderland);
//        Constant germany = new Constant("country", "Germany");
//        session.persist(germany);
//        Constant turkey =  new Constant("country", "Turkey");
//        session.persist(turkey);
//
//        /* Producers */
//        Producer dreampompa = new Producer();
//        dreampompa.setProducerName("Dreampompa"); // producer
//        dreampompa.setProducerCountry(wonderland); // country
//        session.persist(dreampompa);
//
//        Producer eagleBurgmann = new Producer();
//        eagleBurgmann.setProducerName("Eagle Burgmann"); // producer
//        eagleBurgmann.setProducerCountry(germany); // country
//        session.persist(eagleBurgmann);
//
////        Producer abb = new Producer();
////        eagleBurgmann.setProducerName("ABB"); // producer
////        eagleBurgmann.setProducerCountry(germany); // country
////        session.persist(abb);
//
//        Producer turkishMotor = new Producer();
//        turkishMotor.setProducerName("GAMAK, WAT, ABANA or VOLT"); // producer
//        turkishMotor.setProducerCountry(turkey); // country
//        session.persist(turkishMotor);
//
//        Producer iMak = new Producer();
//        iMak.setProducerName("I.Mak Reduktor"); // producer
//        iMak.setProducerCountry(turkey); // country
//        session.persist(iMak);
//
//        Constant internalGearPump = new Constant("pump type", "Internal Eccentric Gear Pump"); // pumpType
//        session.persist(internalGearPump);
//
////        private Seal seal;
//        Constant sealTypePacking = new Constant("sealType", "Packing");
//        session.persist(sealTypePacking);
////        Constant sealTypeLip = new Constant("sealType", "Lip Seal");
////        session.persist(sealTypeLip);
////        Constant sealTypeMechanical = new Constant("sealType", "Mechanical Seal");
////        session.persist(sealTypeMechanical);
//        Constant oRingMaterialNone = new Constant("material", "none");
//        session.persist(oRingMaterialNone);
////        Constant oRingMaterialViton = new Constant("material", "Viton&reg;");
////        session.persist(oRingMaterialViton);
////        private Constant constCastingMaterial;
////        private Constant constRotorGearMaterial;
////        private Constant constIdlerGearMaterial;
//        Constant castIron25 = new Constant("material", "GG 25 Cast Iron");
//        session.persist(castIron25);
//        Constant castIron40 = new Constant("material", "GGG 40 Cast Iron");
//        session.persist(castIron40);
//        Constant castSteel = new Constant("material", "GS 45 Cast Steel");
//        session.persist(castSteel);
////        Constant cast304Steel = new Constant("material", "AISI 304 CrNi Stainless Steel");
////        Constant cast316Steel = new Constant("material", "AISI 316 CrNi Stainless Steel");
////        private Constant constShaftMaterial;
//        Constant heatTreated1050 = new Constant("material", "1050 Steel, Heat Treated");
//        session.persist(heatTreated1050);
////        private Constant constShaftSupportMaterial;
//        Constant bronze = new Constant("material", "CuSn 12 Bronze Bushings");
//        session.persist(bronze);
//        // Constant carbon = new Constant("material", "Carbon Graphite Bushings");
////        private Constant constConnectionsType;
//        Constant flange = new Constant("connections type", "flange");
//        session.persist(flange);
////        private Constant constDn;
//        //Constant dn865 = new Constant("DN", "65");
//        Constant dn80 = new Constant("DN", "80");
//        session.persist(dn80);
//        //Constant dn125 = new Constant("DN", "125");
////        private Constant constMaxPressure;
//        Constant maxPressure10 = new Constant("max. pressure", "10");
//        session.persist(maxPressure10);
////        private Constant constConnectionsAngle;
//        Constant connectionsAngle90 = new Constant("connections angle", "90");
//        session.persist(connectionsAngle90);
//        //Constant connectionsAngle180 = new Constant("connections angle", "180");
////        private Constant constMaxTemperature;
//        Constant maxTemperature200 = new Constant("max. temperature", "200");
//        session.persist(maxTemperature200);
//
//        Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients = new HashSet<>();
//        SpeedCorrectionCoefficient sp38 = new SpeedCorrectionCoefficient(38, 60);
//        session.persist(sp38);
//        SpeedCorrectionCoefficient sp100 = new SpeedCorrectionCoefficient(100, 63);
//        session.persist(sp100);
//        SpeedCorrectionCoefficient sp750 = new SpeedCorrectionCoefficient(750, 30);
//        session.persist(sp750);
//        SpeedCorrectionCoefficient sp2500 = new SpeedCorrectionCoefficient(2500, 17);
//        session.persist(sp2500);
//        SpeedCorrectionCoefficient sp7500 = new SpeedCorrectionCoefficient(7500, 10);
//        session.persist(sp7500);
//        SpeedCorrectionCoefficient sp25000 = new SpeedCorrectionCoefficient(25000, 5);
//        session.persist(sp25000);
//        SpeedCorrectionCoefficient sp75000 = new SpeedCorrectionCoefficient(75000, 13);
//        session.persist(sp75000);
//        SpeedCorrectionCoefficient sp250000 = new SpeedCorrectionCoefficient(250000, 1);
//        session.persist(sp250000);
//        speedCorrectionCoefficients.add(sp38);
//        speedCorrectionCoefficients.add(sp100);
//        speedCorrectionCoefficients.add(sp750);
//        speedCorrectionCoefficients.add(sp2500);
//        speedCorrectionCoefficients.add(sp7500);
//        speedCorrectionCoefficients.add(sp25000);
//        speedCorrectionCoefficients.add(sp75000);
//        speedCorrectionCoefficients.add(sp250000);
//
//
//
//        Pump ykf3 = new Pump();
//        ykf3.setProducer(dreampompa);
//        ykf3.setModelName("YKF-3");
//        ykf3.setPrice(new BigDecimal("1020.00"));
//        ykf3.setConstPumpType(internalGearPump);
//        ykf3.setReliefValve(true);
//        ykf3.setHeatingJacketOnCover(false);
//        ykf3.setHeatingJacketOnCasting(false);
//        ykf3.setHeatingJacketOnBracket(false);
//        ykf3.setConstCastingMaterial(castIron25);
//        ykf3.setConstRotorGearMaterial(castIron40);
//        ykf3.setConstIdlerGearMaterial(castIron40);
//        ykf3.setConstShaftSupportMaterial(bronze);
//        ykf3.setConstShaftMaterial(heatTreated1050);
//        ykf3.setConstConnectionsType(flange);
//        ykf3.setConstDn(dn80);
//        ykf3.setConstMaxPressure(maxPressure10);
//        ykf3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3.setConstMaxTemperature(maxTemperature200);
//        ykf3.setRpmCoefficient(12.5);
//        ykf3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        session.persist(ykf3);
//
//        /**
//         * YKF-3 w Valve
//         */
//        Pump ykf3wValve = new Pump();
//        ykf3wValve.setProducer(dreampompa);
//        ykf3wValve.setModelName("YKF-3 with relief valve");
//        ykf3wValve.setPrice(new BigDecimal("1180.00"));
//        ykf3wValve.setConstPumpType(internalGearPump);
//        ykf3wValve.setReliefValve(true);
//        ykf3wValve.setHeatingJacketOnCover(true);
//        ykf3wValve.setHeatingJacketOnCasting(false);
//        ykf3wValve.setHeatingJacketOnBracket(false);
//        ykf3wValve.setConstCastingMaterial(castIron25);
//        ykf3wValve.setConstRotorGearMaterial(castIron40);
//        ykf3wValve.setConstIdlerGearMaterial(castIron40);
//        ykf3wValve.setConstShaftSupportMaterial(bronze);
//        ykf3wValve.setConstShaftMaterial(heatTreated1050);
//        ykf3wValve.setConstConnectionsType(flange);
//        ykf3wValve.setConstDn(dn80);
//        ykf3wValve.setConstMaxPressure(maxPressure10);
//        ykf3wValve.setConstConnectionsAngle(connectionsAngle90);
//        ykf3wValve.setConstMaxTemperature(maxTemperature200);
//        ykf3wValve.setRpmCoefficient(12.5);
//        ykf3wValve.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        session.persist(ykf3wValve);
//
//
//        Pump ykf3wJC = new Pump();
//        ykf3wJC.setProducer(dreampompa);
//        ykf3wJC.setModelName("YKF-3 with jacket on cover");
//        ykf3wJC.setPrice(new BigDecimal("1070.00"));
//        ykf3wJC.setConstPumpType(internalGearPump);
//        ykf3wJC.setReliefValve(true);
//        ykf3wJC.setHeatingJacketOnCover(false);
//        ykf3wJC.setHeatingJacketOnCasting(true);
//        ykf3wJC.setHeatingJacketOnBracket(false);
//        ykf3wJC.setConstCastingMaterial(castIron25);
//        ykf3wJC.setConstRotorGearMaterial(castIron40);
//        ykf3wJC.setConstIdlerGearMaterial(castIron40);
//        ykf3wJC.setConstShaftSupportMaterial(bronze);
//        ykf3wJC.setConstShaftMaterial(heatTreated1050);
//        ykf3wJC.setConstConnectionsType(flange);
//        ykf3wJC.setConstDn(dn80);
//        ykf3wJC.setConstMaxPressure(maxPressure10);
//        ykf3wJC.setConstConnectionsAngle(connectionsAngle90);
//        ykf3wJC.setConstMaxTemperature(maxTemperature200);
//        ykf3wJC.setRpmCoefficient(12.5);
//        ykf3wJC.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        session.persist(ykf3wJC);
//
//
//        Pump ykf3wRVandJC = new Pump();
//        ykf3wRVandJC.setProducer(dreampompa);
//        ykf3wRVandJC.setModelName("YKF-3 with relief valve and jacket on casting");
//        ykf3wRVandJC.setPrice(new BigDecimal("1070.00"));
//        ykf3wRVandJC.setConstPumpType(internalGearPump);
//        ykf3wRVandJC.setReliefValve(true);
//        ykf3wRVandJC.setHeatingJacketOnCover(false);
//        ykf3wRVandJC.setHeatingJacketOnCasting(false);
//        ykf3wRVandJC.setHeatingJacketOnBracket(true);
//        ykf3wRVandJC.setConstCastingMaterial(castIron25);
//        ykf3wRVandJC.setConstRotorGearMaterial(castSteel);
//        ykf3wRVandJC.setConstIdlerGearMaterial(castSteel);
//        ykf3wRVandJC.setConstShaftSupportMaterial(bronze);
//        ykf3wRVandJC.setConstShaftMaterial(heatTreated1050);
//        ykf3wRVandJC.setConstConnectionsType(flange);
//        ykf3wRVandJC.setConstDn(dn80);
//        ykf3wRVandJC.setConstMaxPressure(maxPressure10);
//        ykf3wRVandJC.setConstConnectionsAngle(connectionsAngle90);
//        ykf3wRVandJC.setConstMaxTemperature(maxTemperature200);
//        ykf3wRVandJC.setRpmCoefficient(12.5);
//        ykf3wRVandJC.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        session.persist(ykf3wRVandJC);
//
//
//        Set<Pump> pumpsSet = new HashSet<>();
//        pumpsSet.add(ykf3);
//        pumpsSet.add(ykf3wValve);
//        pumpsSet.add(ykf3wJC);
//        pumpsSet.add(ykf3wRVandJC);
//
//
//
//        Seal seal01 = new Seal(dreampompa, "YKF-3 packing", new BigDecimal("0"), sealTypePacking, oRingMaterialNone, pumpsSet);
//        session.persist(seal01);
//
//        Constant adder = new Constant("driver assembly type", "Pump Adder");
//        session.persist(adder);
//        Constant coupling = new Constant("driver assembly type", "Coupling");
//        session.persist(coupling);
//        Constant belt = new Constant("driver assembly type", "Belt and Pulley");
//        session.persist(belt);
//        Constant flex = new Constant("driver assembly type", "Flexible Coupling");
//        session.persist(flex);
//
//        Constant atex = new Constant("explosion proof", "ATEX");
//        session.persist(atex);
//        Constant none = new Constant("explosion proof", "none");
//        session.persist(none);
//
//        DriverAssembly ykf3assembly01 = new DriverAssembly(dreampompa, "ykf-3 pump adder", new BigDecimal("420"),
//                adder, atex, pumpsSet);
//        session.persist(ykf3assembly01);
//        DriverAssembly ykf3assembly02 = new DriverAssembly(dreampompa, "ykf-3 ex. proof coupling", new BigDecimal("180"),
//                coupling, atex, pumpsSet);
//        session.persist(ykf3assembly02);
//        DriverAssembly ykf3assembly03 = new DriverAssembly(dreampompa, "ykf-3 belt and pulley", new BigDecimal("300"),
//                belt, none, pumpsSet);
//        session.persist(ykf3assembly03);
//        DriverAssembly ykf3assembly04 = new DriverAssembly(dreampompa, "ykf-3 flexible coupling", new BigDecimal("240"),
//                flex, none, pumpsSet);
//        session.persist(ykf3assembly04);
//
//
//        Frame frame01 = new Frame(dreampompa, "YKF-3 frame", new BigDecimal("0"), pumpsSet);
//        session.persist(frame01);
//
//        Constant motorPower5_5 = new Constant("motor power", "5.5");
//        session.persist(motorPower5_5);
//        Constant motorPower7_5 = new Constant("motor power", "7.5");
//        session.persist(motorPower7_5);
//        Constant motorPower10 = new Constant("motor power", "10");
//        session.persist(motorPower10);
//        Constant motorPower15 = new Constant("motor power", "15");
//        session.persist(motorPower15);
//        Constant motorPower20 = new Constant("motor power", "20");
//        session.persist(motorPower20);
//
//
//
//        Reducer reducer01 = new Reducer(iMak, "IRAM62/112M", new BigDecimal("555"), dreampompa, 87, 480,
//                none, motorPower5_5);
//        session.persist(reducer01);
//        Reducer reducer02 = new Reducer(iMak, "IRAM62/C112M", new BigDecimal("555"), dreampompa, 210, 450,
//                none, motorPower7_5);
//        session.persist(reducer02);
//        Reducer reducer03 = new Reducer(iMak, "IRAM72/132S", new BigDecimal("555"), dreampompa, 75, 210,
//                none, motorPower7_5);
//        session.persist(reducer03);
//        Reducer reducer04 = new Reducer(iMak, "IRAM72/132M", new BigDecimal("555"), dreampompa, 93, 450,
//                none, motorPower10);
//        session.persist(reducer04);
//        Reducer reducer05 = new Reducer(iMak, "IRAM72/C132M", new BigDecimal("555"), dreampompa, 200, 450,
//                none, motorPower15);
//        session.persist(reducer05);
//        Reducer reducer06 = new Reducer(iMak, "IRAM82/160L", new BigDecimal("555"), dreampompa, 130, 450,
//                none, motorPower20);
//        session.persist(reducer06);
//
//        Constant motorSpeed1500 = new Constant("motor speed", "1500");
//        session.persist(motorSpeed1500);
//
//        Motor motor01 = new Motor(turkishMotor, "turkish motor 5.5 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
//                none, motorPower5_5);
//        session.persist(motor01);
//        Motor motor02 = new Motor(turkishMotor, "turkish motor 7.5 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
//                none, motorPower7_5);
//        session.persist(motor02);
//        Motor motor03 = new Motor(turkishMotor, "turkish motor 10 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
//                none, motorPower10);
//        session.persist(motor03);
//        Motor motor04 = new Motor(turkishMotor, "turkish motor 15 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
//                none, motorPower15);
//        session.persist(motor04);
//        Motor motor05 = new Motor(turkishMotor, "turkish motor 20 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
//                none, motorPower20);
//        session.persist(motor05);
//
//        session.flush();
//        session.clear();
//
//        transaction.commit();
//
//
//        return "OK";
//    }

}

//@ResponseBody
    /*@RequestMapping(value = "/pumps", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public void getSuitablePumps(@RequestBody PumpAggregate aggregate) {
    }*/

//    @ResponseBody
//    @RequestMapping(value = "/pumps", method = RequestMethod.POST)
//    public String getSuitablePumps(@RequestBody Parameters params
//    ) {
//
//
//        return params.toString();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/pumps", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ADMIN')")
//    //public List<String> getSuitablePumps(
//    public List<PumpAggregate> getSuitablePumps(
//            @RequestParam(required = false, value = "queryParam1") Integer p1,
//            @RequestParam(required = true, value = "queryParam2") String p2,
//            HttpSession httpSession
//    )

//    Constant res = (Constant) session.createCriteria(Constant.class)
//            .add(Restrictions.eq("name", "country"))
//            .add(Restrictions.eq("value", "Germany")).uniqueResult();