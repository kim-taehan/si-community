package org.devleopx.sicommunity.developer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.devleopx.sicommunity.WebMvcTestSupport;
import org.devleopx.sicommunity.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.developer.data.GetDeveloperResponse;
import org.devleopx.sicommunity.developer.enums.Gender;
import org.devleopx.sicommunity.developer.service.DeveloperService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
        mockMvc.perform(post("/developers")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request))
                        .with(csrf())
                )
                .andDo(print())
                .andExpect(status().is(HttpStatus.CREATED.value()))
                .equals(100L);
    }

    @Test
    @DisplayName("")
    void getDeveloper() throws Exception {
        // given
        GetDeveloperResponse response = 개발자_조회_응답데이터();
        when(developerService.getDeveloper(100L)).thenReturn(response);

        // when & then
        mockMvc.perform(get("/developers/{developerId}", 100L)
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