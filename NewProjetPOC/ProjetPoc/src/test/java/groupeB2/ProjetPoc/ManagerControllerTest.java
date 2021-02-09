package groupeB2.ProjetPoc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Iterator;
import java.util.List;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import groupeB2.ProjetPoc.dao.AdminRepository;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
public class ManagerControllerTest extends ControllerTest{
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
			
			mvc.perform(MockMvcRequestBuilders.get("/managers")
					.contentType(MediaType.APPLICATION_JSON))
				    .andExpect(status().isOk())
				    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				    .andExpect(jsonPath("$[0].nom", is("mana1")))
				    .andExpect(jsonPath("$[0].prenom", is("aze")))   
				    ;
		}
	    
	    @Test
		public void managerAdduser() throws Exception {
			String Json="{\"nom\":\"test\",\"prenom\":\"tost\",\"password\":\"tr\",\"login\":\"eeee\"}";
			mvc.perform(post("/managers_user/1")
					.contentType(MediaType.APPLICATION_JSON).content(Json))				
				    .andExpect(status().isOk())
				    ;
			List<User> users=this.userRepository.findAll();
			Iterator<User> it = users.iterator();
			it.next();
			User user2=it.next();

			String nom="test";
			
			Assert.assertEquals(nom, user2.getNom());
		}
}
