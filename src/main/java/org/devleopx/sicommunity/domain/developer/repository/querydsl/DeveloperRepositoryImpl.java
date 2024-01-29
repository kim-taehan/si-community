package org.devleopx.sicommunity.domain.developer.repository.querydsl;

import org.devleopx.sicommunity.domain.developer.data.FindDevelopersRequest;
import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DeveloperRepositoryImpl implements DeveloperRepositoryQueryDsl {
    @Override
    public Page<Developer> findDevelopers(FindDevelopersRequest request, Pageable pageable) {
        return null;
    }
}
