package org.acme.getting.started.testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OtherGreetingService {

    @Inject
    GreetingSubService greetingSubService;

    public String greeting() {
        return greetingSubService.greet("hello there!");
    }

}