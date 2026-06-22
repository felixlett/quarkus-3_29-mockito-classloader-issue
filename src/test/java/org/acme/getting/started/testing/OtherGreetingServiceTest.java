package org.acme.getting.started.testing;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@QuarkusComponentTest
public class OtherGreetingServiceTest {

    @Inject
    OtherGreetingService service;

    @InjectMock
    GreetingSubService subService;

    @Test
    public void testGreetingService() {
        when(subService.greet("hello there!")).thenThrow(GreetingException.class);
        assertThrows(GreetingException.class, service::greeting);
    }
}
