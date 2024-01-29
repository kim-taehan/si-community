package org.devleopx.sicommunity.domain.developer.service;

import lombok.RequiredArgsConstructor;
import org.devleopx.sicommunity.domain.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersRequest;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersResponse;
import org.devleopx.sicommunity.domain.developer.data.GetDeveloperResponse;
import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.devleopx.sicommunity.domain.developer.repository.DeveloperRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public GetDeveloperResponse getDeveloper(Long developerId) {
        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new IllegalArgumentException("개발자 정보를 확인할 수 없습니다."));
        return GetDeveloperResponse.fromEntity(developer);
    }

    @Override
    public Page<FindDevelopersResponse> findDevelopers(FindDevelopersRequest request, Pageable pageable) {
        Page<Developer> developers = developerRepository.findDevelopers(request, pageable);
        return null;
    }
}
