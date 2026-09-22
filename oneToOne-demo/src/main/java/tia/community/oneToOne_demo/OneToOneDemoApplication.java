package tia.community.oneToOne_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import tia.community.oneToOne_demo.dao.ClientDao;
import tia.community.oneToOne_demo.dao.ProfileDao;
import tia.community.oneToOne_demo.entity.Client;
import tia.community.oneToOne_demo.entity.Profile;

import java.util.UUID;

@SpringBootApplication
public class OneToOneDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc_Container = SpringApplication.run(OneToOneDemoApplication.class, args);

		ClientDao clientDao = ioc_Container.getBean(ClientDao.class);
		ProfileDao profileDao = ioc_Container.getBean(ProfileDao.class);

		Client client = Client.builder()
				.ref(UUID.randomUUID().toString())
				.username("3IA")
				.lastname("Community")
				.email("3ia.community@gmail.com")
				.password("1234")
				.build();

		Client clientInDB = clientDao.save(client);

		Profile profile= Profile.builder()
				.ref(UUID.randomUUID().toString())
				.phone("737373737")
				.avatarUrl("https://3ia-academy.s3.eu-north-1.amazonaws.com/logos/logo-3ia-community.png")
				.bio("3IA Community is a coding community")
				.adresse("Marrakech, Morocco")
				.ville("Marrakech")
				.client(clientInDB)
				.build();

		profileDao.save(profile);


//		 clientDao.deleteById("f4bae3d3-14e1-4ebf-bf16-ef05cce379c9");
	}
}
