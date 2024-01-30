package org.devleopx.sicommunity.domain.developer.repository;

import org.assertj.core.groups.Tuple;
import org.devleopx.sicommunity.DataJpaTestSupport;
import org.devleopx.sicommunity.domain.developer.DeveloperSupport;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersRequest;
import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.devleopx.sicommunity.domain.developer.enums.Gender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[repository] developer repository")
class DeveloperRepositoryTest extends DataJpaTestSupport {

    private DeveloperSupport support = new DeveloperSupport();

    @Autowired
    private DeveloperRepository developerRepository;

    @DisplayName("이름의 앞자리 2개로 이름이 일치하는 개발자 리스트를 조회할 수 있다.")
    @Test
    void findDevelopers(){

        // given
        Developer 홍길동 = support.신규_개발자_등록("홍길동", "2001-01-01", Gender.MALE);
        Developer 류관순 = support.신규_개발자_등록("류관순", "2001-01-01", Gender.MALE);
        Developer 홍길동2 = support.신규_개발자_등록("홍길동2", "2001-01-01", Gender.MALE);
        persist(홍길동, 류관순, 홍길동2);
        FindDevelopersRequest request = FindDevelopersRequest.builder().developerName("홍길").build();

        // when
        Page<Developer> developers = developerRepository.findDevelopers(request, Pageable.ofSize(10));

        // then
        assertThat(developers).hasSize(2)
                .extracting( "developerName", "identifier.birthDate", "identifier.gender")
                .containsExactly(findTuple(홍길동), findTuple(홍길동2));
    }

    private Tuple findTuple(Developer developer1) {
        return Tuple.tuple( developer1.getDeveloperName(), developer1.getIdentifier().getBirthDate(), developer1.getIdentifier().getGender());
    }

}