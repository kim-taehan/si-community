package org.devleopx.sicommunity.domain.developer.repository;

import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.devleopx.sicommunity.domain.developer.repository.querydsl.DeveloperRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>, DeveloperRepositoryQueryDsl {
}
