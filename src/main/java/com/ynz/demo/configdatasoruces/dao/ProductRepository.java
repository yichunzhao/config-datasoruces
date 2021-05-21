package com.ynz.demo.configdatasoruces.dao;

import com.ynz.demo.configdatasoruces.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Long, Product> {
}
