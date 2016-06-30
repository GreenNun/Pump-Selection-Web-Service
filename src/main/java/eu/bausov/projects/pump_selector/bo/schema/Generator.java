package eu.bausov.projects.pump_selector.bo.schema;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class Generator {
    public static void main(String[] args) {
        try {
            Resource resource = new FileSystemResource("src/main/resources/hibernate.cfg.xml");

            Configuration configuration = new Configuration().configure(resource.getURL());
            configuration.setNamingStrategy(ImprovedNamingStrategy.INSTANCE);

            SchemaExport schema = new SchemaExport(configuration);
            schema.setOutputFile("schema_ddl.sql");
            schema.setDelimiter(";\n");
            schema.create(true, false);

        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
