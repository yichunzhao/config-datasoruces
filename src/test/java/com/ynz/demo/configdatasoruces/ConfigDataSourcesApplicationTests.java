package com.ynz.demo.configdatasoruces;

import com.ynz.demo.configdatasoruces.dao.product.ProductRepository;
import com.ynz.demo.configdatasoruces.dao.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ConfigDataSourcesApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
    }

    @Test
    void testApplicationContextContainsProductRepositoryBean() {
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        assertNotNull(productRepository);
    }

    @Test
    void testApplicationContextContainsUserRepositoryBean() {
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        assertNotNull(userRepository);
    }

}
