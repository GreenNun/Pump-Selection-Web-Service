package eu.bausov.projects.srvpumpselection.web.rest;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.bo.SpeedCorrectionCoefficient;
import eu.bausov.projects.srvpumpselection.bo.equipment.*;
import eu.bausov.projects.srvpumpselection.repository.*;
import eu.bausov.projects.srvpumpselection.utils.DBConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GreenNun on 18.03.17.
 */
@Controller
@RequestMapping(value = "/PumpSelectionService")
public class DBFillingService {
    private final Logger LOGGER = LoggerFactory.getLogger(PumpSelectionService.class);

    private final PumpRepository pumpRepository;
    private final ReducerRepository reducerRepository;
    private final MotorRepository motorRepository;
    private final SealRepository sealRepository;
    private final DriverAssemblyRepository driverAssemblyRepository;
    private final FrameRepository frameRepository;
    private final ConstantRepository constantRepository;
    private final ProducerRepository producerRepository;
    private final SpeedCorrectionCoefficientRepository speedCorrectionCoefficientRepository;

    @Autowired
    public DBFillingService(PumpRepository pumpRepository, ReducerRepository reducerRepository, MotorRepository motorRepository, SealRepository sealRepository, DriverAssemblyRepository driverAssemblyRepository, FrameRepository frameRepository, ConstantRepository constantRepository, ProducerRepository producerRepository, SpeedCorrectionCoefficientRepository speedCorrectionCoefficientRepository) {
        this.pumpRepository = pumpRepository;
        this.reducerRepository = reducerRepository;
        this.motorRepository = motorRepository;
        this.sealRepository = sealRepository;
        this.driverAssemblyRepository = driverAssemblyRepository;
        this.frameRepository = frameRepository;
        this.constantRepository = constantRepository;
        this.producerRepository = producerRepository;
        this.speedCorrectionCoefficientRepository = speedCorrectionCoefficientRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/filldatabase", method = RequestMethod.GET)
    @Transactional
    public String test() {
        LOGGER.info("Filling database...");

        //http://127.0.0.1:8080/pump/api/PumpSelectionService/filldatabase

        /**
         * COUNTRIES
         */
        Constant wonderland = new Constant(DBConst.COUNTRY, "Wonderland");
        constantRepository.save(wonderland);
        Constant germany = new Constant(DBConst.COUNTRY, "Germany");
        constantRepository.save(germany);
        Constant turkey = new Constant(DBConst.COUNTRY, "Turkey");
        constantRepository.save(turkey);

        /**
         * PRODUCERS
         */
        Producer dreampompa = new Producer();
        dreampompa.setProducerName("Dreampompa"); // producer
        dreampompa.setProducerCountry(wonderland); // country
        producerRepository.save(dreampompa);

        Producer eagleBurgmann = new Producer();
        eagleBurgmann.setProducerName("Eagle Burgmann"); // producer
        eagleBurgmann.setProducerCountry(germany); // country
        producerRepository.save(eagleBurgmann);

        Producer abb = new Producer();
        abb.setProducerName("ABB"); // producer
        abb.setProducerCountry(germany); // country
        producerRepository.save(abb);

        Producer turkishMotor = new Producer();
        turkishMotor.setProducerName("GAMAK, WAT, ABANA or VOLT"); // producer
        turkishMotor.setProducerCountry(turkey); // country
        producerRepository.save(turkishMotor);

        Producer iMak = new Producer();
        iMak.setProducerName("I.Mak Reduktor"); // producer
        iMak.setProducerCountry(turkey); // country
        producerRepository.save(iMak);

        /**
         * PUMP TYPES
         */
        Constant internalGearPump = new Constant(DBConst.PUMP_TYPE, "Internal Eccentric Gear Pump"); // pumpType
        constantRepository.save(internalGearPump);
        Constant modularGearPump = new Constant(DBConst.PUMP_TYPE, "Modular Gear Pump"); // pumpType
        constantRepository.save(modularGearPump);
        Constant helicalGearPump = new Constant(DBConst.PUMP_TYPE, "Helical Gear Pump"); // pumpType
        constantRepository.save(helicalGearPump);
        Constant lobePump = new Constant(DBConst.PUMP_TYPE, "Lobe Pump"); // pumpType
        constantRepository.save(lobePump);
        Constant foodPump = new Constant(DBConst.PUMP_TYPE, "Food Pump"); // pumpType
        constantRepository.save(foodPump);

        /**
         * SEAL TYPES
         */
        Constant sealTypePacking = new Constant(DBConst.SEAL_TYPE, "Packing");
        constantRepository.save(sealTypePacking);
        Constant sealTypeLip = new Constant(DBConst.SEAL_TYPE, "Lip Seal");
        constantRepository.save(sealTypeLip);
        Constant sealTypeMechanical = new Constant(DBConst.SEAL_TYPE, "Mechanical Seal");
        constantRepository.save(sealTypeMechanical);
        Constant sealTypeCartridgeMechanical = new Constant(DBConst.SEAL_TYPE, "Cartridge Mechanical Seal");
        constantRepository.save(sealTypeCartridgeMechanical);

        /**
         * MATERIALS
         */
        Constant oRingMaterialNone = new Constant(DBConst.SEAL_MATERIAL, "none"); // none
        constantRepository.save(oRingMaterialNone);
        Constant oRingMaterialViton = new Constant(DBConst.SEAL_MATERIAL, "Viton®"); // Viton
        constantRepository.save(oRingMaterialViton);
        Constant castIron25 = new Constant(DBConst.PUMP_MATERIAL, "GG 25 Cast Iron");
        constantRepository.save(castIron25);
        Constant castIron40 = new Constant(DBConst.PUMP_MATERIAL, "GGG 40 Cast Iron");
        constantRepository.save(castIron40);
        Constant castSteel = new Constant(DBConst.PUMP_MATERIAL, "GS 45 Cast Steel");
        constantRepository.save(castSteel);
        Constant cast304Steel = new Constant(DBConst.PUMP_MATERIAL, "AISI 304 CrNi Stainless Steel");
        constantRepository.save(cast304Steel);
        Constant cast316Steel = new Constant(DBConst.PUMP_MATERIAL, "AISI 316 CrNi Stainless Steel");
        constantRepository.save(cast316Steel);
        Constant heatTreated1050 = new Constant(DBConst.PUMP_MATERIAL, "1050 Steel, Heat Treated");
        constantRepository.save(heatTreated1050);
        Constant bronze = new Constant(DBConst.BUSHING_MATERIAL, "CuSn 12 Bronze Bushings");
        constantRepository.save(bronze);
        Constant carbon = new Constant(DBConst.BUSHING_MATERIAL, "Carbon Graphite Bushings");
        constantRepository.save(carbon);


        /**
         * CONNECTIONS TYPES
         */
        Constant flange = new Constant(DBConst.CONNECTIONS_TYPE, "Flange");
        constantRepository.save(flange);
        Constant thread = new Constant(DBConst.CONNECTIONS_TYPE, "Thread");
        constantRepository.save(thread);
        Constant pipeToothed = new Constant(DBConst.CONNECTIONS_TYPE, "Pipe Toothed");
        constantRepository.save(pipeToothed);

        /**
         * DN
         */
        Constant dn865 = new Constant(DBConst.DN, "65");
        constantRepository.save(dn865);
        Constant dn80 = new Constant(DBConst.DN, "80");
        constantRepository.save(dn80);
        Constant dn125 = new Constant(DBConst.DN, "125");
        constantRepository.save(dn125);

        /**
         * MAX PRESSURE
         */
        Constant maxPressure10 = new Constant(DBConst.MAX_PRESSURE, "10");
        constantRepository.save(maxPressure10);
        Constant maxPressure14 = new Constant(DBConst.MAX_PRESSURE, "14");
        constantRepository.save(maxPressure14);

        /**
         * CONNECTIONS ANGLE
         */
        Constant connectionsAngle90 = new Constant(DBConst.CONNECTION_ANGLE_TYPE, "90");
        constantRepository.save(connectionsAngle90);
        Constant connectionsAngle180 = new Constant(DBConst.CONNECTION_ANGLE_TYPE, "180");
        constantRepository.save(connectionsAngle180);


        /**
         * MAX TEMPERATURE
         */
        Constant maxTemperature200 = new Constant(DBConst.MAX_TEMPERATURE, "200");
        constantRepository.save(maxTemperature200);

        /**
         * YKF-3 COEFFICIENTS
         */
        Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients = new HashSet<>();
        SpeedCorrectionCoefficient sp38 = new SpeedCorrectionCoefficient(38, 60);
        speedCorrectionCoefficientRepository.save(sp38);
        SpeedCorrectionCoefficient sp100 = new SpeedCorrectionCoefficient(100, 63);
        speedCorrectionCoefficientRepository.save(sp100);
        SpeedCorrectionCoefficient sp750 = new SpeedCorrectionCoefficient(750, 30);
        speedCorrectionCoefficientRepository.save(sp750);
        SpeedCorrectionCoefficient sp2500 = new SpeedCorrectionCoefficient(2500, 17);
        speedCorrectionCoefficientRepository.save(sp2500);
        SpeedCorrectionCoefficient sp7500 = new SpeedCorrectionCoefficient(7500, 10);
        speedCorrectionCoefficientRepository.save(sp7500);
        SpeedCorrectionCoefficient sp25000 = new SpeedCorrectionCoefficient(25000, 5);
        speedCorrectionCoefficientRepository.save(sp25000);
        SpeedCorrectionCoefficient sp75000 = new SpeedCorrectionCoefficient(75000, 13);
        speedCorrectionCoefficientRepository.save(sp75000);
        SpeedCorrectionCoefficient sp250000 = new SpeedCorrectionCoefficient(250000, 1);
        speedCorrectionCoefficientRepository.save(sp250000);
        speedCorrectionCoefficients.add(sp38);
        speedCorrectionCoefficients.add(sp100);
        speedCorrectionCoefficients.add(sp750);
        speedCorrectionCoefficients.add(sp2500);
        speedCorrectionCoefficients.add(sp7500);
        speedCorrectionCoefficients.add(sp25000);
        speedCorrectionCoefficients.add(sp75000);
        speedCorrectionCoefficients.add(sp250000);

//////////////////////////////////////////////////////////////////////////////////////////
        //YKF-3

        speedCorrectionCoefficients = new HashSet<>();
        sp38 = new SpeedCorrectionCoefficient(38, 60);
        speedCorrectionCoefficientRepository.save(sp38);
        sp100 = new SpeedCorrectionCoefficient(100, 63);
        speedCorrectionCoefficientRepository.save(sp100);
        sp750 = new SpeedCorrectionCoefficient(750, 30);
        speedCorrectionCoefficientRepository.save(sp750);
        sp2500 = new SpeedCorrectionCoefficient(2500, 17);
        speedCorrectionCoefficientRepository.save(sp2500);
        sp7500 = new SpeedCorrectionCoefficient(7500, 10);
        speedCorrectionCoefficientRepository.save(sp7500);
        sp25000 = new SpeedCorrectionCoefficient(25000, 5);
        speedCorrectionCoefficientRepository.save(sp25000);
        sp75000 = new SpeedCorrectionCoefficient(75000, 13);
        speedCorrectionCoefficientRepository.save(sp75000);
        sp250000 = new SpeedCorrectionCoefficient(250000, 1);
        speedCorrectionCoefficientRepository.save(sp250000);
        speedCorrectionCoefficients.add(sp38);
        speedCorrectionCoefficients.add(sp100);
        speedCorrectionCoefficients.add(sp750);
        speedCorrectionCoefficients.add(sp2500);
        speedCorrectionCoefficients.add(sp7500);
        speedCorrectionCoefficients.add(sp25000);
        speedCorrectionCoefficients.add(sp75000);
        speedCorrectionCoefficients.add(sp250000);

        Pump ykf3 = new Pump();
        ykf3.setProducer(dreampompa);
        ykf3.setModelName("YKF-3");
        ykf3.setPrice(new BigDecimal("1020.00"));
        ykf3.setConstPumpType(internalGearPump);
        ykf3.setReliefValve(false);
        ykf3.setHeatingJacketOnCover(false);
        ykf3.setHeatingJacketOnCasing(false);
        ykf3.setHeatingJacketOnBracket(false);
        ykf3.setConstCasingMaterial(castIron25);
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
        pumpRepository.save(ykf3);
        // YKYF-3

        speedCorrectionCoefficients = new HashSet<>();
        sp38 = new SpeedCorrectionCoefficient(38, 60);
        speedCorrectionCoefficientRepository.save(sp38);
        sp100 = new SpeedCorrectionCoefficient(100, 63);
        speedCorrectionCoefficientRepository.save(sp100);
        sp750 = new SpeedCorrectionCoefficient(750, 30);
        speedCorrectionCoefficientRepository.save(sp750);
        sp2500 = new SpeedCorrectionCoefficient(2500, 17);
        speedCorrectionCoefficientRepository.save(sp2500);
        sp7500 = new SpeedCorrectionCoefficient(7500, 10);
        speedCorrectionCoefficientRepository.save(sp7500);
        sp25000 = new SpeedCorrectionCoefficient(25000, 5);
        speedCorrectionCoefficientRepository.save(sp25000);
        sp75000 = new SpeedCorrectionCoefficient(75000, 13);
        speedCorrectionCoefficientRepository.save(sp75000);
        sp250000 = new SpeedCorrectionCoefficient(250000, 1);
        speedCorrectionCoefficientRepository.save(sp250000);
        speedCorrectionCoefficients.add(sp38);
        speedCorrectionCoefficients.add(sp100);
        speedCorrectionCoefficients.add(sp750);
        speedCorrectionCoefficients.add(sp2500);
        speedCorrectionCoefficients.add(sp7500);
        speedCorrectionCoefficients.add(sp25000);
        speedCorrectionCoefficients.add(sp75000);
        speedCorrectionCoefficients.add(sp250000);

        Pump ykyf3 = new Pump();
        ykyf3.setProducer(dreampompa);
        ykyf3.setModelName("YKYF-3");
        ykyf3.setPrice(new BigDecimal("1040.00"));
        ykyf3.setConstPumpType(internalGearPump);
        ykyf3.setReliefValve(false);
        ykyf3.setHeatingJacketOnCover(false);
        ykyf3.setHeatingJacketOnCasing(false);
        ykyf3.setHeatingJacketOnBracket(false);
        ykyf3.setConstCasingMaterial(castIron25);
        ykyf3.setConstRotorGearMaterial(castIron40);
        ykyf3.setConstIdlerGearMaterial(castIron40);
        ykyf3.setConstShaftSupportMaterial(bronze);
        ykyf3.setConstShaftMaterial(heatTreated1050);
        ykyf3.setConstConnectionsType(flange);
        ykyf3.setConstDn(dn80);
        ykyf3.setConstMaxPressure(maxPressure10);
        ykyf3.setConstConnectionsAngle(connectionsAngle180);
        ykyf3.setConstMaxTemperature(maxTemperature200);
        ykyf3.setRpmCoefficient(12.5);
        ykyf3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
        Set<SpeedCorrectionCoefficient> set = speedCorrectionCoefficients;
        ykyf3.setSpeedCorrectionCoefficients(set);
        pumpRepository.save(ykyf3);
        // YKU-2.5

        speedCorrectionCoefficients = new HashSet<>();
        sp38 = new SpeedCorrectionCoefficient(38, 60);
        speedCorrectionCoefficientRepository.save(sp38);
        sp100 = new SpeedCorrectionCoefficient(100, 63);
        speedCorrectionCoefficientRepository.save(sp100);
        sp750 = new SpeedCorrectionCoefficient(750, 30);
        speedCorrectionCoefficientRepository.save(sp750);
        sp2500 = new SpeedCorrectionCoefficient(2500, 17);
        speedCorrectionCoefficientRepository.save(sp2500);
        sp7500 = new SpeedCorrectionCoefficient(7500, 10);
        speedCorrectionCoefficientRepository.save(sp7500);
        sp25000 = new SpeedCorrectionCoefficient(25000, 5);
        speedCorrectionCoefficientRepository.save(sp25000);
        sp75000 = new SpeedCorrectionCoefficient(75000, 13);
        speedCorrectionCoefficientRepository.save(sp75000);
        sp250000 = new SpeedCorrectionCoefficient(250000, 1);
        speedCorrectionCoefficientRepository.save(sp250000);
        speedCorrectionCoefficients.add(sp38);
        speedCorrectionCoefficients.add(sp100);
        speedCorrectionCoefficients.add(sp750);
        speedCorrectionCoefficients.add(sp2500);
        speedCorrectionCoefficients.add(sp7500);
        speedCorrectionCoefficients.add(sp25000);
        speedCorrectionCoefficients.add(sp75000);
        speedCorrectionCoefficients.add(sp250000);

        Pump yku2_5 = new Pump();
        yku2_5.setProducer(dreampompa);
        yku2_5.setModelName("YKF-2½");
        yku2_5.setPrice(new BigDecimal("960.00"));
        yku2_5.setConstPumpType(internalGearPump);
        yku2_5.setReliefValve(false);
        yku2_5.setHeatingJacketOnCover(false);
        yku2_5.setHeatingJacketOnCasing(false);
        yku2_5.setHeatingJacketOnBracket(false);
        yku2_5.setConstCasingMaterial(castIron25);
        yku2_5.setConstRotorGearMaterial(castIron40);
        yku2_5.setConstIdlerGearMaterial(castIron40);
        yku2_5.setConstShaftSupportMaterial(bronze);
        yku2_5.setConstShaftMaterial(heatTreated1050);
        yku2_5.setConstConnectionsType(pipeToothed);
        yku2_5.setConstDn(dn80);
        yku2_5.setConstMaxPressure(maxPressure10);
        yku2_5.setConstConnectionsAngle(connectionsAngle90);
        yku2_5.setConstMaxTemperature(maxTemperature200);
        yku2_5.setRpmCoefficient(12.5);
        yku2_5.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
        pumpRepository.save(yku2_5);
        // YKUF-2.5

        speedCorrectionCoefficients = new HashSet<>();
        sp38 = new SpeedCorrectionCoefficient(38, 60);
        speedCorrectionCoefficientRepository.save(sp38);
        sp100 = new SpeedCorrectionCoefficient(100, 63);
        speedCorrectionCoefficientRepository.save(sp100);
        sp750 = new SpeedCorrectionCoefficient(750, 30);
        speedCorrectionCoefficientRepository.save(sp750);
        sp2500 = new SpeedCorrectionCoefficient(2500, 17);
        speedCorrectionCoefficientRepository.save(sp2500);
        sp7500 = new SpeedCorrectionCoefficient(7500, 10);
        speedCorrectionCoefficientRepository.save(sp7500);
        sp25000 = new SpeedCorrectionCoefficient(25000, 5);
        speedCorrectionCoefficientRepository.save(sp25000);
        sp75000 = new SpeedCorrectionCoefficient(75000, 13);
        speedCorrectionCoefficientRepository.save(sp75000);
        sp250000 = new SpeedCorrectionCoefficient(250000, 1);
        speedCorrectionCoefficientRepository.save(sp250000);
        speedCorrectionCoefficients.add(sp38);
        speedCorrectionCoefficients.add(sp100);
        speedCorrectionCoefficients.add(sp750);
        speedCorrectionCoefficients.add(sp2500);
        speedCorrectionCoefficients.add(sp7500);
        speedCorrectionCoefficients.add(sp25000);
        speedCorrectionCoefficients.add(sp75000);
        speedCorrectionCoefficients.add(sp250000);

        Pump ykuf2_5 = new Pump();
        ykuf2_5.setProducer(dreampompa);
        ykuf2_5.setModelName("YKUF-2½");
        ykuf2_5.setPrice(new BigDecimal("980.00"));
        ykuf2_5.setConstPumpType(internalGearPump);
        ykuf2_5.setReliefValve(false);
        ykuf2_5.setHeatingJacketOnCover(false);
        ykuf2_5.setHeatingJacketOnCasing(false);
        ykuf2_5.setHeatingJacketOnBracket(false);
        ykuf2_5.setConstCasingMaterial(castIron25);
        ykuf2_5.setConstRotorGearMaterial(castIron40);
        ykuf2_5.setConstIdlerGearMaterial(castIron40);
        ykuf2_5.setConstShaftSupportMaterial(bronze);
        ykuf2_5.setConstShaftMaterial(heatTreated1050);
        ykuf2_5.setConstConnectionsType(flange);
        ykuf2_5.setConstDn(dn80);
        ykuf2_5.setConstMaxPressure(maxPressure10);
        ykuf2_5.setConstConnectionsAngle(connectionsAngle90);
        ykuf2_5.setConstMaxTemperature(maxTemperature200);
        ykuf2_5.setRpmCoefficient(12.5);
        ykuf2_5.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
        pumpRepository.save(ykuf2_5);
        // YKUYF-2.5
        speedCorrectionCoefficients = new HashSet<>();
        sp38 = new SpeedCorrectionCoefficient(38, 60);
        speedCorrectionCoefficientRepository.save(sp38);
        sp100 = new SpeedCorrectionCoefficient(100, 63);
        speedCorrectionCoefficientRepository.save(sp100);
        sp750 = new SpeedCorrectionCoefficient(750, 30);
        speedCorrectionCoefficientRepository.save(sp750);
        sp2500 = new SpeedCorrectionCoefficient(2500, 17);
        speedCorrectionCoefficientRepository.save(sp2500);
        sp7500 = new SpeedCorrectionCoefficient(7500, 10);
        speedCorrectionCoefficientRepository.save(sp7500);
        sp25000 = new SpeedCorrectionCoefficient(25000, 5);
        speedCorrectionCoefficientRepository.save(sp25000);
        sp75000 = new SpeedCorrectionCoefficient(75000, 13);
        speedCorrectionCoefficientRepository.save(sp75000);
        sp250000 = new SpeedCorrectionCoefficient(250000, 1);
        speedCorrectionCoefficientRepository.save(sp250000);
        speedCorrectionCoefficients.add(sp38);
        speedCorrectionCoefficients.add(sp100);
        speedCorrectionCoefficients.add(sp750);
        speedCorrectionCoefficients.add(sp2500);
        speedCorrectionCoefficients.add(sp7500);
        speedCorrectionCoefficients.add(sp25000);
        speedCorrectionCoefficients.add(sp75000);
        speedCorrectionCoefficients.add(sp250000);

        Pump ykuyf2_5 = new Pump();
        ykuyf2_5.setProducer(dreampompa);
        ykuyf2_5.setModelName("YKUYF-2½");
        ykuyf2_5.setPrice(new BigDecimal("980.00"));
        ykuyf2_5.setConstPumpType(internalGearPump);
        ykuyf2_5.setReliefValve(false);
        ykuyf2_5.setHeatingJacketOnCover(false);
        ykuyf2_5.setHeatingJacketOnCasing(false);
        ykuyf2_5.setHeatingJacketOnBracket(false);
        ykuyf2_5.setConstCasingMaterial(castIron25);
        ykuyf2_5.setConstRotorGearMaterial(castIron40);
        ykuyf2_5.setConstIdlerGearMaterial(castIron40);
        ykuyf2_5.setConstShaftSupportMaterial(bronze);
        ykuyf2_5.setConstShaftMaterial(heatTreated1050);
        ykuyf2_5.setConstConnectionsType(flange);
        ykuyf2_5.setConstDn(dn80);
        ykuyf2_5.setConstMaxPressure(maxPressure10);
        ykuyf2_5.setConstConnectionsAngle(connectionsAngle180);
        ykuyf2_5.setConstMaxTemperature(maxTemperature200);
        ykuyf2_5.setRpmCoefficient(12.5);
        ykuyf2_5.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
        pumpRepository.save(ykuyf2_5);
////////////////////////////////////////////////////////////////////////////////////////// + VALVE
        //YKF-3

        speedCorrectionCoefficients = new HashSet<>();
        sp38 = new SpeedCorrectionCoefficient(38, 60);
        speedCorrectionCoefficientRepository.save(sp38);
        sp100 = new SpeedCorrectionCoefficient(100, 63);
        speedCorrectionCoefficientRepository.save(sp100);
        sp750 = new SpeedCorrectionCoefficient(750, 30);
        speedCorrectionCoefficientRepository.save(sp750);
        sp2500 = new SpeedCorrectionCoefficient(2500, 17);
        speedCorrectionCoefficientRepository.save(sp2500);
        sp7500 = new SpeedCorrectionCoefficient(7500, 10);
        speedCorrectionCoefficientRepository.save(sp7500);
        sp25000 = new SpeedCorrectionCoefficient(25000, 5);
        speedCorrectionCoefficientRepository.save(sp25000);
        sp75000 = new SpeedCorrectionCoefficient(75000, 13);
        speedCorrectionCoefficientRepository.save(sp75000);
        sp250000 = new SpeedCorrectionCoefficient(250000, 1);
        speedCorrectionCoefficientRepository.save(sp250000);
        speedCorrectionCoefficients.add(sp38);
        speedCorrectionCoefficients.add(sp100);
        speedCorrectionCoefficients.add(sp750);
        speedCorrectionCoefficients.add(sp2500);
        speedCorrectionCoefficients.add(sp7500);
        speedCorrectionCoefficients.add(sp25000);
        speedCorrectionCoefficients.add(sp75000);
        speedCorrectionCoefficients.add(sp250000);

        Pump ykf3v = new Pump();
        ykf3v.setProducer(dreampompa);
        ykf3v.setModelName("YKF-3 with Relief Valve");
        ykf3v.setPrice(new BigDecimal("1180.00"));
        ykf3v.setConstPumpType(internalGearPump);
        ykf3v.setReliefValve(true);
        ykf3v.setHeatingJacketOnCover(false);
        ykf3v.setHeatingJacketOnCasing(false);
        ykf3v.setHeatingJacketOnBracket(false);
        ykf3v.setConstCasingMaterial(castIron25);
        ykf3v.setConstRotorGearMaterial(castIron40);
        ykf3v.setConstIdlerGearMaterial(castIron40);
        ykf3v.setConstShaftSupportMaterial(bronze);
        ykf3v.setConstShaftMaterial(heatTreated1050);
        ykf3v.setConstConnectionsType(flange);
        ykf3v.setConstDn(dn80);
        ykf3v.setConstMaxPressure(maxPressure10);
        ykf3v.setConstConnectionsAngle(connectionsAngle90);
        ykf3v.setConstMaxTemperature(maxTemperature200);
        ykf3v.setRpmCoefficient(12.5);
        ykf3v.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
        pumpRepository.save(ykf3v);
//        // YKYF-3
//        Pump ykyf3v = new Pump();
//        ykyf3v.setProducer(dreampompa);
//        ykyf3v.setModelName("YKYF-3 with Relief Valve");
//        ykyf3v.setPrice(new BigDecimal("1200.00"));
//        ykyf3v.setConstPumpType(internalGearPump);
//        ykyf3v.setReliefValve(true);
//        ykyf3v.setHeatingJacketOnCover(false);
//        ykyf3v.setHeatingJacketOnCasing(false);
//        ykyf3v.setHeatingJacketOnBracket(false);
//        ykyf3v.setConstCasingMaterial(castIron25);
//        ykyf3v.setConstRotorGearMaterial(castIron40);
//        ykyf3v.setConstIdlerGearMaterial(castIron40);
//        ykyf3v.setConstShaftSupportMaterial(bronze);
//        ykyf3v.setConstShaftMaterial(heatTreated1050);
//        ykyf3v.setConstConnectionsType(flange);
//        ykyf3v.setConstDn(dn80);
//        ykyf3v.setConstMaxPressure(maxPressure10);
//        ykyf3v.setConstConnectionsAngle(connectionsAngle180);
//        ykyf3v.setConstMaxTemperature(maxTemperature200);
//        ykyf3v.setRpmCoefficient(12.5);
//        ykyf3v.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykyf3v);
//        // YKU-2.5
//        Pump yku2_5v = new Pump();
//        yku2_5v.setProducer(dreampompa);
//        yku2_5v.setModelName("YKF-2½ with Relief Valve");
//        yku2_5v.setPrice(new BigDecimal("1120.00"));
//        yku2_5v.setConstPumpType(internalGearPump);
//        yku2_5v.setReliefValve(true);
//        yku2_5v.setHeatingJacketOnCover(false);
//        yku2_5v.setHeatingJacketOnCasing(false);
//        yku2_5v.setHeatingJacketOnBracket(false);
//        yku2_5v.setConstCasingMaterial(castIron25);
//        yku2_5v.setConstRotorGearMaterial(castIron40);
//        yku2_5v.setConstIdlerGearMaterial(castIron40);
//        yku2_5v.setConstShaftSupportMaterial(bronze);
//        yku2_5v.setConstShaftMaterial(heatTreated1050);
//        yku2_5v.setConstConnectionsType(pipeToothed);
//        yku2_5v.setConstDn(dn80);
//        yku2_5v.setConstMaxPressure(maxPressure10);
//        yku2_5v.setConstConnectionsAngle(connectionsAngle90);
//        yku2_5v.setConstMaxTemperature(maxTemperature200);
//        yku2_5v.setRpmCoefficient(12.5);
//        yku2_5v.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(yku2_5v);
//        // YKUF-2.5
//        Pump ykuf2_5v = new Pump();
//        ykuf2_5v.setProducer(dreampompa);
//        ykuf2_5v.setModelName("YKUF-2½ with Relief Valve");
//        ykuf2_5v.setPrice(new BigDecimal("1140.00"));
//        ykuf2_5v.setConstPumpType(internalGearPump);
//        ykuf2_5v.setReliefValve(true);
//        ykuf2_5v.setHeatingJacketOnCover(false);
//        ykuf2_5v.setHeatingJacketOnCasing(false);
//        ykuf2_5v.setHeatingJacketOnBracket(false);
//        ykuf2_5v.setConstCasingMaterial(castIron25);
//        ykuf2_5v.setConstRotorGearMaterial(castIron40);
//        ykuf2_5v.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5v.setConstShaftSupportMaterial(bronze);
//        ykuf2_5v.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5v.setConstConnectionsType(flange);
//        ykuf2_5v.setConstDn(dn80);
//        ykuf2_5v.setConstMaxPressure(maxPressure10);
//        ykuf2_5v.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5v.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5v.setRpmCoefficient(12.5);
//        ykuf2_5v.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5v);
//        // YKUYF-2.5
//        Pump ykuyf2_5v = new Pump();
//        ykuyf2_5v.setProducer(dreampompa);
//        ykuyf2_5v.setModelName("YKUYF-2½ with Relief Valve");
//        ykuyf2_5v.setPrice(new BigDecimal("1140.00"));
//        ykuyf2_5v.setConstPumpType(internalGearPump);
//        ykuyf2_5v.setReliefValve(true);
//        ykuyf2_5v.setHeatingJacketOnCover(false);
//        ykuyf2_5v.setHeatingJacketOnCasing(false);
//        ykuyf2_5v.setHeatingJacketOnBracket(false);
//        ykuyf2_5v.setConstCasingMaterial(castIron25);
//        ykuyf2_5v.setConstRotorGearMaterial(castIron40);
//        ykuyf2_5v.setConstIdlerGearMaterial(castIron40);
//        ykuyf2_5v.setConstShaftSupportMaterial(bronze);
//        ykuyf2_5v.setConstShaftMaterial(heatTreated1050);
//        ykuyf2_5v.setConstConnectionsType(flange);
//        ykuyf2_5v.setConstDn(dn80);
//        ykuyf2_5v.setConstMaxPressure(maxPressure10);
//        ykuyf2_5v.setConstConnectionsAngle(connectionsAngle180);
//        ykuyf2_5v.setConstMaxTemperature(maxTemperature200);
//        ykuyf2_5v.setRpmCoefficient(12.5);
//        ykuyf2_5v.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuyf2_5v);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER
//        //YKF-3
//        Pump ykf3h1 = new Pump();
//        ykf3h1.setProducer(dreampompa);
//        ykf3h1.setModelName("YKF-3 with Heating Jacket on Cover");
//        ykf3h1.setPrice(new BigDecimal("1070.00"));
//        ykf3h1.setConstPumpType(internalGearPump);
//        ykf3h1.setReliefValve(false);
//        ykf3h1.setHeatingJacketOnCover(true);
//        ykf3h1.setHeatingJacketOnCasing(false);
//        ykf3h1.setHeatingJacketOnBracket(false);
//        ykf3h1.setConstCasingMaterial(castIron25);
//        ykf3h1.setConstRotorGearMaterial(castIron40);
//        ykf3h1.setConstIdlerGearMaterial(castIron40);
//        ykf3h1.setConstShaftSupportMaterial(bronze);
//        ykf3h1.setConstShaftMaterial(heatTreated1050);
//        ykf3h1.setConstConnectionsType(flange);
//        ykf3h1.setConstDn(dn80);
//        ykf3h1.setConstMaxPressure(maxPressure10);
//        ykf3h1.setConstConnectionsAngle(connectionsAngle90);
//        ykf3h1.setConstMaxTemperature(maxTemperature200);
//        ykf3h1.setRpmCoefficient(12.5);
//        ykf3h1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3h1);
//        // YKYF-3
//        Pump ykyf3h1 = new Pump();
//        ykyf3h1.setProducer(dreampompa);
//        ykyf3h1.setModelName("YKYF-3 with Heating Jacket on Cover");
//        ykyf3h1.setPrice(new BigDecimal("1090.00"));
//        ykyf3h1.setConstPumpType(internalGearPump);
//        ykyf3h1.setReliefValve(false);
//        ykyf3h1.setHeatingJacketOnCover(true);
//        ykyf3h1.setHeatingJacketOnCasing(false);
//        ykyf3h1.setHeatingJacketOnBracket(false);
//        ykyf3h1.setConstCasingMaterial(castIron25);
//        ykyf3h1.setConstRotorGearMaterial(castIron40);
//        ykyf3h1.setConstIdlerGearMaterial(castIron40);
//        ykyf3h1.setConstShaftSupportMaterial(bronze);
//        ykyf3h1.setConstShaftMaterial(heatTreated1050);
//        ykyf3h1.setConstConnectionsType(flange);
//        ykyf3h1.setConstDn(dn80);
//        ykyf3h1.setConstMaxPressure(maxPressure10);
//        ykyf3h1.setConstConnectionsAngle(connectionsAngle180);
//        ykyf3h1.setConstMaxTemperature(maxTemperature200);
//        ykyf3h1.setRpmCoefficient(12.5);
//        ykyf3h1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykyf3h1);
//        // YKU-2.5
//        Pump yku2_5h1 = new Pump();
//        yku2_5h1.setProducer(dreampompa);
//        yku2_5h1.setModelName("YKF-2½ with Heating Jacket on Cover");
//        yku2_5h1.setPrice(new BigDecimal("1010.00"));
//        yku2_5h1.setConstPumpType(internalGearPump);
//        yku2_5h1.setReliefValve(false);
//        yku2_5h1.setHeatingJacketOnCover(true);
//        yku2_5h1.setHeatingJacketOnCasing(false);
//        yku2_5h1.setHeatingJacketOnBracket(false);
//        yku2_5h1.setConstCasingMaterial(castIron25);
//        yku2_5h1.setConstRotorGearMaterial(castIron40);
//        yku2_5h1.setConstIdlerGearMaterial(castIron40);
//        yku2_5h1.setConstShaftSupportMaterial(bronze);
//        yku2_5h1.setConstShaftMaterial(heatTreated1050);
//        yku2_5h1.setConstConnectionsType(pipeToothed);
//        yku2_5h1.setConstDn(dn80);
//        yku2_5h1.setConstMaxPressure(maxPressure10);
//        yku2_5h1.setConstConnectionsAngle(connectionsAngle90);
//        yku2_5h1.setConstMaxTemperature(maxTemperature200);
//        yku2_5h1.setRpmCoefficient(12.5);
//        yku2_5h1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(yku2_5h1);
//        // YKUF-2.5
//        Pump ykuf2_5h1 = new Pump();
//        ykuf2_5h1.setProducer(dreampompa);
//        ykuf2_5h1.setModelName("YKUF-2½ with Heating Jacket on Cover");
//        ykuf2_5h1.setPrice(new BigDecimal("1030.00"));
//        ykuf2_5h1.setConstPumpType(internalGearPump);
//        ykuf2_5h1.setReliefValve(false);
//        ykuf2_5h1.setHeatingJacketOnCover(true);
//        ykuf2_5h1.setHeatingJacketOnCasing(false);
//        ykuf2_5h1.setHeatingJacketOnBracket(false);
//        ykuf2_5h1.setConstCasingMaterial(castIron25);
//        ykuf2_5h1.setConstRotorGearMaterial(castIron40);
//        ykuf2_5h1.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5h1.setConstShaftSupportMaterial(bronze);
//        ykuf2_5h1.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5h1.setConstConnectionsType(flange);
//        ykuf2_5h1.setConstDn(dn80);
//        ykuf2_5h1.setConstMaxPressure(maxPressure10);
//        ykuf2_5h1.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5h1.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5h1.setRpmCoefficient(12.5);
//        ykuf2_5h1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5h1);
//        // YKUYF-2.5
//        Pump ykuyf2_5h1 = new Pump();
//        ykuyf2_5h1.setProducer(dreampompa);
//        ykuyf2_5h1.setModelName("YKUYF-2½ with Heating Jacket on Cover");
//        ykuyf2_5h1.setPrice(new BigDecimal("1030.00"));
//        ykuyf2_5h1.setConstPumpType(internalGearPump);
//        ykuyf2_5h1.setReliefValve(false);
//        ykuyf2_5h1.setHeatingJacketOnCover(true);
//        ykuyf2_5h1.setHeatingJacketOnCasing(false);
//        ykuyf2_5h1.setHeatingJacketOnBracket(false);
//        ykuyf2_5h1.setConstCasingMaterial(castIron25);
//        ykuyf2_5h1.setConstRotorGearMaterial(castIron40);
//        ykuyf2_5h1.setConstIdlerGearMaterial(castIron40);
//        ykuyf2_5h1.setConstShaftSupportMaterial(bronze);
//        ykuyf2_5h1.setConstShaftMaterial(heatTreated1050);
//        ykuyf2_5h1.setConstConnectionsType(flange);
//        ykuyf2_5h1.setConstDn(dn80);
//        ykuyf2_5h1.setConstMaxPressure(maxPressure10);
//        ykuyf2_5h1.setConstConnectionsAngle(connectionsAngle180);
//        ykuyf2_5h1.setConstMaxTemperature(maxTemperature200);
//        ykuyf2_5h1.setRpmCoefficient(12.5);
//        ykuyf2_5h1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuyf2_5h1);
//////////////////////////////////////////////////////////////////////////////////////////// + H CASING
//        //YKF-3
//        Pump ykf3h2 = new Pump();
//        ykf3h2.setProducer(dreampompa);
//        ykf3h2.setModelName("YKF-3 with Heating Jacket on Casing");
//        ykf3h2.setPrice(new BigDecimal("1120.00"));
//        ykf3h2.setConstPumpType(internalGearPump);
//        ykf3h2.setReliefValve(false);
//        ykf3h2.setHeatingJacketOnCover(false);
//        ykf3h2.setHeatingJacketOnCasing(true);
//        ykf3h2.setHeatingJacketOnBracket(false);
//        ykf3h2.setConstCasingMaterial(castIron25);
//        ykf3h2.setConstRotorGearMaterial(castIron40);
//        ykf3h2.setConstIdlerGearMaterial(castIron40);
//        ykf3h2.setConstShaftSupportMaterial(bronze);
//        ykf3h2.setConstShaftMaterial(heatTreated1050);
//        ykf3h2.setConstConnectionsType(flange);
//        ykf3h2.setConstDn(dn80);
//        ykf3h2.setConstMaxPressure(maxPressure10);
//        ykf3h2.setConstConnectionsAngle(connectionsAngle90);
//        ykf3h2.setConstMaxTemperature(maxTemperature200);
//        ykf3h2.setRpmCoefficient(12.5);
//        ykf3h2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3h2);
//
//        // YKUF-2.5
//        Pump ykuf2_5h2 = new Pump();
//        ykuf2_5h2.setProducer(dreampompa);
//        ykuf2_5h2.setModelName("YKUF-2½ with Heating Jacket on Casing");
//        ykuf2_5h2.setPrice(new BigDecimal("1080.00"));
//        ykuf2_5h2.setConstPumpType(internalGearPump);
//        ykuf2_5h2.setReliefValve(false);
//        ykuf2_5h2.setHeatingJacketOnCover(false);
//        ykuf2_5h2.setHeatingJacketOnCasing(true);
//        ykuf2_5h2.setHeatingJacketOnBracket(false);
//        ykuf2_5h2.setConstCasingMaterial(castIron25);
//        ykuf2_5h2.setConstRotorGearMaterial(castIron40);
//        ykuf2_5h2.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5h2.setConstShaftSupportMaterial(bronze);
//        ykuf2_5h2.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5h2.setConstConnectionsType(flange);
//        ykuf2_5h2.setConstDn(dn80);
//        ykuf2_5h2.setConstMaxPressure(maxPressure10);
//        ykuf2_5h2.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5h2.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5h2.setRpmCoefficient(12.5);
//        ykuf2_5h2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5h2);
//////////////////////////////////////////////////////////////////////////////////////////// + H BRACKET
//        //YKF-3
//        Pump ykf3h3 = new Pump();
//        ykf3h3.setProducer(dreampompa);
//        ykf3h3.setModelName("YKF-3 with Heating Jacket on Bracket");
//        ykf3h3.setPrice(new BigDecimal("1110.00"));
//        ykf3h3.setConstPumpType(internalGearPump);
//        ykf3h3.setReliefValve(false);
//        ykf3h3.setHeatingJacketOnCover(false);
//        ykf3h3.setHeatingJacketOnCasing(false);
//        ykf3h3.setHeatingJacketOnBracket(true);
//        ykf3h3.setConstCasingMaterial(castIron25);
//        ykf3h3.setConstRotorGearMaterial(castIron40);
//        ykf3h3.setConstIdlerGearMaterial(castIron40);
//        ykf3h3.setConstShaftSupportMaterial(bronze);
//        ykf3h3.setConstShaftMaterial(heatTreated1050);
//        ykf3h3.setConstConnectionsType(flange);
//        ykf3h3.setConstDn(dn80);
//        ykf3h3.setConstMaxPressure(maxPressure10);
//        ykf3h3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3h3.setConstMaxTemperature(maxTemperature200);
//        ykf3h3.setRpmCoefficient(12.5);
//        ykf3h3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3h3);
//        // YKYF-3
//        Pump ykyf3h3 = new Pump();
//        ykyf3h3.setProducer(dreampompa);
//        ykyf3h3.setModelName("YKYF-3 with Heating Jacket on Bracket");
//        ykyf3h3.setPrice(new BigDecimal("1110.00"));
//        ykyf3h3.setConstPumpType(internalGearPump);
//        ykyf3h3.setReliefValve(false);
//        ykyf3h3.setHeatingJacketOnCover(false);
//        ykyf3h3.setHeatingJacketOnCasing(false);
//        ykyf3h3.setHeatingJacketOnBracket(true);
//        ykyf3h3.setConstCasingMaterial(castIron25);
//        ykyf3h3.setConstRotorGearMaterial(castIron40);
//        ykyf3h3.setConstIdlerGearMaterial(castIron40);
//        ykyf3h3.setConstShaftSupportMaterial(bronze);
//        ykyf3h3.setConstShaftMaterial(heatTreated1050);
//        ykyf3h3.setConstConnectionsType(flange);
//        ykyf3h3.setConstDn(dn80);
//        ykyf3h3.setConstMaxPressure(maxPressure10);
//        ykyf3h3.setConstConnectionsAngle(connectionsAngle180);
//        ykyf3h3.setConstMaxTemperature(maxTemperature200);
//        ykyf3h3.setRpmCoefficient(12.5);
//        ykyf3h3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykyf3h3);
//        // YKU-2.5
//        Pump yku2_5h3 = new Pump();
//        yku2_5h3.setProducer(dreampompa);
//        yku2_5h3.setModelName("YKF-2½ with Heating Jacket on Bracket");
//        yku2_5h3.setPrice(new BigDecimal("1050.00"));
//        yku2_5h3.setConstPumpType(internalGearPump);
//        yku2_5h3.setReliefValve(false);
//        yku2_5h3.setHeatingJacketOnCover(false);
//        yku2_5h3.setHeatingJacketOnCasing(false);
//        yku2_5h3.setHeatingJacketOnBracket(true);
//        yku2_5h3.setConstCasingMaterial(castIron25);
//        yku2_5h3.setConstRotorGearMaterial(castIron40);
//        yku2_5h3.setConstIdlerGearMaterial(castIron40);
//        yku2_5h3.setConstShaftSupportMaterial(bronze);
//        yku2_5h3.setConstShaftMaterial(heatTreated1050);
//        yku2_5h3.setConstConnectionsType(pipeToothed);
//        yku2_5h3.setConstDn(dn80);
//        yku2_5h3.setConstMaxPressure(maxPressure10);
//        yku2_5h3.setConstConnectionsAngle(connectionsAngle90);
//        yku2_5h3.setConstMaxTemperature(maxTemperature200);
//        yku2_5h3.setRpmCoefficient(12.5);
//        yku2_5h3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(yku2_5h3);
//        // YKUF-2.5
//        Pump ykuf2_5h3 = new Pump();
//        ykuf2_5h3.setProducer(dreampompa);
//        ykuf2_5h3.setModelName("YKUF-2½ with Heating Jacket on Bracket");
//        ykuf2_5h3.setPrice(new BigDecimal("1070.00"));
//        ykuf2_5h3.setConstPumpType(internalGearPump);
//        ykuf2_5h3.setReliefValve(false);
//        ykuf2_5h3.setHeatingJacketOnCover(false);
//        ykuf2_5h3.setHeatingJacketOnCasing(false);
//        ykuf2_5h3.setHeatingJacketOnBracket(true);
//        ykuf2_5h3.setConstCasingMaterial(castIron25);
//        ykuf2_5h3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5h3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5h3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5h3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5h3.setConstConnectionsType(flange);
//        ykuf2_5h3.setConstDn(dn80);
//        ykuf2_5h3.setConstMaxPressure(maxPressure10);
//        ykuf2_5h3.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5h3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5h3.setRpmCoefficient(12.5);
//        ykuf2_5h3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5h3);
//        // YKUYF-2.5
//        Pump ykuyf2_5h3 = new Pump();
//        ykuyf2_5h3.setProducer(dreampompa);
//        ykuyf2_5h3.setModelName("YKUYF-2½ with Heating Jacket on Bracket");
//        ykuyf2_5h3.setPrice(new BigDecimal("1070.00"));
//        ykuyf2_5h3.setConstPumpType(internalGearPump);
//        ykuyf2_5h3.setReliefValve(false);
//        ykuyf2_5h3.setHeatingJacketOnCover(false);
//        ykuyf2_5h3.setHeatingJacketOnCasing(false);
//        ykuyf2_5h3.setHeatingJacketOnBracket(true);
//        ykuyf2_5h3.setConstCasingMaterial(castIron25);
//        ykuyf2_5h3.setConstRotorGearMaterial(castIron40);
//        ykuyf2_5h3.setConstIdlerGearMaterial(castIron40);
//        ykuyf2_5h3.setConstShaftSupportMaterial(bronze);
//        ykuyf2_5h3.setConstShaftMaterial(heatTreated1050);
//        ykuyf2_5h3.setConstConnectionsType(flange);
//        ykuyf2_5h3.setConstDn(dn80);
//        ykuyf2_5h3.setConstMaxPressure(maxPressure10);
//        ykuyf2_5h3.setConstConnectionsAngle(connectionsAngle180);
//        ykuyf2_5h3.setConstMaxTemperature(maxTemperature200);
//        ykuyf2_5h3.setRpmCoefficient(12.5);
//        ykuyf2_5h3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuyf2_5h3);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER + CASING
//        //YKF-3
//        Pump ykf3h1_2 = new Pump();
//        ykf3h1_2.setProducer(dreampompa);
//        ykf3h1_2.setModelName("YKF-3 with Heating Jacket on Cover and Casing");
//        ykf3h1_2.setPrice(new BigDecimal("1120.00"));
//        ykf3h1_2.setConstPumpType(internalGearPump);
//        ykf3h1_2.setReliefValve(false);
//        ykf3h1_2.setHeatingJacketOnCover(true);
//        ykf3h1_2.setHeatingJacketOnCasing(true);
//        ykf3h1_2.setHeatingJacketOnBracket(false);
//        ykf3h1_2.setConstCasingMaterial(castIron25);
//        ykf3h1_2.setConstRotorGearMaterial(castIron40);
//        ykf3h1_2.setConstIdlerGearMaterial(castIron40);
//        ykf3h1_2.setConstShaftSupportMaterial(bronze);
//        ykf3h1_2.setConstShaftMaterial(heatTreated1050);
//        ykf3h1_2.setConstConnectionsType(flange);
//        ykf3h1_2.setConstDn(dn80);
//        ykf3h1_2.setConstMaxPressure(maxPressure10);
//        ykf3h1_2.setConstConnectionsAngle(connectionsAngle90);
//        ykf3h1_2.setConstMaxTemperature(maxTemperature200);
//        ykf3h1_2.setRpmCoefficient(12.5);
//        ykf3h1_2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3h1_2);
//
//        // YKUF-2.5
//        Pump ykuf2_5h1_2 = new Pump();
//        ykuf2_5h1_2.setProducer(dreampompa);
//        ykuf2_5h1_2.setModelName("YKUF-2½ with Heating Jacket on Cover and Casing");
//        ykuf2_5h1_2.setPrice(new BigDecimal("1170.00"));
//        ykuf2_5h1_2.setConstPumpType(internalGearPump);
//        ykuf2_5h1_2.setReliefValve(false);
//        ykuf2_5h1_2.setHeatingJacketOnCover(true);
//        ykuf2_5h1_2.setHeatingJacketOnCasing(true);
//        ykuf2_5h1_2.setHeatingJacketOnBracket(false);
//        ykuf2_5h1_2.setConstCasingMaterial(castIron25);
//        ykuf2_5h1_2.setConstRotorGearMaterial(castIron40);
//        ykuf2_5h1_2.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5h1_2.setConstShaftSupportMaterial(bronze);
//        ykuf2_5h1_2.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5h1_2.setConstConnectionsType(flange);
//        ykuf2_5h1_2.setConstDn(dn80);
//        ykuf2_5h1_2.setConstMaxPressure(maxPressure10);
//        ykuf2_5h1_2.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5h1_2.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5h1_2.setRpmCoefficient(12.5);
//        ykuf2_5h1_2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5h1_2);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER + BRACKET
//        //YKF-3
//        Pump ykf3h1_3 = new Pump();
//        ykf3h1_3.setProducer(dreampompa);
//        ykf3h1_3.setModelName("YKF-3 with Heating Jacket on Cover and Bracket");
//        ykf3h1_3.setPrice(new BigDecimal("1160.00"));
//        ykf3h1_3.setConstPumpType(internalGearPump);
//        ykf3h1_3.setReliefValve(false);
//        ykf3h1_3.setHeatingJacketOnCover(true);
//        ykf3h1_3.setHeatingJacketOnCasing(false);
//        ykf3h1_3.setHeatingJacketOnBracket(true);
//        ykf3h1_3.setConstCasingMaterial(castIron25);
//        ykf3h1_3.setConstRotorGearMaterial(castIron40);
//        ykf3h1_3.setConstIdlerGearMaterial(castIron40);
//        ykf3h1_3.setConstShaftSupportMaterial(bronze);
//        ykf3h1_3.setConstShaftMaterial(heatTreated1050);
//        ykf3h1_3.setConstConnectionsType(flange);
//        ykf3h1_3.setConstDn(dn80);
//        ykf3h1_3.setConstMaxPressure(maxPressure10);
//        ykf3h1_3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3h1_3.setConstMaxTemperature(maxTemperature200);
//        ykf3h1_3.setRpmCoefficient(12.5);
//        ykf3h1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3h1_3);
//        // YKYF-3
//        Pump ykyf3h1_3 = new Pump();
//        ykyf3h1_3.setProducer(dreampompa);
//        ykyf3h1_3.setModelName("YKYF-3 with Heating Jacket on Cover and Bracket");
//        ykyf3h1_3.setPrice(new BigDecimal("1180.00"));
//        ykyf3h1_3.setConstPumpType(internalGearPump);
//        ykyf3h1_3.setReliefValve(false);
//        ykyf3h1_3.setHeatingJacketOnCover(true);
//        ykyf3h1_3.setHeatingJacketOnCasing(false);
//        ykyf3h1_3.setHeatingJacketOnBracket(true);
//        ykyf3h1_3.setConstCasingMaterial(castIron25);
//        ykyf3h1_3.setConstRotorGearMaterial(castIron40);
//        ykyf3h1_3.setConstIdlerGearMaterial(castIron40);
//        ykyf3h1_3.setConstShaftSupportMaterial(bronze);
//        ykyf3h1_3.setConstShaftMaterial(heatTreated1050);
//        ykyf3h1_3.setConstConnectionsType(flange);
//        ykyf3h1_3.setConstDn(dn80);
//        ykyf3h1_3.setConstMaxPressure(maxPressure10);
//        ykyf3h1_3.setConstConnectionsAngle(connectionsAngle180);
//        ykyf3h1_3.setConstMaxTemperature(maxTemperature200);
//        ykyf3h1_3.setRpmCoefficient(12.5);
//        ykyf3h1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykyf3h1_3);
//        // YKU-2.5
//        Pump yku2_5h1_3 = new Pump();
//        yku2_5h1_3.setProducer(dreampompa);
//        yku2_5h1_3.setModelName("YKF-2½ with Heating Jacket on Cover and Bracket");
//        yku2_5h1_3.setPrice(new BigDecimal("1100.00"));
//        yku2_5h1_3.setConstPumpType(internalGearPump);
//        yku2_5h1_3.setReliefValve(false);
//        yku2_5h1_3.setHeatingJacketOnCover(true);
//        yku2_5h1_3.setHeatingJacketOnCasing(false);
//        yku2_5h1_3.setHeatingJacketOnBracket(true);
//        yku2_5h1_3.setConstCasingMaterial(castIron25);
//        yku2_5h1_3.setConstRotorGearMaterial(castIron40);
//        yku2_5h1_3.setConstIdlerGearMaterial(castIron40);
//        yku2_5h1_3.setConstShaftSupportMaterial(bronze);
//        yku2_5h1_3.setConstShaftMaterial(heatTreated1050);
//        yku2_5h1_3.setConstConnectionsType(pipeToothed);
//        yku2_5h1_3.setConstDn(dn80);
//        yku2_5h1_3.setConstMaxPressure(maxPressure10);
//        yku2_5h1_3.setConstConnectionsAngle(connectionsAngle90);
//        yku2_5h1_3.setConstMaxTemperature(maxTemperature200);
//        yku2_5h1_3.setRpmCoefficient(12.5);
//        yku2_5h1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(yku2_5h1_3);
//        // YKUF-2.5
//        Pump ykuf2_5h1_3 = new Pump();
//        ykuf2_5h1_3.setProducer(dreampompa);
//        ykuf2_5h1_3.setModelName("YKUF-2½ with Heating Jacket on Cover and Bracket");
//        ykuf2_5h1_3.setPrice(new BigDecimal("1120.00"));
//        ykuf2_5h1_3.setConstPumpType(internalGearPump);
//        ykuf2_5h1_3.setReliefValve(false);
//        ykuf2_5h1_3.setHeatingJacketOnCover(true);
//        ykuf2_5h1_3.setHeatingJacketOnCasing(false);
//        ykuf2_5h1_3.setHeatingJacketOnBracket(true);
//        ykuf2_5h1_3.setConstCasingMaterial(castIron25);
//        ykuf2_5h1_3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5h1_3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5h1_3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5h1_3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5h1_3.setConstConnectionsType(flange);
//        ykuf2_5h1_3.setConstDn(dn80);
//        ykuf2_5h1_3.setConstMaxPressure(maxPressure10);
//        ykuf2_5h1_3.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5h1_3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5h1_3.setRpmCoefficient(12.5);
//        ykuf2_5h1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5h1_3);
//        // YKUYF-2.5
//        Pump ykuyf2_5h1_3 = new Pump();
//        ykuyf2_5h1_3.setProducer(dreampompa);
//        ykuyf2_5h1_3.setModelName("YKUYF-2½ with Heating Jacket on Cover and Bracket");
//        ykuyf2_5h1_3.setPrice(new BigDecimal("1120.00"));
//        ykuyf2_5h1_3.setConstPumpType(internalGearPump);
//        ykuyf2_5h1_3.setReliefValve(false);
//        ykuyf2_5h1_3.setHeatingJacketOnCover(true);
//        ykuyf2_5h1_3.setHeatingJacketOnCasing(false);
//        ykuyf2_5h1_3.setHeatingJacketOnBracket(true);
//        ykuyf2_5h1_3.setConstCasingMaterial(castIron25);
//        ykuyf2_5h1_3.setConstRotorGearMaterial(castIron40);
//        ykuyf2_5h1_3.setConstIdlerGearMaterial(castIron40);
//        ykuyf2_5h1_3.setConstShaftSupportMaterial(bronze);
//        ykuyf2_5h1_3.setConstShaftMaterial(heatTreated1050);
//        ykuyf2_5h1_3.setConstConnectionsType(flange);
//        ykuyf2_5h1_3.setConstDn(dn80);
//        ykuyf2_5h1_3.setConstMaxPressure(maxPressure10);
//        ykuyf2_5h1_3.setConstConnectionsAngle(connectionsAngle180);
//        ykuyf2_5h1_3.setConstMaxTemperature(maxTemperature200);
//        ykuyf2_5h1_3.setRpmCoefficient(12.5);
//        ykuyf2_5h1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuyf2_5h1_3);
//////////////////////////////////////////////////////////////////////////////////////////// + H CASING + BRACKET
//        //YKF-3
//        Pump ykf3h2_3 = new Pump();
//        ykf3h2_3.setProducer(dreampompa);
//        ykf3h2_3.setModelName("YKF-3 with Heating Jacket on Casing and Bracket");
//        ykf3h2_3.setPrice(new BigDecimal("1210.00"));
//        ykf3h2_3.setConstPumpType(internalGearPump);
//        ykf3h2_3.setReliefValve(false);
//        ykf3h2_3.setHeatingJacketOnCover(false);
//        ykf3h2_3.setHeatingJacketOnCasing(true);
//        ykf3h2_3.setHeatingJacketOnBracket(true);
//        ykf3h2_3.setConstCasingMaterial(castIron25);
//        ykf3h2_3.setConstRotorGearMaterial(castIron40);
//        ykf3h2_3.setConstIdlerGearMaterial(castIron40);
//        ykf3h2_3.setConstShaftSupportMaterial(bronze);
//        ykf3h2_3.setConstShaftMaterial(heatTreated1050);
//        ykf3h2_3.setConstConnectionsType(flange);
//        ykf3h2_3.setConstDn(dn80);
//        ykf3h2_3.setConstMaxPressure(maxPressure10);
//        ykf3h2_3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3h2_3.setConstMaxTemperature(maxTemperature200);
//        ykf3h2_3.setRpmCoefficient(12.5);
//        ykf3h2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3h2_3);
//
//        // YKUF-2.5
//        Pump ykuf2_5h2_3 = new Pump();
//        ykuf2_5h2_3.setProducer(dreampompa);
//        ykuf2_5h2_3.setModelName("YKUF-2½ with Heating Jacket on Casing and Bracket");
//        ykuf2_5h2_3.setPrice(new BigDecimal("1170.00"));
//        ykuf2_5h2_3.setConstPumpType(internalGearPump);
//        ykuf2_5h2_3.setReliefValve(false);
//        ykuf2_5h2_3.setHeatingJacketOnCover(false);
//        ykuf2_5h2_3.setHeatingJacketOnCasing(true);
//        ykuf2_5h2_3.setHeatingJacketOnBracket(true);
//        ykuf2_5h2_3.setConstCasingMaterial(castIron25);
//        ykuf2_5h2_3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5h2_3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5h2_3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5h2_3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5h2_3.setConstConnectionsType(flange);
//        ykuf2_5h2_3.setConstDn(dn80);
//        ykuf2_5h2_3.setConstMaxPressure(maxPressure10);
//        ykuf2_5h2_3.setConstConnectionsAngle(connectionsAngle180);
//        ykuf2_5h2_3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5h2_3.setRpmCoefficient(12.5);
//        ykuf2_5h2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5h2_3);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER + CASING + BRACKET
//        //YKF-3
//        Pump ykf3h1_2_3 = new Pump();
//        ykf3h1_2_3.setProducer(dreampompa);
//        ykf3h1_2_3.setModelName("YKF-3 with Heating Jacket on Cover, Casing and Bracket");
//        ykf3h1_2_3.setPrice(new BigDecimal("1210.00"));
//        ykf3h1_2_3.setConstPumpType(internalGearPump);
//        ykf3h1_2_3.setReliefValve(false);
//        ykf3h1_2_3.setHeatingJacketOnCover(true);
//        ykf3h1_2_3.setHeatingJacketOnCasing(true);
//        ykf3h1_2_3.setHeatingJacketOnBracket(true);
//        ykf3h1_2_3.setConstCasingMaterial(castIron25);
//        ykf3h1_2_3.setConstRotorGearMaterial(castIron40);
//        ykf3h1_2_3.setConstIdlerGearMaterial(castIron40);
//        ykf3h1_2_3.setConstShaftSupportMaterial(bronze);
//        ykf3h1_2_3.setConstShaftMaterial(heatTreated1050);
//        ykf3h1_2_3.setConstConnectionsType(flange);
//        ykf3h1_2_3.setConstDn(dn80);
//        ykf3h1_2_3.setConstMaxPressure(maxPressure10);
//        ykf3h1_2_3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3h1_2_3.setConstMaxTemperature(maxTemperature200);
//        ykf3h1_2_3.setRpmCoefficient(12.5);
//        ykf3h1_2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3h1_2_3);
//
//        // YKUF-2.5
//        Pump ykuf2_5h1_2_3 = new Pump();
//        ykuf2_5h1_2_3.setProducer(dreampompa);
//        ykuf2_5h1_2_3.setModelName("YKUF-2½ with Heating Jacket on Cover, Casing and Bracket");
//        ykuf2_5h1_2_3.setPrice(new BigDecimal("1260.00"));
//        ykuf2_5h1_2_3.setConstPumpType(internalGearPump);
//        ykuf2_5h1_2_3.setReliefValve(false);
//        ykuf2_5h1_2_3.setHeatingJacketOnCover(true);
//        ykuf2_5h1_2_3.setHeatingJacketOnCasing(true);
//        ykuf2_5h1_2_3.setHeatingJacketOnBracket(true);
//        ykuf2_5h1_2_3.setConstCasingMaterial(castIron25);
//        ykuf2_5h1_2_3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5h1_2_3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5h1_2_3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5h1_2_3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5h1_2_3.setConstConnectionsType(flange);
//        ykuf2_5h1_2_3.setConstDn(dn80);
//        ykuf2_5h1_2_3.setConstMaxPressure(maxPressure10);
//        ykuf2_5h1_2_3.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5h1_2_3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5h1_2_3.setRpmCoefficient(12.5);
//        ykuf2_5h1_2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5h1_2_3);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER + VALVE
//        //YKF-3
//        Pump ykfv3h1 = new Pump();
//        ykfv3h1.setProducer(dreampompa);
//        ykfv3h1.setModelName("YKF-3 with Relief Valve and Heating Jacket on Cover");
//        ykfv3h1.setPrice(new BigDecimal("1230.00"));
//        ykfv3h1.setConstPumpType(internalGearPump);
//        ykfv3h1.setReliefValve(true);
//        ykfv3h1.setHeatingJacketOnCover(true);
//        ykfv3h1.setHeatingJacketOnCasing(false);
//        ykfv3h1.setHeatingJacketOnBracket(false);
//        ykfv3h1.setConstCasingMaterial(castIron25);
//        ykfv3h1.setConstRotorGearMaterial(castIron40);
//        ykfv3h1.setConstIdlerGearMaterial(castIron40);
//        ykfv3h1.setConstShaftSupportMaterial(bronze);
//        ykfv3h1.setConstShaftMaterial(heatTreated1050);
//        ykfv3h1.setConstConnectionsType(flange);
//        ykfv3h1.setConstDn(dn80);
//        ykfv3h1.setConstMaxPressure(maxPressure10);
//        ykfv3h1.setConstConnectionsAngle(connectionsAngle90);
//        ykfv3h1.setConstMaxTemperature(maxTemperature200);
//        ykfv3h1.setRpmCoefficient(12.5);
//        ykfv3h1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykfv3h1);
//        // YKYF-3
//        Pump ykyf3vh1 = new Pump();
//        ykyf3vh1.setProducer(dreampompa);
//        ykyf3vh1.setModelName("YKYF-3 with Relief Valve and Heating Jacket on Cover");
//        ykyf3vh1.setPrice(new BigDecimal("1250.00"));
//        ykyf3vh1.setConstPumpType(internalGearPump);
//        ykyf3vh1.setReliefValve(true);
//        ykyf3vh1.setHeatingJacketOnCover(true);
//        ykyf3vh1.setHeatingJacketOnCasing(false);
//        ykyf3vh1.setHeatingJacketOnBracket(false);
//        ykyf3vh1.setConstCasingMaterial(castIron25);
//        ykyf3vh1.setConstRotorGearMaterial(castIron40);
//        ykyf3vh1.setConstIdlerGearMaterial(castIron40);
//        ykyf3vh1.setConstShaftSupportMaterial(bronze);
//        ykyf3vh1.setConstShaftMaterial(heatTreated1050);
//        ykyf3vh1.setConstConnectionsType(flange);
//        ykyf3vh1.setConstDn(dn80);
//        ykyf3vh1.setConstMaxPressure(maxPressure10);
//        ykyf3vh1.setConstConnectionsAngle(connectionsAngle180);
//        ykyf3vh1.setConstMaxTemperature(maxTemperature200);
//        ykyf3vh1.setRpmCoefficient(12.5);
//        ykyf3vh1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykyf3vh1);
//        // YKU-2.5
//        Pump yku2_5vh1 = new Pump();
//        yku2_5vh1.setProducer(dreampompa);
//        yku2_5vh1.setModelName("YKF-2½ with Relief Valve and Heating Jacket on Cover");
//        yku2_5vh1.setPrice(new BigDecimal("1170.00"));
//        yku2_5vh1.setConstPumpType(internalGearPump);
//        yku2_5vh1.setReliefValve(true);
//        yku2_5vh1.setHeatingJacketOnCover(true);
//        yku2_5vh1.setHeatingJacketOnCasing(false);
//        yku2_5vh1.setHeatingJacketOnBracket(false);
//        yku2_5vh1.setConstCasingMaterial(castIron25);
//        yku2_5vh1.setConstRotorGearMaterial(castIron40);
//        yku2_5vh1.setConstIdlerGearMaterial(castIron40);
//        yku2_5vh1.setConstShaftSupportMaterial(bronze);
//        yku2_5vh1.setConstShaftMaterial(heatTreated1050);
//        yku2_5vh1.setConstConnectionsType(pipeToothed);
//        yku2_5vh1.setConstDn(dn80);
//        yku2_5vh1.setConstMaxPressure(maxPressure10);
//        yku2_5vh1.setConstConnectionsAngle(connectionsAngle90);
//        yku2_5vh1.setConstMaxTemperature(maxTemperature200);
//        yku2_5vh1.setRpmCoefficient(12.5);
//        yku2_5vh1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(yku2_5vh1);
//        // YKUF-2.5
//        Pump ykuf2_5vh1 = new Pump();
//        ykuf2_5vh1.setProducer(dreampompa);
//        ykuf2_5vh1.setModelName("YKUF-2½ with Relief Valve and Heating Jacket on Cover");
//        ykuf2_5vh1.setPrice(new BigDecimal("1190.00"));
//        ykuf2_5vh1.setConstPumpType(internalGearPump);
//        ykuf2_5vh1.setReliefValve(true);
//        ykuf2_5vh1.setHeatingJacketOnCover(true);
//        ykuf2_5vh1.setHeatingJacketOnCasing(false);
//        ykuf2_5vh1.setHeatingJacketOnBracket(false);
//        ykuf2_5vh1.setConstCasingMaterial(castIron25);
//        ykuf2_5vh1.setConstRotorGearMaterial(castIron40);
//        ykuf2_5vh1.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5vh1.setConstShaftSupportMaterial(bronze);
//        ykuf2_5vh1.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5vh1.setConstConnectionsType(flange);
//        ykuf2_5vh1.setConstDn(dn80);
//        ykuf2_5vh1.setConstMaxPressure(maxPressure10);
//        ykuf2_5vh1.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5vh1.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5vh1.setRpmCoefficient(12.5);
//        ykuf2_5vh1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5vh1);
//        // YKUYF-2.5
//        Pump ykuyf2_5vh1 = new Pump();
//        ykuyf2_5vh1.setProducer(dreampompa);
//        ykuyf2_5vh1.setModelName("YKUYF-2½ with Relief Valve and Heating Jacket on Cover");
//        ykuyf2_5vh1.setPrice(new BigDecimal("1190.00"));
//        ykuyf2_5vh1.setConstPumpType(internalGearPump);
//        ykuyf2_5vh1.setReliefValve(true);
//        ykuyf2_5vh1.setHeatingJacketOnCover(true);
//        ykuyf2_5vh1.setHeatingJacketOnCasing(false);
//        ykuyf2_5vh1.setHeatingJacketOnBracket(false);
//        ykuyf2_5vh1.setConstCasingMaterial(castIron25);
//        ykuyf2_5vh1.setConstRotorGearMaterial(castIron40);
//        ykuyf2_5vh1.setConstIdlerGearMaterial(castIron40);
//        ykuyf2_5vh1.setConstShaftSupportMaterial(bronze);
//        ykuyf2_5vh1.setConstShaftMaterial(heatTreated1050);
//        ykuyf2_5vh1.setConstConnectionsType(flange);
//        ykuyf2_5vh1.setConstDn(dn80);
//        ykuyf2_5vh1.setConstMaxPressure(maxPressure10);
//        ykuyf2_5vh1.setConstConnectionsAngle(connectionsAngle180);
//        ykuyf2_5vh1.setConstMaxTemperature(maxTemperature200);
//        ykuyf2_5vh1.setRpmCoefficient(12.5);
//        ykuyf2_5vh1.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuyf2_5vh1);
//////////////////////////////////////////////////////////////////////////////////////////// + H CASING + VALVE
//        //YKF-3
//        Pump ykf3vh2 = new Pump();
//        ykf3vh2.setProducer(dreampompa);
//        ykf3vh2.setModelName("YKF-3 with Relief Valve and Heating Jacket on Casing");
//        ykf3vh2.setPrice(new BigDecimal("1280.00"));
//        ykf3vh2.setConstPumpType(internalGearPump);
//        ykf3vh2.setReliefValve(true);
//        ykf3vh2.setHeatingJacketOnCover(false);
//        ykf3vh2.setHeatingJacketOnCasing(true);
//        ykf3vh2.setHeatingJacketOnBracket(false);
//        ykf3vh2.setConstCasingMaterial(castIron25);
//        ykf3vh2.setConstRotorGearMaterial(castIron40);
//        ykf3vh2.setConstIdlerGearMaterial(castIron40);
//        ykf3vh2.setConstShaftSupportMaterial(bronze);
//        ykf3vh2.setConstShaftMaterial(heatTreated1050);
//        ykf3vh2.setConstConnectionsType(flange);
//        ykf3vh2.setConstDn(dn80);
//        ykf3vh2.setConstMaxPressure(maxPressure10);
//        ykf3vh2.setConstConnectionsAngle(connectionsAngle90);
//        ykf3vh2.setConstMaxTemperature(maxTemperature200);
//        ykf3vh2.setRpmCoefficient(12.5);
//        ykf3vh2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3vh2);
//
//        // YKUF-2.5
//        Pump ykuf2_5vh2 = new Pump();
//        ykuf2_5vh2.setProducer(dreampompa);
//        ykuf2_5vh2.setModelName("YKUF-2½ with Relief Valve and Heating Jacket on Casing");
//        ykuf2_5vh2.setPrice(new BigDecimal("1240.00"));
//        ykuf2_5vh2.setConstPumpType(internalGearPump);
//        ykuf2_5vh2.setReliefValve(true);
//        ykuf2_5vh2.setHeatingJacketOnCover(false);
//        ykuf2_5vh2.setHeatingJacketOnCasing(true);
//        ykuf2_5vh2.setHeatingJacketOnBracket(false);
//        ykuf2_5vh2.setConstCasingMaterial(castIron25);
//        ykuf2_5vh2.setConstRotorGearMaterial(castIron40);
//        ykuf2_5vh2.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5vh2.setConstShaftSupportMaterial(bronze);
//        ykuf2_5vh2.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5vh2.setConstConnectionsType(flange);
//        ykuf2_5vh2.setConstDn(dn80);
//        ykuf2_5vh2.setConstMaxPressure(maxPressure10);
//        ykuf2_5vh2.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5vh2.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5vh2.setRpmCoefficient(12.5);
//        ykuf2_5vh2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5vh2);
//////////////////////////////////////////////////////////////////////////////////////////// + H BRACKET + VALVE
//        //YKF-3
//        Pump ykf3vh3 = new Pump();
//        ykf3vh3.setProducer(dreampompa);
//        ykf3vh3.setModelName("YKF-3 with Relief Valve and Heating Jacket on Bracket");
//        ykf3vh3.setPrice(new BigDecimal("1270.00"));
//        ykf3vh3.setConstPumpType(internalGearPump);
//        ykf3vh3.setReliefValve(true);
//        ykf3vh3.setHeatingJacketOnCover(false);
//        ykf3vh3.setHeatingJacketOnCasing(false);
//        ykf3vh3.setHeatingJacketOnBracket(true);
//        ykf3vh3.setConstCasingMaterial(castIron25);
//        ykf3vh3.setConstRotorGearMaterial(castIron40);
//        ykf3vh3.setConstIdlerGearMaterial(castIron40);
//        ykf3vh3.setConstShaftSupportMaterial(bronze);
//        ykf3vh3.setConstShaftMaterial(heatTreated1050);
//        ykf3vh3.setConstConnectionsType(flange);
//        ykf3vh3.setConstDn(dn80);
//        ykf3vh3.setConstMaxPressure(maxPressure10);
//        ykf3vh3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3vh3.setConstMaxTemperature(maxTemperature200);
//        ykf3vh3.setRpmCoefficient(12.5);
//        ykf3vh3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3vh3);
//        // YKYF-3
//        Pump ykyf3vh3 = new Pump();
//        ykyf3vh3.setProducer(dreampompa);
//        ykyf3vh3.setModelName("YKYF-3 with Relief Valve and Heating Jacket on Bracket");
//        ykyf3vh3.setPrice(new BigDecimal("1270.00"));
//        ykyf3vh3.setConstPumpType(internalGearPump);
//        ykyf3vh3.setReliefValve(true);
//        ykyf3vh3.setHeatingJacketOnCover(false);
//        ykyf3vh3.setHeatingJacketOnCasing(false);
//        ykyf3vh3.setHeatingJacketOnBracket(true);
//        ykyf3vh3.setConstCasingMaterial(castIron25);
//        ykyf3vh3.setConstRotorGearMaterial(castIron40);
//        ykyf3vh3.setConstIdlerGearMaterial(castIron40);
//        ykyf3vh3.setConstShaftSupportMaterial(bronze);
//        ykyf3vh3.setConstShaftMaterial(heatTreated1050);
//        ykyf3vh3.setConstConnectionsType(flange);
//        ykyf3vh3.setConstDn(dn80);
//        ykyf3vh3.setConstMaxPressure(maxPressure10);
//        ykyf3vh3.setConstConnectionsAngle(connectionsAngle180);
//        ykyf3vh3.setConstMaxTemperature(maxTemperature200);
//        ykyf3vh3.setRpmCoefficient(12.5);
//        ykyf3vh3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykyf3vh3);
//        // YKU-2.5
//        Pump yku2_5vh3 = new Pump();
//        yku2_5vh3.setProducer(dreampompa);
//        yku2_5vh3.setModelName("YKF-2½ with Relief Valve and Heating Jacket on Bracket");
//        yku2_5vh3.setPrice(new BigDecimal("1210.00"));
//        yku2_5vh3.setConstPumpType(internalGearPump);
//        yku2_5vh3.setReliefValve(true);
//        yku2_5vh3.setHeatingJacketOnCover(false);
//        yku2_5vh3.setHeatingJacketOnCasing(false);
//        yku2_5vh3.setHeatingJacketOnBracket(true);
//        yku2_5vh3.setConstCasingMaterial(castIron25);
//        yku2_5vh3.setConstRotorGearMaterial(castIron40);
//        yku2_5vh3.setConstIdlerGearMaterial(castIron40);
//        yku2_5vh3.setConstShaftSupportMaterial(bronze);
//        yku2_5vh3.setConstShaftMaterial(heatTreated1050);
//        yku2_5vh3.setConstConnectionsType(pipeToothed);
//        yku2_5vh3.setConstDn(dn80);
//        yku2_5vh3.setConstMaxPressure(maxPressure10);
//        yku2_5vh3.setConstConnectionsAngle(connectionsAngle90);
//        yku2_5vh3.setConstMaxTemperature(maxTemperature200);
//        yku2_5vh3.setRpmCoefficient(12.5);
//        yku2_5vh3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(yku2_5vh3);
//        // YKUF-2.5
//        Pump ykuf2_5vh3 = new Pump();
//        ykuf2_5vh3.setProducer(dreampompa);
//        ykuf2_5vh3.setModelName("YKUF-2½ with Relief Valve and Heating Jacket on Bracket");
//        ykuf2_5vh3.setPrice(new BigDecimal("1230.00"));
//        ykuf2_5vh3.setConstPumpType(internalGearPump);
//        ykuf2_5vh3.setReliefValve(true);
//        ykuf2_5vh3.setHeatingJacketOnCover(false);
//        ykuf2_5vh3.setHeatingJacketOnCasing(false);
//        ykuf2_5vh3.setHeatingJacketOnBracket(true);
//        ykuf2_5vh3.setConstCasingMaterial(castIron25);
//        ykuf2_5vh3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5vh3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5vh3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5vh3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5vh3.setConstConnectionsType(flange);
//        ykuf2_5vh3.setConstDn(dn80);
//        ykuf2_5vh3.setConstMaxPressure(maxPressure10);
//        ykuf2_5vh3.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5vh3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5vh3.setRpmCoefficient(12.5);
//        ykuf2_5vh3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5vh3);
//        // YKUYF-2.5
//        Pump ykuyf2_5vh3 = new Pump();
//        ykuyf2_5vh3.setProducer(dreampompa);
//        ykuyf2_5vh3.setModelName("YKUYF-2½ with Relief Valve and Heating Jacket on Bracket");
//        ykuyf2_5vh3.setPrice(new BigDecimal("1230.00"));
//        ykuyf2_5vh3.setConstPumpType(internalGearPump);
//        ykuyf2_5vh3.setReliefValve(true);
//        ykuyf2_5vh3.setHeatingJacketOnCover(false);
//        ykuyf2_5vh3.setHeatingJacketOnCasing(false);
//        ykuyf2_5vh3.setHeatingJacketOnBracket(true);
//        ykuyf2_5vh3.setConstCasingMaterial(castIron25);
//        ykuyf2_5vh3.setConstRotorGearMaterial(castIron40);
//        ykuyf2_5vh3.setConstIdlerGearMaterial(castIron40);
//        ykuyf2_5vh3.setConstShaftSupportMaterial(bronze);
//        ykuyf2_5vh3.setConstShaftMaterial(heatTreated1050);
//        ykuyf2_5vh3.setConstConnectionsType(flange);
//        ykuyf2_5vh3.setConstDn(dn80);
//        ykuyf2_5vh3.setConstMaxPressure(maxPressure10);
//        ykuyf2_5vh3.setConstConnectionsAngle(connectionsAngle180);
//        ykuyf2_5vh3.setConstMaxTemperature(maxTemperature200);
//        ykuyf2_5vh3.setRpmCoefficient(12.5);
//        ykuyf2_5vh3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuyf2_5vh3);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER + CASING + VALVE
//        //YKF-3
//        Pump ykf3vh1_2 = new Pump();
//        ykf3vh1_2.setProducer(dreampompa);
//        ykf3vh1_2.setModelName("YKF-3 with Relief Valve and Heating Jacket on Cover and Casing");
//        ykf3vh1_2.setPrice(new BigDecimal("1280.00"));
//        ykf3vh1_2.setConstPumpType(internalGearPump);
//        ykf3vh1_2.setReliefValve(true);
//        ykf3vh1_2.setHeatingJacketOnCover(true);
//        ykf3vh1_2.setHeatingJacketOnCasing(true);
//        ykf3vh1_2.setHeatingJacketOnBracket(false);
//        ykf3vh1_2.setConstCasingMaterial(castIron25);
//        ykf3vh1_2.setConstRotorGearMaterial(castIron40);
//        ykf3vh1_2.setConstIdlerGearMaterial(castIron40);
//        ykf3vh1_2.setConstShaftSupportMaterial(bronze);
//        ykf3vh1_2.setConstShaftMaterial(heatTreated1050);
//        ykf3vh1_2.setConstConnectionsType(flange);
//        ykf3vh1_2.setConstDn(dn80);
//        ykf3vh1_2.setConstMaxPressure(maxPressure10);
//        ykf3vh1_2.setConstConnectionsAngle(connectionsAngle90);
//        ykf3vh1_2.setConstMaxTemperature(maxTemperature200);
//        ykf3vh1_2.setRpmCoefficient(12.5);
//        ykf3vh1_2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3vh1_2);
//
//        // YKUF-2.5
//        Pump ykuf2_5vh1_2 = new Pump();
//        ykuf2_5vh1_2.setProducer(dreampompa);
//        ykuf2_5vh1_2.setModelName("YKUF-2½ with Relief Valve and Heating Jacket on Cover and Casing");
//        ykuf2_5vh1_2.setPrice(new BigDecimal("1330.00"));
//        ykuf2_5vh1_2.setConstPumpType(internalGearPump);
//        ykuf2_5vh1_2.setReliefValve(true);
//        ykuf2_5vh1_2.setHeatingJacketOnCover(true);
//        ykuf2_5vh1_2.setHeatingJacketOnCasing(true);
//        ykuf2_5vh1_2.setHeatingJacketOnBracket(false);
//        ykuf2_5vh1_2.setConstCasingMaterial(castIron25);
//        ykuf2_5vh1_2.setConstRotorGearMaterial(castIron40);
//        ykuf2_5vh1_2.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5vh1_2.setConstShaftSupportMaterial(bronze);
//        ykuf2_5vh1_2.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5vh1_2.setConstConnectionsType(flange);
//        ykuf2_5vh1_2.setConstDn(dn80);
//        ykuf2_5vh1_2.setConstMaxPressure(maxPressure10);
//        ykuf2_5vh1_2.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5vh1_2.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5vh1_2.setRpmCoefficient(12.5);
//        ykuf2_5vh1_2.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5vh1_2);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER + BRACKET + VALVE
//        //YKF-3
//        Pump ykf3vh1_3 = new Pump();
//        ykf3vh1_3.setProducer(dreampompa);
//        ykf3vh1_3.setModelName("YKF-3 with Relief Valve and Heating Jacket on Cover and Bracket");
//        ykf3vh1_3.setPrice(new BigDecimal("1320.00"));
//        ykf3vh1_3.setConstPumpType(internalGearPump);
//        ykf3vh1_3.setReliefValve(true);
//        ykf3vh1_3.setHeatingJacketOnCover(true);
//        ykf3vh1_3.setHeatingJacketOnCasing(false);
//        ykf3vh1_3.setHeatingJacketOnBracket(true);
//        ykf3vh1_3.setConstCasingMaterial(castIron25);
//        ykf3vh1_3.setConstRotorGearMaterial(castIron40);
//        ykf3vh1_3.setConstIdlerGearMaterial(castIron40);
//        ykf3vh1_3.setConstShaftSupportMaterial(bronze);
//        ykf3vh1_3.setConstShaftMaterial(heatTreated1050);
//        ykf3vh1_3.setConstConnectionsType(flange);
//        ykf3vh1_3.setConstDn(dn80);
//        ykf3vh1_3.setConstMaxPressure(maxPressure10);
//        ykf3vh1_3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3vh1_3.setConstMaxTemperature(maxTemperature200);
//        ykf3vh1_3.setRpmCoefficient(12.5);
//        ykf3vh1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3vh1_3);
//        // YKYF-3
//        Pump ykyf3vh1_3 = new Pump();
//        ykyf3vh1_3.setProducer(dreampompa);
//        ykyf3vh1_3.setModelName("YKYF-3 with Relief Valve and Heating Jacket on Cover and Bracket");
//        ykyf3vh1_3.setPrice(new BigDecimal("1340.00"));
//        ykyf3vh1_3.setConstPumpType(internalGearPump);
//        ykyf3vh1_3.setReliefValve(true);
//        ykyf3vh1_3.setHeatingJacketOnCover(true);
//        ykyf3vh1_3.setHeatingJacketOnCasing(false);
//        ykyf3vh1_3.setHeatingJacketOnBracket(true);
//        ykyf3vh1_3.setConstCasingMaterial(castIron25);
//        ykyf3vh1_3.setConstRotorGearMaterial(castIron40);
//        ykyf3vh1_3.setConstIdlerGearMaterial(castIron40);
//        ykyf3vh1_3.setConstShaftSupportMaterial(bronze);
//        ykyf3vh1_3.setConstShaftMaterial(heatTreated1050);
//        ykyf3vh1_3.setConstConnectionsType(flange);
//        ykyf3vh1_3.setConstDn(dn80);
//        ykyf3vh1_3.setConstMaxPressure(maxPressure10);
//        ykyf3vh1_3.setConstConnectionsAngle(connectionsAngle180);
//        ykyf3vh1_3.setConstMaxTemperature(maxTemperature200);
//        ykyf3vh1_3.setRpmCoefficient(12.5);
//        ykyf3vh1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykyf3vh1_3);
//        // YKU-2.5
//        Pump yku2_5vh1_3 = new Pump();
//        yku2_5vh1_3.setProducer(dreampompa);
//        yku2_5vh1_3.setModelName("YKF-2½ with Relief Valve and Heating Jacket on Cover and Bracket");
//        yku2_5vh1_3.setPrice(new BigDecimal("1260.00"));
//        yku2_5vh1_3.setConstPumpType(internalGearPump);
//        yku2_5vh1_3.setReliefValve(true);
//        yku2_5vh1_3.setHeatingJacketOnCover(true);
//        yku2_5vh1_3.setHeatingJacketOnCasing(false);
//        yku2_5vh1_3.setHeatingJacketOnBracket(true);
//        yku2_5vh1_3.setConstCasingMaterial(castIron25);
//        yku2_5vh1_3.setConstRotorGearMaterial(castIron40);
//        yku2_5vh1_3.setConstIdlerGearMaterial(castIron40);
//        yku2_5vh1_3.setConstShaftSupportMaterial(bronze);
//        yku2_5vh1_3.setConstShaftMaterial(heatTreated1050);
//        yku2_5vh1_3.setConstConnectionsType(pipeToothed);
//        yku2_5vh1_3.setConstDn(dn80);
//        yku2_5vh1_3.setConstMaxPressure(maxPressure10);
//        yku2_5vh1_3.setConstConnectionsAngle(connectionsAngle90);
//        yku2_5vh1_3.setConstMaxTemperature(maxTemperature200);
//        yku2_5vh1_3.setRpmCoefficient(12.5);
//        yku2_5vh1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(yku2_5vh1_3);
//        // YKUF-2.5
//        Pump ykuf2_5vh1_3 = new Pump();
//        ykuf2_5vh1_3.setProducer(dreampompa);
//        ykuf2_5vh1_3.setModelName("YKUF-2½ with Relief Valve and Heating Jacket on Cover and Bracket");
//        ykuf2_5vh1_3.setPrice(new BigDecimal("1280.00"));
//        ykuf2_5vh1_3.setConstPumpType(internalGearPump);
//        ykuf2_5vh1_3.setReliefValve(true);
//        ykuf2_5vh1_3.setHeatingJacketOnCover(true);
//        ykuf2_5vh1_3.setHeatingJacketOnCasing(false);
//        ykuf2_5vh1_3.setHeatingJacketOnBracket(true);
//        ykuf2_5vh1_3.setConstCasingMaterial(castIron25);
//        ykuf2_5vh1_3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5vh1_3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5vh1_3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5vh1_3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5vh1_3.setConstConnectionsType(flange);
//        ykuf2_5vh1_3.setConstDn(dn80);
//        ykuf2_5vh1_3.setConstMaxPressure(maxPressure10);
//        ykuf2_5vh1_3.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5vh1_3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5vh1_3.setRpmCoefficient(12.5);
//        ykuf2_5vh1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5vh1_3);
//        // YKUYF-2.5
//        Pump ykuyf2_5vh1_3 = new Pump();
//        ykuyf2_5vh1_3.setProducer(dreampompa);
//        ykuyf2_5vh1_3.setModelName("YKUYF-2½ with Relief Valve and Heating Jacket on Cover and Bracket");
//        ykuyf2_5vh1_3.setPrice(new BigDecimal("1280.00"));
//        ykuyf2_5vh1_3.setConstPumpType(internalGearPump);
//        ykuyf2_5vh1_3.setReliefValve(true);
//        ykuyf2_5vh1_3.setHeatingJacketOnCover(true);
//        ykuyf2_5vh1_3.setHeatingJacketOnCasing(false);
//        ykuyf2_5vh1_3.setHeatingJacketOnBracket(true);
//        ykuyf2_5vh1_3.setConstCasingMaterial(castIron25);
//        ykuyf2_5vh1_3.setConstRotorGearMaterial(castIron40);
//        ykuyf2_5vh1_3.setConstIdlerGearMaterial(castIron40);
//        ykuyf2_5vh1_3.setConstShaftSupportMaterial(bronze);
//        ykuyf2_5vh1_3.setConstShaftMaterial(heatTreated1050);
//        ykuyf2_5vh1_3.setConstConnectionsType(flange);
//        ykuyf2_5vh1_3.setConstDn(dn80);
//        ykuyf2_5vh1_3.setConstMaxPressure(maxPressure10);
//        ykuyf2_5vh1_3.setConstConnectionsAngle(connectionsAngle180);
//        ykuyf2_5vh1_3.setConstMaxTemperature(maxTemperature200);
//        ykuyf2_5vh1_3.setRpmCoefficient(12.5);
//        ykuyf2_5vh1_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuyf2_5vh1_3);
//////////////////////////////////////////////////////////////////////////////////////////// + H CASING + BRACKET + VALVE
//        //YKF-3
//        Pump ykf3hv2_3 = new Pump();
//        ykf3hv2_3.setProducer(dreampompa);
//        ykf3hv2_3.setModelName("YKF-3 with Relief Valve and Heating Jacket on Casing and Bracket");
//        ykf3hv2_3.setPrice(new BigDecimal("1370.00"));
//        ykf3hv2_3.setConstPumpType(internalGearPump);
//        ykf3hv2_3.setReliefValve(true);
//        ykf3hv2_3.setHeatingJacketOnCover(false);
//        ykf3hv2_3.setHeatingJacketOnCasing(true);
//        ykf3hv2_3.setHeatingJacketOnBracket(true);
//        ykf3hv2_3.setConstCasingMaterial(castIron25);
//        ykf3hv2_3.setConstRotorGearMaterial(castIron40);
//        ykf3hv2_3.setConstIdlerGearMaterial(castIron40);
//        ykf3hv2_3.setConstShaftSupportMaterial(bronze);
//        ykf3hv2_3.setConstShaftMaterial(heatTreated1050);
//        ykf3hv2_3.setConstConnectionsType(flange);
//        ykf3hv2_3.setConstDn(dn80);
//        ykf3hv2_3.setConstMaxPressure(maxPressure10);
//        ykf3hv2_3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3hv2_3.setConstMaxTemperature(maxTemperature200);
//        ykf3hv2_3.setRpmCoefficient(12.5);
//        ykf3hv2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3hv2_3);
//
//        // YKUF-2.5
//        Pump ykuf2_5vh2_3 = new Pump();
//        ykuf2_5vh2_3.setProducer(dreampompa);
//        ykuf2_5vh2_3.setModelName("YKUF-2½ with Relief Valve and Heating Jacket on Casing and Bracket");
//        ykuf2_5vh2_3.setPrice(new BigDecimal("1330.00"));
//        ykuf2_5vh2_3.setConstPumpType(internalGearPump);
//        ykuf2_5vh2_3.setReliefValve(true);
//        ykuf2_5vh2_3.setHeatingJacketOnCover(false);
//        ykuf2_5vh2_3.setHeatingJacketOnCasing(true);
//        ykuf2_5vh2_3.setHeatingJacketOnBracket(true);
//        ykuf2_5vh2_3.setConstCasingMaterial(castIron25);
//        ykuf2_5vh2_3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5vh2_3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5vh2_3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5vh2_3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5vh2_3.setConstConnectionsType(flange);
//        ykuf2_5vh2_3.setConstDn(dn80);
//        ykuf2_5vh2_3.setConstMaxPressure(maxPressure10);
//        ykuf2_5vh2_3.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5vh2_3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5vh2_3.setRpmCoefficient(12.5);
//        ykuf2_5vh2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5vh2_3);
//////////////////////////////////////////////////////////////////////////////////////////// + H COVER + CASING + BRACKET + VALVE
//        //YKF-3
//        Pump ykf3vh1_2_3 = new Pump();
//        ykf3vh1_2_3.setProducer(dreampompa);
//        ykf3vh1_2_3.setModelName("YKF-3 with Relief Valve and Heating Jacket on Cover, Casing and Bracket");
//        ykf3vh1_2_3.setPrice(new BigDecimal("1370.00"));
//        ykf3vh1_2_3.setConstPumpType(internalGearPump);
//        ykf3vh1_2_3.setReliefValve(true);
//        ykf3vh1_2_3.setHeatingJacketOnCover(true);
//        ykf3vh1_2_3.setHeatingJacketOnCasing(true);
//        ykf3vh1_2_3.setHeatingJacketOnBracket(true);
//        ykf3vh1_2_3.setConstCasingMaterial(castIron25);
//        ykf3vh1_2_3.setConstRotorGearMaterial(castIron40);
//        ykf3vh1_2_3.setConstIdlerGearMaterial(castIron40);
//        ykf3vh1_2_3.setConstShaftSupportMaterial(bronze);
//        ykf3vh1_2_3.setConstShaftMaterial(heatTreated1050);
//        ykf3vh1_2_3.setConstConnectionsType(flange);
//        ykf3vh1_2_3.setConstDn(dn80);
//        ykf3vh1_2_3.setConstMaxPressure(maxPressure10);
//        ykf3vh1_2_3.setConstConnectionsAngle(connectionsAngle90);
//        ykf3vh1_2_3.setConstMaxTemperature(maxTemperature200);
//        ykf3vh1_2_3.setRpmCoefficient(12.5);
//        ykf3vh1_2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykf3vh1_2_3);
//
//        // YKUF-2.5
//        Pump ykuf2_5vh1_2_3 = new Pump();
//        ykuf2_5vh1_2_3.setProducer(dreampompa);
//        ykuf2_5vh1_2_3.setModelName("YKUF-2½ with Relief Valve and Heating Jacket on Cover, Casing and Bracket");
//        ykuf2_5vh1_2_3.setPrice(new BigDecimal("1420.00"));
//        ykuf2_5vh1_2_3.setConstPumpType(internalGearPump);
//        ykuf2_5vh1_2_3.setReliefValve(true);
//        ykuf2_5vh1_2_3.setHeatingJacketOnCover(true);
//        ykuf2_5vh1_2_3.setHeatingJacketOnCasing(true);
//        ykuf2_5vh1_2_3.setHeatingJacketOnBracket(true);
//        ykuf2_5vh1_2_3.setConstCasingMaterial(castIron25);
//        ykuf2_5vh1_2_3.setConstRotorGearMaterial(castIron40);
//        ykuf2_5vh1_2_3.setConstIdlerGearMaterial(castIron40);
//        ykuf2_5vh1_2_3.setConstShaftSupportMaterial(bronze);
//        ykuf2_5vh1_2_3.setConstShaftMaterial(heatTreated1050);
//        ykuf2_5vh1_2_3.setConstConnectionsType(flange);
//        ykuf2_5vh1_2_3.setConstDn(dn80);
//        ykuf2_5vh1_2_3.setConstMaxPressure(maxPressure10);
//        ykuf2_5vh1_2_3.setConstConnectionsAngle(connectionsAngle90);
//        ykuf2_5vh1_2_3.setConstMaxTemperature(maxTemperature200);
//        ykuf2_5vh1_2_3.setRpmCoefficient(12.5);
//        ykuf2_5vh1_2_3.setSpeedCorrectionCoefficients(speedCorrectionCoefficients);
//        pumpRepository.save(ykuf2_5vh1_2_3);


        /**
         * PUMPS SET - YKF-3
         */
        Set<Pump> pumpsSetYKF = new HashSet<>();
        pumpsSetYKF.add(ykf3);
        pumpsSetYKF.add(ykyf3);
        pumpsSetYKF.add(yku2_5);
        pumpsSetYKF.add(ykuf2_5);
        pumpsSetYKF.add(ykuyf2_5);
        pumpsSetYKF.add(ykf3v);
//        pumpsSetYKF.add(ykyf3v);
//        pumpsSetYKF.add(yku2_5v);
//        pumpsSetYKF.add(ykuf2_5v);
//        pumpsSetYKF.add(ykuyf2_5v);
//        pumpsSetYKF.add(ykf3h1);
//        pumpsSetYKF.add(ykyf3h1);
//        pumpsSetYKF.add(yku2_5h1);
//        pumpsSetYKF.add(ykuf2_5h1);
//        pumpsSetYKF.add(ykuyf2_5h1);
//        pumpsSetYKF.add(ykf3h2);
//        pumpsSetYKF.add(ykuf2_5h2);
//        pumpsSetYKF.add(ykf3h3);
//        pumpsSetYKF.add(ykyf3h3);
//        pumpsSetYKF.add(yku2_5h3);
//        pumpsSetYKF.add(ykuf2_5h3);
//        pumpsSetYKF.add(ykuyf2_5h3);
//        pumpsSetYKF.add(ykf3h1_2);
//        pumpsSetYKF.add(ykuf2_5h1_2);
//        pumpsSetYKF.add(ykf3h1_3);
//        pumpsSetYKF.add(ykyf3h1_3);
//        pumpsSetYKF.add(yku2_5h1_3);
//        pumpsSetYKF.add(ykuf2_5h1_3);
//        pumpsSetYKF.add(ykuyf2_5h1_3);
//        pumpsSetYKF.add(ykf3h2_3);
//        pumpsSetYKF.add(ykuf2_5h2_3);
//        pumpsSetYKF.add(ykf3h1_2_3);
//        pumpsSetYKF.add(ykuf2_5h1_2_3);
//        pumpsSetYKF.add(ykfv3h1);
//        pumpsSetYKF.add(ykyf3vh1);
//        pumpsSetYKF.add(yku2_5vh1);
//        pumpsSetYKF.add(ykuf2_5vh1);
//        pumpsSetYKF.add(ykuyf2_5vh1);
//        pumpsSetYKF.add(ykf3vh2);
//        pumpsSetYKF.add(ykuf2_5vh2);
//        pumpsSetYKF.add(ykf3vh3);
//        pumpsSetYKF.add(ykyf3vh3);
//        pumpsSetYKF.add(yku2_5vh3);
//        pumpsSetYKF.add(ykuf2_5vh3);
//        pumpsSetYKF.add(ykuyf2_5vh3);
//        pumpsSetYKF.add(ykf3vh1_2);
//        pumpsSetYKF.add(ykuf2_5vh1_2);
//        pumpsSetYKF.add(ykf3vh1_3);
//        pumpsSetYKF.add(ykyf3vh1_3);
//        pumpsSetYKF.add(yku2_5vh1_3);
//        pumpsSetYKF.add(ykuf2_5vh1_3);
//        pumpsSetYKF.add(ykuyf2_5vh1_3);
//        pumpsSetYKF.add(ykf3hv2_3);
//        pumpsSetYKF.add(ykuf2_5vh2_3);
//        pumpsSetYKF.add(ykf3vh1_2_3);
//        pumpsSetYKF.add(ykuf2_5vh1_2_3);


        /**
         * SEALS - YKF-3
         */
        Seal seaYkf3Packing = new Seal(dreampompa, "YKF-3 packing", new BigDecimal("0"), sealTypePacking, oRingMaterialNone, pumpsSetYKF);
        sealRepository.save(seaYkf3Packing);
        Seal seaYkf3Lip = new Seal(dreampompa, "YKF-3 lip seal", new BigDecimal("0"), sealTypeLip, oRingMaterialNone, pumpsSetYKF);
        sealRepository.save(seaYkf3Lip);
        Seal seaYkf3MechanicalDreampompa = new Seal(dreampompa, "YKF-3 mechanical seal", new BigDecimal("200"), sealTypeMechanical, oRingMaterialViton, pumpsSetYKF);
        sealRepository.save(seaYkf3MechanicalDreampompa);
        Seal seaYkf3MechanicalBurgmann = new Seal(eagleBurgmann, "YKF-3 mechanical seal", new BigDecimal("360"), sealTypeMechanical, oRingMaterialViton, pumpsSetYKF);
        sealRepository.save(seaYkf3MechanicalBurgmann);
        Seal seaYkf3Crtex = new Seal(dreampompa, "YKF-3 Cartridge mechanical seal", new BigDecimal("900.2"), sealTypeCartridgeMechanical, oRingMaterialViton, pumpsSetYKF);
        sealRepository.save(seaYkf3Crtex);

        /**
         * DRIVER ASSEMBLY TYPES
         */
        Constant adder = new Constant(DBConst.DRIVER_ASSEMBLY_TYPE, "Pump Adder");
        constantRepository.save(adder);
        Constant coupling = new Constant(DBConst.DRIVER_ASSEMBLY_TYPE, "Coupling");
        constantRepository.save(coupling);
        Constant exProofCoupling = new Constant(DBConst.DRIVER_ASSEMBLY_TYPE, "Ex.Proof Coupling");
        constantRepository.save(exProofCoupling);
        Constant belt = new Constant(DBConst.DRIVER_ASSEMBLY_TYPE, "Belt and Pulley");
        constantRepository.save(belt);
        Constant flex = new Constant(DBConst.DRIVER_ASSEMBLY_TYPE, "Flexible Coupling");
        constantRepository.save(flex);

        /**
         * EX PROOF TYPES
         */
        Constant atex = new Constant(DBConst.EXPLOSION_PROOF, "ATEX");
        constantRepository.save(atex);
        Constant none = new Constant(DBConst.EXPLOSION_PROOF, "none");
        constantRepository.save(none);

        /**
         * DRIVER ASSEMBLIES
         */
        DriverAssembly ykf3assembly01 = new DriverAssembly(dreampompa, "ykf-3 pump adder", new BigDecimal("420"),
                adder, atex, pumpsSetYKF);
        driverAssemblyRepository.save(ykf3assembly01);
        DriverAssembly ykf3assembly02 = new DriverAssembly(dreampompa, "ykf-3 ex. proof coupling", new BigDecimal("180"),
                coupling, atex, pumpsSetYKF);
        driverAssemblyRepository.save(ykf3assembly02);
        DriverAssembly ykf3assembly03 = new DriverAssembly(dreampompa, "ykf-3 belt and pulley", new BigDecimal("300"),
                belt, none, pumpsSetYKF);
        driverAssemblyRepository.save(ykf3assembly03);
        DriverAssembly ykf3assembly04 = new DriverAssembly(dreampompa, "ykf-3 flexible coupling", new BigDecimal("240"),
                flex, none, pumpsSetYKF);
        driverAssemblyRepository.save(ykf3assembly04);
        DriverAssembly ykf3assembly05 = new DriverAssembly(dreampompa, "ykf-3 coupling", new BigDecimal("0"),
                flex, none, pumpsSetYKF);
        driverAssemblyRepository.save(ykf3assembly05);


        /**
         * FRAMES
         */
        Frame frame01 = new Frame(dreampompa, "YKF-3 frame", new BigDecimal("0"), pumpsSetYKF);
        frameRepository.save(frame01);

        /**
         * MOTOR POWERS
         */
        Constant motorPower5_5 = new Constant(DBConst.MOTOR_POWER, "5.5");
        constantRepository.save(motorPower5_5);
        Constant motorPower7_5 = new Constant(DBConst.MOTOR_POWER, "7.5");
        constantRepository.save(motorPower7_5);
        Constant motorPower10 = new Constant(DBConst.MOTOR_POWER, "10");
        constantRepository.save(motorPower10);
        Constant motorPower15 = new Constant(DBConst.MOTOR_POWER, "15");
        constantRepository.save(motorPower15);
        Constant motorPower20 = new Constant(DBConst.MOTOR_POWER, "20");
        constantRepository.save(motorPower20);

        /**
         * MOTOR FRAME SIZES
         */
        Constant motorFrame112 = new Constant(DBConst.MOTOR_FRAME_SIZE, "112");
        constantRepository.save(motorFrame112);
        Constant motorFrame132 = new Constant(DBConst.MOTOR_FRAME_SIZE, "132");
        constantRepository.save(motorFrame132);
        Constant motorFrame160 = new Constant(DBConst.MOTOR_FRAME_SIZE, "160");
        constantRepository.save(motorFrame160);

        /**
         * REDUCERS
         */
        Reducer reducer01 = new Reducer(iMak, "IRAM62/112M", new BigDecimal("660"), dreampompa, 87, 480,
                none, motorPower5_5, motorFrame112);
        reducerRepository.save(reducer01);
        Reducer reducer02 = new Reducer(iMak, "IRAM62/C112M", new BigDecimal("730"), dreampompa, 210, 450,
                none, motorPower7_5, motorFrame112);
        reducerRepository.save(reducer02);
        Reducer reducer03 = new Reducer(iMak, "IRAM72/132S", new BigDecimal("990"), dreampompa, 75, 210,
                none, motorPower7_5, motorFrame132);
        reducerRepository.save(reducer03);
        Reducer reducer04 = new Reducer(iMak, "IRAM72/132M", new BigDecimal("1070"), dreampompa, 93, 450,
                none, motorPower10, motorFrame132);
        reducerRepository.save(reducer04);
        Reducer reducer05 = new Reducer(iMak, "IRAM72/C132M", new BigDecimal("1190"), dreampompa, 200, 450,
                none, motorPower15, motorFrame132);
        reducerRepository.save(reducer05);
        Reducer reducer06 = new Reducer(iMak, "IRAM82/160L", new BigDecimal("1910"), dreampompa, 130, 450,
                none, motorPower20, motorFrame160);
        reducerRepository.save(reducer06);

        /**
         * MOTOR SPEED TYPES
         */
        Constant motorSpeed1500 = new Constant(DBConst.MOTOR_SPEED, "1500");
        constantRepository.save(motorSpeed1500);

        /**
         * MOTORS
         */
        Motor motor01 = new Motor(turkishMotor, "turkish motor 5.5 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
                none, motorPower5_5, motorFrame112);
        motorRepository.save(motor01);
        Motor motor02 = new Motor(turkishMotor, "turkish motor 7.5 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
                none, motorPower7_5, motorFrame112);
        motorRepository.save(motor02);
        Motor motor02a = new Motor(turkishMotor, "turkish motor 7.5 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
                none, motorPower7_5, motorFrame132);
        motorRepository.save(motor02a);
        Motor motor03 = new Motor(turkishMotor, "turkish motor 10 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
                none, motorPower10, motorFrame132);
        motorRepository.save(motor03);
        Motor motor04 = new Motor(turkishMotor, "turkish motor 15 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
                none, motorPower15, motorFrame132);
        motorRepository.save(motor04);
        Motor motor05 = new Motor(turkishMotor, "turkish motor 20 HP", new BigDecimal("0"), dreampompa, motorSpeed1500,
                none, motorPower20, motorFrame160);
        motorRepository.save(motor05);
        // ABB
        Motor motor01abb = new Motor(abb, "ABB motor 5.5 HP", new BigDecimal("160"), dreampompa, motorSpeed1500,
                none, motorPower5_5, motorFrame112);
        motorRepository.save(motor01abb);
        Motor motor02abb = new Motor(abb, "ABB motor 7.5 HP", new BigDecimal("200"), dreampompa, motorSpeed1500,
                none, motorPower7_5, motorFrame132);
        motorRepository.save(motor02abb);
        Motor motor03abb = new Motor(abb, "ABB motor 10 HP", new BigDecimal("290"), dreampompa, motorSpeed1500,
                none, motorPower10, motorFrame132);
        motorRepository.save(motor03abb);
        Motor motor05abb = new Motor(abb, "ABB motor 20 HP", new BigDecimal("430"), dreampompa, motorSpeed1500,
                none, motorPower20, motorFrame160);
        motorRepository.save(motor05abb);
        // ATEX ABB
        Motor motor01abbAtex = new Motor(abb, "ABB motor 5.5 HP, ATEX", new BigDecimal("1000"), dreampompa, motorSpeed1500,
                atex, motorPower5_5, motorFrame112);
        motorRepository.save(motor01abbAtex);
        Motor motor02abbAtex = new Motor(abb, "ABB motor 7.5 HP, ATEX", new BigDecimal("1140"), dreampompa, motorSpeed1500,
                atex, motorPower7_5, motorFrame132);
        motorRepository.save(motor02abbAtex);
        Motor motor03abbAtex = new Motor(abb, "ABB motor 10 HP, ATEX", new BigDecimal("1380"), dreampompa, motorSpeed1500,
                atex, motorPower10, motorFrame132);
        motorRepository.save(motor03abbAtex);
        Motor motor05abbAtex = new Motor(abb, "ABB motor 20 HP, ATEX", new BigDecimal("1910"), dreampompa, motorSpeed1500,
                atex, motorPower20, motorFrame160);
        motorRepository.save(motor05abbAtex);


        return "OK";
    }
}
