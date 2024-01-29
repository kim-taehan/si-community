package org.devleopx.sicommunity.developer.service;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.devleopx.sicommunity.SpringBootTestSupport;
import org.devleopx.sicommunity.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.developer.data.GetDeveloperResponse;
import org.devleopx.sicommunity.developer.entity.Developer;
import org.devleopx.sicommunity.developer.enums.Gender;
import org.devleopx.sicommunity.developer.repository.DeveloperRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

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
            assertThat(developerId).isGreaterThan(0L);
        }
    }

    @Nested
    class GetDeveloper {
        @Test
        @DisplayName("개발자 ID로 등록된 개발자를 조회할 수 있다.")
        void getDeveloper() {

            // given
            Developer developer1 = 신규_개발자_등록("홍길동", "2001-01-01", Gender.MALE);
            Developer developer2 = 신규_개발자_등록("류관순", "2001-12-31", Gender.FEMALE);

            // when
            GetDeveloperResponse developer = developerService.getDeveloper(developer2.getId());

            // then
            assertThat(developer).isNotNull()
                    .extracting("developerId", "developerName", "birthDate", "gender")
                    .containsExactly(developer2.getId(), developer2.getDeveloperName(), developer2.getIdentifier().getBirthDate(), developer2.getIdentifier().getGender());
        }
    }

    private Developer 신규_개발자_등록(String developerName, String birthDay, Gender gender) {
        Developer developer = Developer.builder()
                .developerName(developerName)
                .gender(gender)
                .birthDate(StringUtils.hasText(birthDay) ? LocalDate.parse(birthDay) : null)
                .build();
        persist(developer);
        return developer;
    }

    private AddDeveloperRequest 신규_개발자등록_REQUEST_생성(String developerName, String birthDay, Gender gender) {
        return AddDeveloperRequest.builder()
                .developerName(developerName)
                .birthDate(StringUtils.hasText(birthDay) ? LocalDate.parse(birthDay) : null)
                .gender(gender).build();
    }
}