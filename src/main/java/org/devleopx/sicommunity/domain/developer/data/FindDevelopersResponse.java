package org.devleopx.sicommunity.domain.developer.data;

import lombok.Builder;
import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.devleopx.sicommunity.domain.developer.enums.Gender;

import java.time.LocalDate;

public record FindDevelopersResponse(
        Long developerId,
        String developerName,
        LocalDate birthDate,
        Gender gender,
        int age
) {

    @Builder
    public FindDevelopersResponse{

    }

    public static FindDevelopersResponse fromEntity(Developer developer) {
        return FindDevelopersResponse.builder()
                .developerId(developer.getId())
                .developerName(developer.getDeveloperName())
                .gender(developer.getIdentifier().getGender())
                .birthDate(developer.getIdentifier().getBirthDate())
                .age(developer.getIdentifier().getAge())
                .build();
    }

}
