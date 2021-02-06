package groupeB2.ProjetPoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.User;

@SpringBootTest(classes=User.class)
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")

public class UserTest {
		
	

	
}
