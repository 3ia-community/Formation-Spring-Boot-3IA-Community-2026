package tia.community.oneToOne_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import tia.community.oneToOne_demo.dao.CategoryDao;
import tia.community.oneToOne_demo.dao.ClientDao;
import tia.community.oneToOne_demo.dao.ProduitDao;
import tia.community.oneToOne_demo.dao.ProfileDao;
import tia.community.oneToOne_demo.entity.Category;
import tia.community.oneToOne_demo.entity.Client;
import tia.community.oneToOne_demo.entity.Produit;
import tia.community.oneToOne_demo.entity.Profile;
import tia.community.oneToOne_demo.service.CategoryService;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class OneToOneDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc_Container = SpringApplication.run(OneToOneDemoApplication.class, args);
	}

	// @Bean
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
//	public CommandLineRunner returnProduitsByCategory(CategoryDao categoryDao) {
//		return args -> {
//
//		Category category = categoryDao.findByName("Electronic");
//		List<Produit> produits = category.getProduits();
//
//		System.out.println(category.getName());
//		produits.forEach(produit -> {
//			System.out.println("---------------------------");
//			System.out.println(produit.getName());
//			System.out.println(produit.getPrice());
//			System.out.println(produit.getImageUrl());
//			System.out.println(produit.getCategory().getName());
//		});
//
//		};
//	}


	@Bean
	public CommandLineRunner returnProduitsByCategory(CategoryService categoryService) {
		return args -> {
			categoryService.returnProduitsByCategory();
		};
	}
}
