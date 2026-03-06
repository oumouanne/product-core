package sn.isi.l3gl.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.l3gl.core.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    // Méthode pour compter les produits avec quantité <= valeur donnée
    long countByQuantityLessThanEqual(int quantity);
}