package sn.isi.l3gl.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

// @SpringBootTest : charge le contexte Spring complet pour les tests
@SpringBootTest
// @TestPropertySource : utilise application-test.properties (H2) au lieu de MySQL
// Cela évite d'avoir besoin d'une vraie base de données pendant les tests
@TestPropertySource(locations = "classpath:application-test.properties")
class ProductCoreApplicationTests {

    // Test de base : vérifie que le contexte Spring démarre correctement
    @Test
    void contextLoads() {
        // Si ce test passe = l'application se configure correctement
    }
}