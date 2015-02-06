package org.example.domain.directory;

import org.example.domain.Entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents a user.
 */
@javax.persistence.Entity
@Table(name = "user")
public class User extends Entity
{
  @Column(name = "name")
  @NotNull
  private String name;

  /**
   * Gets the username.
   *
   * @return The username.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets the username.
   *
   * @param name The username.
   */
  public void setName(final String name)
  {
    this.name = name;
  }
}
