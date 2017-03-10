package eu.bausov.projects.srvpumpselection.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by GreenNun on 10.03.17.
 */
public class AppInitializer implements WebApplicationInitializer {
    private final Logger LOGGER = LoggerFactory.getLogger(AppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.debug("AppInitializer starts...");

        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(0);
        dispatcher.addMapping("api/*");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("eu.bausov.projects.srvpumpselection.config");
        return context;
    }

}
