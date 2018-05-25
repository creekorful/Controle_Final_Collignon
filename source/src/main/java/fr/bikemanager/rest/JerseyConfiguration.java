package fr.bikemanager.rest;

import fr.bikemanager.rest.impl.DatabaseResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import fr.bikemanager.rest.impl.MotorcycleResourceImpl;
import fr.bikemanager.rest.impl.SessionResourceImpl;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("api")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {

    }

    @PostConstruct
    public void setup() {

        // Rest resources
        register(MotorcycleResourceImpl.class);
        register(SessionResourceImpl.class);
        register(DatabaseResourceImpl.class);
    }
}