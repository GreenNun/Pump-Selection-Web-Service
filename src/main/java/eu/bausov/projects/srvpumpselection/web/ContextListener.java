package eu.bausov.projects.srvpumpselection.web;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextListener implements ServletContextListener {

    private ContextLoaderListener contextLoaderListener;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        contextLoaderListener = new ContextLoaderListener();
        contextLoaderListener.contextInitialized(servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        contextLoaderListener.contextDestroyed(servletContextEvent);
    }
}
