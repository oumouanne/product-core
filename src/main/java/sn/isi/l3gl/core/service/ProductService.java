package sn.isi.l3gl.core.service;

import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.model.Product;
import sn.isi.l3gl.core.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Injection du repository via le constructeur
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // =========================
    // Version 0.0.1-SNAPSHOT
    // =========================
    // Méthode pour créer un produit dans l'inventaire
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // =========================
    // Version 0.1.0-SNAPSHOT
    // =========================
    // Méthode pour lister tous les produits
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    // =========================
    // Version 0.2.0-SNAPSHOT
    // =========================
    // Méthode pour mettre à jour la quantité d'un produit
    public Product updateQuantity(Long productId, int newQuantity) {
        Product p = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        p.setQuantity(newQuantity);
        return productRepository.save(p);
    }

    // =========================
    // Version 0.3.0-SNAPSHOT
    // =========================
    // Méthode pour compter le nombre de produits avec un stock faible (<=5)
    public long countLowStockProducts() {
        return productRepository.countByQuantityLessThanEqual(5);
    }
}