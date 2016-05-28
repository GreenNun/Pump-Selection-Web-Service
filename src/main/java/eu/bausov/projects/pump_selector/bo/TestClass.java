package eu.bausov.projects.pump_selector.bo;

/**
 * Created by Stanislav Bausov on 23.05.2016.
 */
public class TestClass {
    public static void main(String[] args) {
        InternalGearPump pump = new InternalGearPump();
        pump.bushingMaterial = null;
        pump.producer.producerName = null;

        PumpAggregate pumpAggregate = new PumpAggregate();
        pumpAggregate.pump = new InternalGearPump();
    }
}
