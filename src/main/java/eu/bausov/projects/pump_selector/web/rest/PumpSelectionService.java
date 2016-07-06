package eu.bausov.projects.pump_selector.web.rest;

import eu.bausov.projects.pump_selector.bo.*;
import eu.bausov.projects.pump_selector.bo.equipment.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/PumpSelectionService")
@PreAuthorize("hasRole('ADMIN')")
public class PumpSelectionService {

    @Autowired
    private SessionFactory sessionFactory;

    @ResponseBody
    @RequestMapping(value = "/pumps", method = RequestMethod.POST)
    public List<PumpAggregate> getSuitablePumps(@RequestBody Parameters parameters) {

//        Session currentSession = sessionFactory.getCurrentSession();
//
//        // Get all equipment lists from DB
//        List<Pump> pumps = currentSession.createCriteria(Pump.class).list();
//        List<Reducer> reducers = currentSession.createCriteria(Reducer.class).list();
//        List<Motor> motors = currentSession.createCriteria(Motor.class).list();
//        List<Seal> seals = currentSession.createCriteria(Seal.class).list();
//        List<DriverAssembly> driverAssemblies = currentSession.createCriteria(DriverAssembly.class).list();
//        List<Frame> frames = currentSession.createCriteria(Frame.class).list();


        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        /* Producers */
        Producer dreampompa = new Producer();
        dreampompa.setProducerName("Dreampompa"); // producer
        dreampompa.setProducerCountry(new Constant("country", "Wonderland")); // country

        Producer eagleBurgmann = new Producer();
        eagleBurgmann.setProducerName("Eagle Burgmann"); // producer
        eagleBurgmann.setProducerCountry(new Constant("country", "Germany")); // country

        Producer abb = new Producer();
        eagleBurgmann.setProducerName("ABB"); // producer
        eagleBurgmann.setProducerCountry(new Constant("country", "Germany")); // country

        Producer turkishMotor = new Producer();
        eagleBurgmann.setProducerName("GAMAK, WAT, ABANA or VOLT"); // producer
        eagleBurgmann.setProducerCountry(new Constant("country", "Turkey")); // country

        Producer iMak = new Producer();
        eagleBurgmann.setProducerName("I.Mak Reduktor"); // producer
        eagleBurgmann.setProducerCountry(new Constant("country", "Turkey")); // country

        /* Pump */
//        private Constant constPumpType;
        Constant internalGearPump = new Constant("pump type", "Internal Eccentric Gear Pump"); // pumpType

//        private Seal seal;
        Constant sealTypePacking = new Constant("sealType", "Packing");
        Constant sealTypeLip = new Constant("sealType", "Lip Seal");
        Constant sealTypeMechanical = new Constant("sealType", "Mechanical Seal");
        Constant oRingMaterialNone = new Constant("material", "none");
        Constant oRingMaterialViton = new Constant("material", "Viton&reg;");
//        private Constant constCastingMaterial;
//        private Constant constRotorGearMaterial;
//        private Constant constIdlerGearMaterial;
        Constant castIron25 = new Constant("material", "GG 25 Cast Iron");
        Constant castIron40 = new Constant("material", "GGG 40 Cast Iron");
        Constant castSteel = new Constant("material", "GS 45 Cast Steel");
        Constant cast304Steel = new Constant("material", "AISI 304 CrNi Stainless Steel");
        Constant cast316Steel = new Constant("material", "AISI 316 CrNi Stainless Steel");
//        private Constant constShaftMaterial;
        Constant heatTreated1050 = new Constant("material", "1050 Steel, Heat Treated");
//        private Constant constShaftSupportMaterial;
        Constant bronze = new Constant("material", "CuSn 12 Bronze Bushings");
        Constant carbon = new Constant("material", "Carbon Graphite Bushings");
//        private Constant constConnectionsType;
        Constant flange = new Constant("connections type", "flange");
//        private Constant constDn;
        Constant dn865 = new Constant("DN", "65");
        Constant dn80 = new Constant("DN", "80");
        Constant dn125 = new Constant("DN", "125");
//        private Constant constMaxPressure;
        Constant maxPressure10 = new Constant("max. pressure", "10");
//        private Constant constConnectionsAngle;
        Constant connectionsAngle90 = new Constant("connections angle", "90");
        Constant connectionsAngle180 = new Constant("connections angle", "180");
//        private Constant constMaxTemperature;
        Constant maxTemperature200 = new Constant("max. temperature", "200");

        Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients = new HashSet<>();
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(38, 60));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(100, 63));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(750, 30));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(2500, 17));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(7500, 10));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(25000, 5));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(75000, 13));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(250000, 1));


        /**
         * YKF-3
         */
        Pump ykf3 = new Pump();
        ykf3.setProducer(dreampompa);
        ykf3.setModelName("YKF-3");
        ykf3.setPrice(new BigDecimal("1020.00"));
        ykf3.setConstPumpType(internalGearPump);
        ykf3.setReliefValve(true);
        ykf3.setHeatingJacketOnCover(false);
        ykf3.setHeatingJacketOnCasting(false);
        ykf3.setHeatingJacketOnBracket(false);
        ykf3.setConstCastingMaterial(castIron25);
        ykf3.setConstRotorGearMaterial(castIron40);
        ykf3.setConstIdlerGearMaterial(castIron40);
        ykf3.setConstShaftSupportMaterial(bronze);
        ykf3.setConstShaftMaterial(heatTreated1050);
        ykf3.setConstConnectionsType(flange);
        ykf3.setConstDn(dn80);
        ykf3.setConstMaxPressure(maxPressure10);
        ykf3.setConstConnectionsAngle(connectionsAngle90);
        ykf3.setConstMaxTemperature(maxTemperature200);
        ykf3.setRpmCoefficient(12.5);
        ykf3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);

        /**
         * YKF-3 w Valve
         */
        Pump ykf3wValve = new Pump();
        ykf3wValve.setProducer(dreampompa);
        ykf3wValve.setModelName("YKF-3 with relief valve");
        ykf3wValve.setPrice(new BigDecimal("1180.00"));
        ykf3wValve.setConstPumpType(internalGearPump);
        ykf3wValve.setReliefValve(true);
        ykf3wValve.setHeatingJacketOnCover(true);
        ykf3wValve.setHeatingJacketOnCasting(false);
        ykf3wValve.setHeatingJacketOnBracket(false);
        ykf3wValve.setConstCastingMaterial(castIron25);
        ykf3wValve.setConstRotorGearMaterial(castIron40);
        ykf3wValve.setConstIdlerGearMaterial(castIron40);
        ykf3wValve.setConstShaftSupportMaterial(bronze);
        ykf3wValve.setConstShaftMaterial(heatTreated1050);
        ykf3wValve.setConstConnectionsType(flange);
        ykf3wValve.setConstDn(dn80);
        ykf3wValve.setConstMaxPressure(maxPressure10);
        ykf3wValve.setConstConnectionsAngle(connectionsAngle90);
        ykf3wValve.setConstMaxTemperature(maxTemperature200);
        ykf3wValve.setRpmCoefficient(12.5);
        ykf3wValve.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);

        /**
         * YKF-3w Jacket on cover
         */
        Pump ykf3wJC = new Pump();
        ykf3wJC.setProducer(dreampompa);
        ykf3wJC.setModelName("YKF-3 with jacket on cover");
        ykf3wJC.setPrice(new BigDecimal("1070.00"));
        ykf3wJC.setConstPumpType(internalGearPump);
        ykf3wJC.setReliefValve(true);
        ykf3wJC.setHeatingJacketOnCover(false);
        ykf3wJC.setHeatingJacketOnCasting(true);
        ykf3wJC.setHeatingJacketOnBracket(false);
        ykf3wJC.setConstCastingMaterial(castIron25);
        ykf3wJC.setConstRotorGearMaterial(castIron40);
        ykf3wJC.setConstIdlerGearMaterial(castIron40);
        ykf3wJC.setConstShaftSupportMaterial(bronze);
        ykf3wJC.setConstShaftMaterial(heatTreated1050);
        ykf3wJC.setConstConnectionsType(flange);
        ykf3wJC.setConstDn(dn80);
        ykf3wJC.setConstMaxPressure(maxPressure10);
        ykf3wJC.setConstConnectionsAngle(connectionsAngle90);
        ykf3wJC.setConstMaxTemperature(maxTemperature200);
        ykf3wJC.setRpmCoefficient(12.5);
        ykf3wJC.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);

        /**
         * YKF-3 w Valve / w Jacket on casting
         */
        Pump ykf3wRVandJC = new Pump();
        ykf3wRVandJC.setProducer(dreampompa);
        ykf3wRVandJC.setModelName("YKF-3 with relief valve and jacket on casting");
        ykf3wRVandJC.setPrice(new BigDecimal("1070.00"));
        ykf3wRVandJC.setConstPumpType(internalGearPump);
        ykf3wRVandJC.setReliefValve(true);
        ykf3wRVandJC.setHeatingJacketOnCover(false);
        ykf3wRVandJC.setHeatingJacketOnCasting(false);
        ykf3wRVandJC.setHeatingJacketOnBracket(true);
        ykf3wRVandJC.setConstCastingMaterial(castIron25);
        ykf3wRVandJC.setConstRotorGearMaterial(castSteel);
        ykf3wRVandJC.setConstIdlerGearMaterial(castSteel);
        ykf3wRVandJC.setConstShaftSupportMaterial(bronze);
        ykf3wRVandJC.setConstShaftMaterial(heatTreated1050);
        ykf3wRVandJC.setConstConnectionsType(flange);
        ykf3wRVandJC.setConstDn(dn80);
        ykf3wRVandJC.setConstMaxPressure(maxPressure10);
        ykf3wRVandJC.setConstConnectionsAngle(connectionsAngle90);
        ykf3wRVandJC.setConstMaxTemperature(maxTemperature200);
        ykf3wRVandJC.setRpmCoefficient(12.5);
        ykf3wRVandJC.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);

        /**
         * Pumps set
         */
        Set<Pump> pumpsSet = new HashSet<>();
        pumpsSet.add(ykf3);
        pumpsSet.add(ykf3wValve);
        pumpsSet.add(ykf3wJC);
        pumpsSet.add(ykf3wRVandJC);


        /**
         * Seals
         */
        Seal seal01 = new Seal(dreampompa, "YKF-3 packing", new BigDecimal("0"), sealTypePacking, oRingMaterialNone, pumpsSet);


        /*
         * DriverAssembly
         */
        DriverAssembly ykf3assembly01 = new DriverAssembly(dreampompa, "ykf-3 pump adder", new BigDecimal("420"),
                new Constant("driver assembly type", "Pump Adder"), new Constant("explosion proof", "ATEX"), pumpsSet);
        DriverAssembly ykf3assembly02 = new DriverAssembly(dreampompa, "ykf-3 ex. proof coupling", new BigDecimal("180"),
                new Constant("driver assembly type", "Coupling"), new Constant("explosion proof", "ATEX"), pumpsSet);
        DriverAssembly ykf3assembly03 = new DriverAssembly(dreampompa, "ykf-3 belt and pulley", new BigDecimal("300"),
                new Constant("driver assembly type", "Belt and Pulley"), new Constant("explosion proof", "none"), pumpsSet);
        DriverAssembly ykf3assembly04 = new DriverAssembly(dreampompa, "ykf-3 flexible coupling", new BigDecimal("240"),
                new Constant("driver assembly type", "Flexible Coupling"), new Constant("explosion proof", "none"), pumpsSet);

        /**
         * Frame
         */
        Frame frame01 = new Frame(dreampompa, "YKF-3 frame", new BigDecimal("0"), pumpsSet);

        /**
         * Reducers
         */
        Reducer reducer01 = new Reducer(iMak, "IRAM62/112M", new BigDecimal("555"), dreampompa, new Range(87, 480),
                new Constant("explosion proof", "none"), new Constant("motor power", "5.5"));
        Reducer reducer02 = new Reducer(iMak, "IRAM62/C112M", new BigDecimal("555"), dreampompa, new Range(210, 450),
                new Constant("explosion proof", "none"), new Constant("motor power", "7.5"));
        Reducer reducer03 = new Reducer(iMak, "IRAM72/132S", new BigDecimal("555"), dreampompa, new Range(75, 210),
                new Constant("explosion proof", "none"), new Constant("motor power", "7.5"));
        Reducer reducer04 = new Reducer(iMak, "IRAM72/132M", new BigDecimal("555"), dreampompa, new Range(93, 450),
                new Constant("explosion proof", "none"), new Constant("motor power", "10"));
        Reducer reducer05 = new Reducer(iMak, "IRAM72/C132M", new BigDecimal("555"), dreampompa, new Range(200, 450),
                new Constant("explosion proof", "none"), new Constant("motor power", "15"));
        Reducer reducer06 = new Reducer(iMak, "IRAM82/160L", new BigDecimal("555"), dreampompa, new Range(130, 450),
                new Constant("explosion proof", "none"), new Constant("motor power", "20"));

        /**
         * Motors
         */
        Motor motor01 = new Motor(turkishMotor, "turkish motor 5.5 HP", new BigDecimal("0"), dreampompa, new Constant("motor speed", "1500"),
                new Constant("explosion proof", "none"), new Constant("motor power", "5.5"));
        Motor motor02 = new Motor(turkishMotor, "turkish motor 7.5 HP", new BigDecimal("0"), dreampompa, new Constant("motor speed", "1500"),
                new Constant("explosion proof", "none"), new Constant("motor power", "7.5"));
        Motor motor03 = new Motor(turkishMotor, "turkish motor 10 HP", new BigDecimal("0"), dreampompa, new Constant("motor speed", "1500"),
                new Constant("explosion proof", "none"), new Constant("motor power", "10"));
        Motor motor04 = new Motor(turkishMotor, "turkish motor 15 HP", new BigDecimal("0"), dreampompa, new Constant("motor speed", "1500"),
                new Constant("explosion proof", "none"), new Constant("motor power", "15"));
        Motor motor05 = new Motor(turkishMotor, "turkish motor 20 HP", new BigDecimal("0"), dreampompa, new Constant("motor speed", "1500"),
                new Constant("explosion proof", "none"), new Constant("motor power", "20"));

        List<Pump> pumps = new ArrayList<>();
        pumps.add(ykf3);
        pumps.add(ykf3wJC);
        pumps.add(ykf3wRVandJC);
        pumps.add(ykf3wValve);
        List<Reducer> reducers = new ArrayList<>();
        reducers.add(reducer01);
        reducers.add(reducer02);
        reducers.add(reducer03);
        reducers.add(reducer04);
        reducers.add(reducer05);
        reducers.add(reducer06);
        List<Motor> motors = new ArrayList<>();
        motors.add(motor01);
        motors.add(motor02);
        motors.add(motor03);
        motors.add(motor04);
        motors.add(motor05);
        List<Seal> seals = new ArrayList<>();
        seals.add(seal01);
        List<DriverAssembly> driverAssemblies = new ArrayList<>();
        driverAssemblies.add(ykf3assembly01);
        driverAssemblies.add(ykf3assembly02);
        driverAssemblies.add(ykf3assembly03);
        driverAssemblies.add(ykf3assembly04);
        List<Frame> frames = new ArrayList<>();
        frames.add(frame01);

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

        /////////////////////////////////////////////////////////////////////////////////////////////////////////


        List<PumpAggregate> pumpAggregates = new ArrayList<>();
        // Pump
        for (Pump pump : pumps) {
            if (pump.getConstPumpType().equals(parameters.getConstPumpType()) &&                    // pumpType
                    pump.getReliefValve() == parameters.getReliefValve() &&                         // reliefValve
                    (pump.getHeatingJacketOnCover() || pump.getHeatingJacketOnCasting() ||
                            pump.getHeatingJacketOnBracket()) == parameters.getHeatingJacket() &&   // heatingJacket
                    pump.getConstCastingMaterial().equals(parameters.getConstCastingMaterial()) &&  // castingMaterial
                    pump.isPressureValid(parameters) &&                                             // pressure
                    pump.isTemperatureValid(parameters)) {                                          // temperature
                // Reducer
                for (Reducer reducer : reducers) {
                    if (pump.getProducer().equals(reducer.getVendor()) &&                           // vendor check
                            pump.isReducerValid(reducer, parameters)) {
                        // Motor
                        for (Motor motor : motors) {
                            if (pump.getProducer().equals(motor.getVendor()) &&                     // vendor check
                                    motor.isMotorValid(reducer) &&
                                    parameters.getExplosionProof() == motor.isExplosionProofAvailable()) {
                                // Seal
                                for (Seal seal : seals) {                                           // seal
                                    if (pump.isValidTo(seal.getSuitablePumps())) {
                                        // DriverAssembly
                                        for (DriverAssembly driverAssembly : driverAssemblies) {
                                            if (parameters.getDriverAssembly().equals(driverAssembly) &&
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

        // Temporary solution
        ///////////////////////////////////////////////////////////////////
//        Pump pump = new Pump();
//        pump.setModelName("Model name");
//        PumpAggregate tmp = new PumpAggregate();
//        tmp.setPump(pump);
//        pumpAggregates.add(tmp);

        //return Arrays.asList("sd", "dd");

        return pumpAggregates;
    }
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