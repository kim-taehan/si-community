package org.devleopx.sicommunity.developer.service;

import org.devleopx.sicommunity.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.developer.data.GetDeveloperResponse;


public interface DeveloperService {
    Long addDeveloper(AddDeveloperRequest request);

    GetDeveloperResponse getDeveloper(Long developerId);
}
