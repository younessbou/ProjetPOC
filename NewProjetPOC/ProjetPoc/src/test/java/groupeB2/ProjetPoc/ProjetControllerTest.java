package groupeB2.ProjetPoc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import groupeB2.ProjetPoc.dao.AdminRepository;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.dao.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
public class ProjetControllerTest extends ControllerTest{

    @Test
	public void testGetProjets() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/projets")
				.contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("$[0].nom", is("POCb")));
			   
    }

}
