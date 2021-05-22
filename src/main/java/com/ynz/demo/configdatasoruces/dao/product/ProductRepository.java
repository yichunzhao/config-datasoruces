package com.ynz.demo.configdatasoruces.dao.product;

import com.ynz.demo.configdatasoruces.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
