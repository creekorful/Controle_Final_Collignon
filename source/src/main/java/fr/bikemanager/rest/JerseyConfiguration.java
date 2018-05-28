package fr.bikemanager.rest;

import fr.bikemanager.filter.AuthenticationFilter;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

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
        register(EngineResource.class);
        register(MotorcycleResource.class);
        register(SessionResource.class);
        register(DatabaseResource.class);

        // Filters
        register(AuthenticationFilter.class);
    }
}