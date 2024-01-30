package org.devleopx.sicommunity.domain.developer.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.devleopx.sicommunity.WebMvcTestSupport;
import org.devleopx.sicommunity.domain.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.domain.developer.data.GetDeveloperResponse;
import org.devleopx.sicommunity.domain.developer.enums.Gender;
import org.devleopx.sicommunity.domain.developer.service.DeveloperService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("[api] developer api")
class DeveloperApiTest extends WebMvcTestSupport {

    @MockBean
    private DeveloperService developerService;

    @Test
    @DisplayName("신규 개발자 등록 API 수행하면, 201 응답을 받는다.")
    void addDeveloper() throws Exception {
        // given
        when(developerService.addDeveloper(any())).thenReturn(100L);
        var request = AddDeveloperRequest.builder()
                .developerName("test")
                .birthDate(LocalDate.now())
                .gender(Gender.MALE)
                .build();


        // when & then
        mockMvc.perform(post("/api/v1/developers")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request))
                        .with(csrf())
                )
                .andDo(print())
                .andExpect(status().is(HttpStatus.CREATED.value()))
                .equals(100L);
    }


    @CsvSource({", 2001-01-01, MALE", "홍길동, , MALE", "홍길동, 2001-01-01, "})
    @ParameterizedTest
    @DisplayName("신규 개발자 등록 API 필수값이 없는 경우 애러가 발생한다.")
    void addDeveloperException(String developerName, String birthDate, String gender) throws Exception {
        // given
        when(developerService.addDeveloper(any())).thenReturn(100L);
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("developerName", developerName);
        objectNode.put("birthDate", birthDate);
        objectNode.put("gender", gender);


        // when & then
        mockMvc.perform(post("/api/v1/developers")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectNode.toString())
                        .with(csrf())
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
//                .andExpect(jsonPath("$.message").value("400"));
    }

    @Test
    @DisplayName("개발자 ID로 개발자 상세 정보를 조회한다.")
    void getDeveloper() throws Exception {
        // given
        GetDeveloperResponse response = 개발자_조회_응답데이터();
        when(developerService.getDeveloper(100L)).thenReturn(response);

        // when & then
        mockMvc.perform(get("/api/v1/developers/{developerId}", 100L)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf())
                )
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(result -> result.equals(response));
    }


    private static GetDeveloperResponse 개발자_조회_응답데이터() {
        return GetDeveloperResponse.builder()
                .developerId(100L)
                .developerName("홍길동")
                .gender(Gender.MALE)
                .age(30)
                .birthDate(LocalDate.now().minusYears(30))
                .build();
    }
}