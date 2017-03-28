package eu.bausov.projects.srvpumpselection.web;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.annotation.XmlRootElement;

public class HibernateJaxb2Marshaller extends Jaxb2Marshaller {

    @Override
    public boolean supports(Class clazz) {
        return super.supports(clazz) || AnnotationUtils.findAnnotation(clazz, XmlRootElement.class) != null;
    }
}
