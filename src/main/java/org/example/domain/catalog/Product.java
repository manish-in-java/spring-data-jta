package org.example.domain.catalog;

import org.example.domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents a product.
 */
@Entity
@Table(name = "product")
public class Product extends Model
{
  @Column(name = "name")
  @NotNull
  private String name;

  /**
   * Gets the product name.
   *
   * @return The product name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets the product name.
   *
   * @param name The product name.
   */
  public void setName(final String name)
  {
    this.name = name;
  }
}
