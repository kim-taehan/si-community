package org.devleopx.sicommunity.developer.service;

import lombok.RequiredArgsConstructor;
import org.devleopx.sicommunity.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.developer.entity.Developer;
import org.devleopx.sicommunity.developer.repository.DeveloperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeveloperServiceAdapter implements DeveloperService {

    private final DeveloperRepository developerRepository;
    @Override
    @Transactional
    public Long addDeveloper(AddDeveloperRequest request) {
        return developerRepository.save(request.toEntity()).getId();
    }
}
