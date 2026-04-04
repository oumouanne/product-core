package sn.isi.l3gl.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.model.Product;
import sn.isi.l3gl.core.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.listProducts());
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }

    // PUT /api/products/{id}/quantity
    @PutMapping("/{id}/quantity")
    public ResponseEntity<Product> updateQuantity(@PathVariable Long id,
                                                  @RequestParam int quantity) {
        return ResponseEntity.ok(productService.updateQuantity(id, quantity));
    }

    // GET /api/products/low-stock
    @GetMapping("/low-stock")
    public ResponseEntity<Long> countLowStock() {
        return ResponseEntity.ok(productService.countLowStockProducts());
    }
}