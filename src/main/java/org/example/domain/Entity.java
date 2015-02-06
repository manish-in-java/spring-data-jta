package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Represents a domain entity.
 */
@MappedSuperclass
public abstract class Entity implements Serializable
{
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  /**
   * Gets the unique identifier for this entity instance.
   *
   * @return The unique identifier for this entity instance.
   */
  public Long getID()
  {
    return this.id;
  }

  /**
   * Gets whether this is a newly created entity instance. Checks the unique
   * identifier to see if the identifier is {@code null}.
   *
   * @return {@code true} if this is a newly created instance.
   */
  public boolean isNew()
  {
    return id == null;
  }

  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object o)
  {
    if (o == null)
    {
      // Cannot compare with a null reference.
      return false;
    }

    if (this == o)
    {
      // References to the same object are equal.
      return true;
    }

    final Class<?> thatClass = o.getClass();
    final Class<?> thisClass = this.getClass();
    if (!thisClass.equals(thatClass)
        // Both instances being compared are of the same type.
        && !thisClass.getSuperclass().equals(thatClass)
        // This instance is a proxied instance but its actual type is the same as that of the other instance.
        && !thisClass.equals(thatClass.getSuperclass())
        // The other instance is a proxied instance but its actual type is the same as that of this instance.
        && !thisClass.getSuperclass().equals(thatClass.getSuperclass())
      // Both instances are proxied instances but have the same actual type.
        )
    {
      // Cannot compare incompatible objects.
      return false;
    }

    final Entity that = (Entity) o;

    // Objects of the same type and with the same identifier are equal.
    return ((this.id == null) && (that.id == null))
        || ((this.id != null) && (that.id != null) && this.id.equals(that.id));
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
  {
    return this.getID() != null ? this.getID().hashCode() : super.hashCode();
  }
}
