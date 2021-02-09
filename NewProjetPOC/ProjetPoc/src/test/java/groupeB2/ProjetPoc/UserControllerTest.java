package groupeB2.ProjetPoc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import groupeB2.ProjetPoc.dao.AdminRepository;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.domain.User;
import groupeB2.ProjetPoc.domain.Projet;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
public class UserControllerTest extends ControllerTest{


	
	    @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private ManagerRepository managerRepository;
	    @Autowired
	    private AdminRepository adminRepository;
	    @Autowired 
	    private ProjetRepository projetRepository;
	    
		@Test
		public void testGetUsers() throws Exception {
			
			mvc.perform(MockMvcRequestBuilders.get("/users")
					.contentType(MediaType.APPLICATION_JSON))
				    .andExpect(status().isOk())
				    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				    .andExpect(jsonPath("$[0].nom", is("rfrf")))
				    .andExpect(jsonPath("$[0].prenom", is("frrz")))
				    .andExpect(jsonPath("$[0].login", is("fr")))
				    .andExpect(jsonPath("$[0].password", is("azeza")))
				    ;

		}
		@Test
		public void testPostTimeUsers() throws Exception {
			String Json="{\"id\":2,\"nbhours\":65}";
			User user=this.userRepository.findAll().iterator().next();
			
			Projet projet=new Projet();
			projet.setNom("test");
			projet.addUser(user);
			projetRepository.save(projet);
			userRepository.save(user);
			
			ObjectMapper mapper = new ObjectMapper();
			mvc.perform(post("/users_time/1")
					.contentType(MediaType.APPLICATION_JSON).content(Json))				
				    .andExpect(status().isOk())
				    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				    ;
			User user2=this.userRepository.findAll().iterator().next();
			Assert.assertEquals(1, user2.getTempss().size());

		}
}
