package org.devleopx.sicommunity.domain.developer.data;

import com.mysema.commons.lang.Assert;
import lombok.Builder;
import org.springframework.util.StringUtils;

import static com.mysema.commons.lang.Assert.*;

public record FindDevelopersRequest(String developerName) {

    @Builder
    public FindDevelopersRequest{
        isTrue(StringUtils.hasText(developerName) && developerName.length() >= 2, "2자 이상의 이름이 필수입니다.");
    }
}
