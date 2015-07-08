package org.example;

import org.example.data.catalog.ProductRepository;
import org.example.data.directory.PersonRepository;
import org.example.domain.catalog.Product;
import org.example.domain.directory.Person;
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
  private static final String PERSON_NAME  = "yoda";
  private static final String PRODUCT_NAME = "Light Sabre";

  @Autowired
  PersonRepository  personRepository;
  @Autowired
  ProductRepository productRepository;

  /**
   * Tests a JTA transaction.
   */
  @org.junit.Test
  public void test()
  {
    final Person person = new Person();
    person.setName(PERSON_NAME);

    personRepository.save(person);

    final Product product = new Product();
    product.setName(PRODUCT_NAME);

    productRepository.save(product);

    final Person retrievedPerson = personRepository.findByName(PERSON_NAME);
    Assert.assertNotNull(retrievedPerson);
    Assert.assertNotNull(retrievedPerson.getID());
    Assert.assertEquals(PERSON_NAME, retrievedPerson.getName());

    final Product retrievedProduct = productRepository.findByName(PRODUCT_NAME);
    Assert.assertNotNull(retrievedProduct);
    Assert.assertNotNull(retrievedProduct.getID());
    Assert.assertEquals(PRODUCT_NAME, retrievedProduct.getName());
  }
}
