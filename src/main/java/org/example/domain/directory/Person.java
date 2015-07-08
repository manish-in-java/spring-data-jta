package org.example.domain.directory;

import org.example.domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents a person.
 */
@Entity
@Table(name = "person")
public class Person extends Model
{
  @Column(name = "name")
  @NotNull
  private String name;

  /**
   * Gets the person's ame.
   *
   * @return The person's name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets the person's name.
   *
   * @param name The person's name.
   */
  public void setName(final String name)
  {
    this.name = name;
  }
}
