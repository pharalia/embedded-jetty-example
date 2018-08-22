package uk.co.michaeloldroyd;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        loadProperties();
        Server server = new Server(Integer.parseInt(getProperty("server.port", "9000")));

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setResourceBase("src/main/resources");
        webAppContext.setContextPath(getProperty("server.path", "/"));
        webAppContext.setConfigurations(new Configuration[] { new AnnotationConfiguration() });
        webAppContext.setParentLoaderPriority(true);
        webAppContext.getMetaData().addContainerResource(new PathResource(new File("./target/classes").toURI()));

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }

    private static void loadProperties() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(
                System.getProperty(
                        "server.properties.location",
                        "classpath:/server.properties")
        );
        System.getProperties().load(resource.getInputStream());
    }

    private static String getProperty(String key, String defaultValue) {
        return System.getProperty(key, defaultValue);
    }
}
