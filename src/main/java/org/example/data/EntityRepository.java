package org.example.data;

import org.example.domain.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Contract for data access operations on an {@link Entity}.
 */
@NoRepositoryBean
public interface EntityRepository<T extends Entity> extends JpaRepository<T, Long>
{
}
