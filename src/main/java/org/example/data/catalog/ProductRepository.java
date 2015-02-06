package org.example.data.catalog;

import org.example.data.EntityRepository;
import org.example.domain.catalog.Product;

/**
 * Contract for data access operations on an {@link Product}.
 */
public interface ProductRepository extends EntityRepository<Product>
{
  /**
   * Finds a product by its name.
   *
   * @param name The product name to find.
   * @return A {@link Product} if {@code name}
   * is found, {@code null} otherwise.
   */
  Product findByName(String name);
}
