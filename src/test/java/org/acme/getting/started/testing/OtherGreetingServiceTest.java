package org.acme.getting.started.testing;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        try {
            subService.greet("hello there!");
        } catch (Exception e) {
            // This assertion does not work starting with Quarkus 3.29
            assertEquals(GreetingException.class.getClassLoader(), e.getClass().getClassLoader());
        }
        assertThrows(GreetingException.class, service::greeting);
    }
}
