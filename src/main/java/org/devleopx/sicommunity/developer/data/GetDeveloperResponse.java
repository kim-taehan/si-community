package org.devleopx.sicommunity.developer.data;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import org.devleopx.sicommunity.developer.entity.Developer;
import org.devleopx.sicommunity.developer.enums.Gender;

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
