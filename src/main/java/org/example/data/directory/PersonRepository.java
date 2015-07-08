package org.example.data.directory;

import org.example.data.ModelRepository;
import org.example.domain.directory.Person;

/**
 * Contract for data access operations on an {@link Person}.
 */
public interface PersonRepository extends ModelRepository<Person>
{
  /**
   * Finds a user by its name.
   *
   * @param name The user name to find.
   * @return A {@link Person} if {@code name}
   * is found, {@code null} otherwise.
   */
  Person findByName(String name);
}
