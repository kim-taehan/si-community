package org.devleopx.sicommunity.domain.developer;

import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.devleopx.sicommunity.domain.developer.enums.Gender;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class DeveloperSupport {

    public Developer 신규_개발자_등록(String developerName, String birthDay, Gender gender) {
        Developer developer = Developer.builder()
                .developerName(developerName)
                .gender(gender)
                .birthDate(StringUtils.hasText(birthDay) ? LocalDate.parse(birthDay) : null)
                .build();
        return developer;
    }
}
