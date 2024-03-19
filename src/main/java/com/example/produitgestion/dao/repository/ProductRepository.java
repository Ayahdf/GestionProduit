package com.example.produitgestion.dao.repository;

import com.example.produitgestion.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
