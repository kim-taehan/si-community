package org.devleopx.sicommunity.developer.repository;

import org.devleopx.sicommunity.developer.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
