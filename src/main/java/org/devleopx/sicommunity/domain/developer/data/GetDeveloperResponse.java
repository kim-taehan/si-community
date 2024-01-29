package org.devleopx.sicommunity.domain.developer.data;

import lombok.Builder;
import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.devleopx.sicommunity.domain.developer.enums.Gender;

import java.time.LocalDate;

public record GetDeveloperResponse(
        Long developerId,
        String developerName,
        LocalDate birthDate,
        Gender gender,
        int age
) {
    @Builder
    public GetDeveloperResponse {

    }
    public static GetDeveloperResponse fromEntity(Developer developer) {
        return GetDeveloperResponse.builder()
                .developerId(developer.getId())
                .developerName(developer.getDeveloperName())
                .gender(developer.getIdentifier().getGender())
                .birthDate(developer.getIdentifier().getBirthDate())
                .age(developer.getIdentifier().getAge())
                .build();
    }
}
