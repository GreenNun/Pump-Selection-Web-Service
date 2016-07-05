package eu.bausov.projects.pump_selector.bo.schema;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;
import eu.bausov.projects.pump_selector.bo.SpeedCorrectionCoefficient;
import eu.bausov.projects.pump_selector.bo.equipment.DriverAssembly;
import eu.bausov.projects.pump_selector.bo.equipment.Pump;
import eu.bausov.projects.pump_selector.bo.equipment.Seal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class PumpsGenerator {
    public static void main1(String[] args) {
        /* Producers */
        Producer dreampompa = new Producer();
        dreampompa.setProducerName("Dreampompa"); // producer
        dreampompa.setProducerCountry(new Constant("country", "Wonderland")); // country

        Producer eagleBurgmann = new Producer();
        eagleBurgmann.setProducerName("Eagle Burgmann"); // producer
        eagleBurgmann.setProducerCountry(new Constant("country", "Germany")); // country

        /* Pump */
//        private Constant constPumpType;
        Constant internalGearPump = new Constant("pump type", "Internal Eccentric Gear Pump"); // pumpType

//        private Seal seal;
        Constant sealTypePacking = new Constant("sealType", "Packing");
        Constant sealTypeLip = new Constant("sealType", "Lip Seal");
        Constant sealTypeMechanical = new Constant("sealType", "Mechanical Seal");
        Constant oRingMaterialNone = new Constant("o-ring material", "none");
        Constant oRingMaterialViton = new Constant("o-ring material", "Viton&reg;");
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

        /**
         * YKF-3
         */
        Pump ykf3 = new Pump();
        ykf3.setProducer(dreampompa);
        ykf3.setModelName("YKF-3");
        ykf3.setPrice(new BigDecimal("1020.00"));
        ykf3.setConstPumpType(internalGearPump);
        ykf3.setReliefValve(false);
        ykf3.setHeatingJacketOnCover(false);
        ykf3.setHeatingJacketOnCasting(false);
        ykf3.setHeatingJacketOnBracket(false);
        Seal seal = new Seal(dreampompa, "YKF-3 packing", new BigDecimal("0"), sealTypePacking, oRingMaterialNone);
        ykf3.setSeal(seal);
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
        Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients = new HashSet<>();
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(38, 60));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(100, 63));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(750, 30));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(2500, 17));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(7500, 10));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(25000, 5));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(75000, 13));
        speedCorrectionCoefficients.add(new SpeedCorrectionCoefficient(250000, 1));


        /*
         * DriverAssembly
         *
         */
        DriverAssembly ykf3assembly01 = new DriverAssembly(dreampompa, "ykf-3 pump adder", new BigDecimal("420"),
                new Constant("driver assembly type", "Pump Adder"), new Constant("explosion proof", "ATEX"), ykf3);
        DriverAssembly ykf3assembly02 = new DriverAssembly(dreampompa, "ykf-3 ex. proof coupling", new BigDecimal("180"),
                new Constant("driver assembly type", "Coupling"), new Constant("explosion proof", "ATEX"), ykf3);
        DriverAssembly ykf3assembly03 = new DriverAssembly(dreampompa, "ykf-3 belt and pulley", new BigDecimal("300"),
                new Constant("driver assembly type", "Belt and Pulley"), new Constant("explosion proof", "none"), ykf3);
        DriverAssembly ykf3assembly04 = new DriverAssembly(dreampompa, "ykf-3 flexible coupling", new BigDecimal("240"),
                new Constant("driver assembly type", "Flexible Coupling"), new Constant("explosion proof", "none"), ykf3);
    }


}
