package org.devleopx.sicommunity.developer.service;

import org.assertj.core.api.Assertions;
import org.devleopx.sicommunity.SpringBootTestSupport;
import org.devleopx.sicommunity.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.developer.enums.Gender;
import org.devleopx.sicommunity.developer.repository.DeveloperRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@DisplayName("[service] developer service")
class DeveloperServiceTest extends SpringBootTestSupport {


    @Autowired
    private DeveloperService developerService;


    @Nested
    class AddDeveloper {

        @Test
        @DisplayName("신규 개발자 등록시 개발자 ID는 1보다 커야 한다.")
        void addDeveloper() {

            // given
            var request = 신규_개발자등록_REQUEST_생성("kimtaehan", "1985-03-12", Gender.MALE);

            // when
            Long developerId = developerService.addDeveloper(request);

            // then
            Assertions.assertThat(developerId).isGreaterThan(0L);
        }
    }


    private AddDeveloperRequest 신규_개발자등록_REQUEST_생성(String developerName, String birthDay, Gender gender) {
        return AddDeveloperRequest.builder()
                .developerName(developerName)
                .birthDate(StringUtils.hasText(birthDay) ? LocalDate.parse(birthDay) : null)
                .gender(gender).build();
    }
}