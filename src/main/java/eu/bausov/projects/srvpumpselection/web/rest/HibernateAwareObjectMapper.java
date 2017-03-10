package eu.bausov.projects.srvpumpselection.web.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        super();

        Hibernate5Module hm = new Hibernate5Module();
        hm.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);

        registerModule(hm);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //Enable JaxB annotation support
        registerModule(new JaxbAnnotationModule());
        //Do not send "null" values
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
