package eu.bausov.projects.srvpumpselection.bo.schema;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import eu.bausov.projects.srvpumpselection.bo.SpeedCorrectionCoefficient;
import eu.bausov.projects.srvpumpselection.bo.User;
import eu.bausov.projects.srvpumpselection.bo.equipment.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

public class Generator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Generator.class);

    public static void main(String[] args) {
        MetadataSources metadata = new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .applySetting("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect")
//                        .applySetting("javax.persistence.schema-generation-connection", "jdbc:postgresql://localhost:5432/postgres")
//                        .applySetting("hibernate.connection.URL", "jdbc:postgresql://localhost:5432/postgres")
                        .build()
        );

        metadata.addAnnotatedClass(Constant.class);
        metadata.addAnnotatedClass(Producer.class);
        metadata.addAnnotatedClass(SpeedCorrectionCoefficient.class);
        metadata.addAnnotatedClass(DriverAssembly.class);
        metadata.addAnnotatedClass(Equipment.class);
        metadata.addAnnotatedClass(Frame.class);
        metadata.addAnnotatedClass(Pump.class);
        metadata.addAnnotatedClass(Motor.class);
        metadata.addAnnotatedClass(PumpAggregate.class);
        metadata.addAnnotatedClass(Reducer.class);
        metadata.addAnnotatedClass(Seal.class);
        metadata.addAnnotatedClass(User.class);

        SchemaExport export = new SchemaExport();
        export.setOutputFile("schema_ddl.sql");
        export.setDelimiter(";");
        export.create(EnumSet.of(TargetType.SCRIPT), metadata.buildMetadata());

        LOGGER.info("Schema export finished");
    }
}