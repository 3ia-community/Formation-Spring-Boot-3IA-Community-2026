package tia.community.oneToOne_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import tia.community.oneToOne_demo.dao.CategoryDao;
import tia.community.oneToOne_demo.dao.ClientDao;
import tia.community.oneToOne_demo.dao.CommandDao;
import tia.community.oneToOne_demo.dao.ProduitDao;
import tia.community.oneToOne_demo.entity.*;
import tia.community.oneToOne_demo.service.facade.ClientService;
import tia.community.oneToOne_demo.service.facade.ProduitService;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class OneToOneDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc_Container = SpringApplication.run(OneToOneDemoApplication.class, args);
	}

//	@Bean
	public CommandLineRunner saveProduitAndCategory(ProduitDao produitDao, CategoryDao categoryDao) {

		return args -> {
			Category electronic = Category.builder()
					.ref(UUID.randomUUID().toString())
					.name("Electronic")
					.imageUrl("https://3ia-academy.s3.eu-north-1.amazonaws.com/logos/images/electronics.jpg")
					.description("This category is for electronic product")
					.build();

			Category clothing = Category.builder()
					.ref(UUID.randomUUID().toString())
					.name("Clothing")
					.imageUrl("https://3ia-academy.s3.eu-north-1.amazonaws.com/logos/images/Clothing.jpg")
					.description("This category is for clothing product")
					.build();

//			Category electronicInDB = categoryDao.save(electronic);
//			Category clothingInDb = categoryDao.save(clothing);

			Produit lenovo = Produit.builder()
					.ref(UUID.randomUUID().toString())
					.name("Lenovo")
					.price(5000.0)
					.disponible(true)
					.stock(50)
					.imageUrl("https://3ia-academy.s3.eu-north-1.amazonaws.com/logos/images/lenovo.jpg")
					.category(electronic)
					.build();

			Produit hp = Produit.builder()
					.ref(UUID.randomUUID().toString())
					.name("HP")
					.price(6500.0)
					.disponible(true)
					.stock(30)
					.imageUrl("https://3ia-academy.s3.eu-north-1.amazonaws.com/logos/images/hp.jpg")
					.category(electronic)
					.build();

//			produitDao.save(lenovo);
//			produitDao.save(hp);

			produitDao.saveAll(List.of(lenovo, hp));



			Produit nike = Produit.builder()
					.ref(UUID.randomUUID().toString())
					.name("Nike")
					.price(900.0)
					.disponible(true)
					.stock(100)
					.imageUrl("https://3ia-academy.s3.eu-north-1.amazonaws.com/logos/images/Nike.jpg")
					.category(clothing)
					.build();

			Produit adidas = Produit.builder()
					.ref(UUID.randomUUID().toString())
					.name("Adidas")
					.price(100.0)
					.disponible(true)
					.stock(300)
					.imageUrl("https://3ia-academy.s3.eu-north-1.amazonaws.com/logos/images/Adidas.avif")
					.category(clothing)
					.build();

			produitDao.saveAll(List.of(nike, adidas));
		};
	}

//	@Bean
	public CommandLineRunner saveClients(ClientDao clientDao) {
		return args -> {
			Client mohammed = Client.builder()
					.ref("M001")
					.username("Mohammed")
					.lastname("Ezzaim")
					.email("mohammed@gmail.com")
					.password("1234")
					.build();

			Client houda = Client.builder()
					.ref("H001")
					.username("Houda")
					.lastname("nouri")
					.email("houda@gmail.com")
					.password("1234")
					.build();

			clientDao.saveAll(List.of(mohammed, houda));
		};
	}

//	@Bean
	public CommandLineRunner returnerProductsAcheteByClient(ClientService clientService) {
		return args -> {
			clientService.returnerProductsAcheteByClient("houda@gmail.com");
		};
	}



//	@Bean
	public CommandLineRunner returnerClientsAcheteProduct(ProduitService produitService) {
		return args -> {
			produitService.returnerClientsAcheteProduct("Adidas");
		};
	}

	// @Bean
	public CommandLineRunner buyAProduct(ProduitService produitService) {
		return args -> {
			produitService.buyAProduct("mohammed@gmail.com", "b9a55f4e-4a79-4265-ade5-fdbd2d2cf3f0");
			produitService.buyAProduct("mohammed@gmail.com", "b8a7e6c9-f643-42cf-b450-714424e0ff32");
		};
	}


	@Bean
	public CommandLineRunner buyProduitsByClients(ClientDao clientDao, ProduitDao produitDao, CommandDao commandDao) {
		return args -> {
			Client mohammed = clientDao.findByEmail("mohammed@gmail.com");
			Client houda = clientDao.findByEmail("houda@gmail.com");

			Produit adidas = produitDao.findById("e108b75c-a9ed-4d0d-a3b0-52b97e87e034").orElseThrow();
			Produit hp = produitDao.findById("b8a7e6c9-f643-42cf-b450-714424e0ff32").orElseThrow();
			Produit lenovo = produitDao.findById("b9a55f4e-4a79-4265-ade5-fdbd2d2cf3f0").orElseThrow();
			Produit nike = produitDao.findById("2a7bf4e9-3a08-4522-996f-fd4a8607d932").orElseThrow();

			// CMD Mohammed
			Command cmdBuyByMohammed = Command.builder()
					.ref(UUID.randomUUID().toString())
					.client(mohammed)
					.status(true)
					.build();

			LigneCommand ligneCmd1 = LigneCommand.builder()
					.ref(UUID.randomUUID().toString())
					.produit(hp)
					.quantite(1)
					.prix(hp.getPrice())
					.command(cmdBuyByMohammed)
					.build();

			LigneCommand ligneCmd2 = LigneCommand.builder()
					.ref(UUID.randomUUID().toString())
					.produit(nike)
					.quantite(2)
					.prix(nike.getPrice())
					.command(cmdBuyByMohammed)
					.build();

			LigneCommand ligneCmd3 = LigneCommand.builder()
					.ref(UUID.randomUUID().toString())
					.produit(adidas)
					.quantite(1)
					.prix(adidas.getPrice())
					.command(cmdBuyByMohammed)
					.build();

			cmdBuyByMohammed.setLigneCommands(List.of(ligneCmd1, ligneCmd2, ligneCmd3));
			cmdBuyByMohammed.setPrixTotal(
					ligneCmd1.getPrix()* ligneCmd1.getQuantite() +
					ligneCmd2.getPrix()* ligneCmd2.getQuantite() +
					ligneCmd3.getPrix()* ligneCmd3.getQuantite());

			commandDao.save(cmdBuyByMohammed);
		};
	}

}
