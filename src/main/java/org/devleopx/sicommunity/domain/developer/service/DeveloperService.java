package org.devleopx.sicommunity.domain.developer.service;

import org.devleopx.sicommunity.domain.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersRequest;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersResponse;
import org.devleopx.sicommunity.domain.developer.data.GetDeveloperResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DeveloperService {
    Long addDeveloper(AddDeveloperRequest request);

    GetDeveloperResponse getDeveloper(Long developerId);

    Page<FindDevelopersResponse> findDevelopers(FindDevelopersRequest request, Pageable pageable);
}
