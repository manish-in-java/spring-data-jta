package org.example.data.directory;

import org.example.data.EntityRepository;
import org.example.domain.directory.User;

/**
 * Contract for data access operations on an {@link User}.
 */
public interface UserRepository extends EntityRepository<User>
{
  /**
   * Finds a user by its name.
   *
   * @param name The user name to find.
   * @return A {@link User} if {@code name}
   * is found, {@code null} otherwise.
   */
  User findByName(String name);
}
