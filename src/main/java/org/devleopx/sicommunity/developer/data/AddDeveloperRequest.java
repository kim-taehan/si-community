package org.devleopx.sicommunity.developer.data;

import lombok.Builder;
import org.devleopx.sicommunity.developer.entity.Developer;
import org.devleopx.sicommunity.developer.enums.Gender;
import org.springframework.util.Assert;

import java.time.LocalDate;

public record AddDeveloperRequest(String developerName, LocalDate birthDate, Gender gender) {

    @Builder
    public AddDeveloperRequest {
        Assert.hasText(developerName, "개발자명은 필수입니다.");
        Assert.notNull(birthDate, "생년월일은 필수입니다.");
        Assert.notNull(gender, "성별은 필수입니다.");
    }

    public Developer toEntity() {
        return Developer.builder()
                .developerName(developerName)
                .birthDate(birthDate)
                .gender(gender)
                .build();
    }
}
