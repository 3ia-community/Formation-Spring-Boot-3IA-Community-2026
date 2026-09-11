package tia.community.layer_ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import tia.community.layer_ws.entity.Product;
import tia.community.layer_ws.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class LayerWsApplication {

	public static void main(String[] args) {
		ApplicationContext ico_container = SpringApplication.run(LayerWsApplication.class, args);
//
//		ProductRepository productRepository = ico_container.getBean(ProductRepository.class);
//
//		List<Product> products = List.of(Product.builder().name("Lenovo").price(5000.0).category("Electronique").disponible(true).stock(100).build(),
//		Product.builder().name("HP").price(4500.0).category("Electronique").disponible(true).stock(80).build(),
//		Product.builder().name("Dell").price(6200.0).category("Electronique").disponible(true).stock(50).build(),
//		Product.builder().name("Samsung Galaxy").price(7500.0).category("Smartphone").disponible(true).stock(40).build(),
//		Product.builder().name("iPhone 15").price(9000.0).category("Smartphone").disponible(false).stock(0).build());
//
//		productRepository.saveAll(products);

	}

}
