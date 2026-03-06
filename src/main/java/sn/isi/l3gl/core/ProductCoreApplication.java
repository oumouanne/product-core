package sn.isi.l3gl.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.isi.l3gl.core.model.Product;
import sn.isi.l3gl.core.service.ProductService;

@SpringBootApplication
public class ProductCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCoreApplication.class, args);
	}
    // Test rapide de createProduct() avec MySQL
    @Bean
    CommandLineRunner run(ProductService productService) {
        return args -> {
            Product p = new Product();
            p.setName("Produit Test");
            p.setDescription("Description test");
            p.setPrice(100.0);
            p.setQuantity(10);

            productService.createProduct(p);

            System.out.println("Produit ajouté avec succès !");
        };
    }

}
