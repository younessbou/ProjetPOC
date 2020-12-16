package org.rygn.kanban;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class ActuatorTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }

    /**
     * Test for home page.
     *
     * @throws Exception On failure.
     */
    @Test
    public void actuator()
            throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/actuator")).andExpect(MockMvcResultMatchers.status().isOk());
        this.mvc.perform(MockMvcRequestBuilders.get("/actuator/info")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
