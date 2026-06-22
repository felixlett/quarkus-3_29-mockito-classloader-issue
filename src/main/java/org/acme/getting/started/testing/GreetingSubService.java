package org.acme.getting.started.testing;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingSubService {

    public String greet(String greeting) {
        return greeting;
    }
}
