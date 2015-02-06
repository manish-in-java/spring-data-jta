package org.example;

import org.example.data.catalog.ProductRepository;
import org.example.data.directory.UserRepository;
import org.example.domain.catalog.Product;
import org.example.domain.directory.User;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test for JTA transactions
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class Test
{
  private static final String PRODUCT_NAME = "Light Sabre";
  private static final String USER_NAME    = "yoda";

  @Autowired
  ProductRepository productRepository;
  @Autowired
  UserRepository    userRepository;

  /**
   * Tests a JTA transaction.
   */
  @org.junit.Test
  public void test()
  {
    final User user = new User();
    user.setName(USER_NAME);

    userRepository.save(user);

    final Product product = new Product();
    product.setName(PRODUCT_NAME);

    productRepository.save(product);

    final User retrievedUser = userRepository.findByName(USER_NAME);
    Assert.assertNotNull(retrievedUser);
    Assert.assertEquals(USER_NAME, retrievedUser.getName());

    final Product retrievedProduct = productRepository.findByName(PRODUCT_NAME);
    Assert.assertNotNull(retrievedProduct);
    Assert.assertEquals(PRODUCT_NAME, retrievedProduct.getName());
  }
}
