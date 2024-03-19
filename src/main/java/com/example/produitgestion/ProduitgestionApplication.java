package com.example.produitgestion;

import com.example.produitgestion.dao.entities.Product;

import com.example.produitgestion.dao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitgestionApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProduitgestionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Product product = new Product();

        product.setName("Produit 1");
        product.setDescription("Description du produit 1");
        product.setPrice(10.0);
        productRepository.save(product);

        System.out.println("Liste des produits : ");
        productRepository.findAll().forEach(System.out::println);

        Product productToUpdate = productRepository.findById(1).orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setName("Produit mis à jour");
            productRepository.save(productToUpdate);
        }
        System.out.println("Liste des produits apres modification : ");
        productRepository.findAll().forEach(System.out::println);

//        productRepository.deleteById(1);
//        System.out.println("Liste des produits apres suppression : ");
//        productRepository.findAll().forEach(System.out::println);
    }
}
