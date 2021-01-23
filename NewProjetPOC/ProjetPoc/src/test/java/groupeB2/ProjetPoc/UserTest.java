package groupeB2.ProjetPoc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.User;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class UserTest {
		
	@Test
	public void testAddProjetToUser() {
		
		Projet projet2 = new Projet();
		User user = new User();
		user.addProjet(projet2);
		
		//Assert.assertEquals(1, user.getProjets().size());
		
	}
	
}
