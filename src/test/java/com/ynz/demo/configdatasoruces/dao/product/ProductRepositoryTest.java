package com.ynz.demo.configdatasoruces.dao.product;

import com.ynz.demo.configdatasoruces.model.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveProductToProductDB(){
        Product product = new Product();
        product.setName("iPhone");
        product.setPrice(1000);

        Product persisted = productRepository.save(product);

        assertNotNull(persisted);
    }

}