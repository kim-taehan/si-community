package org.devleopx.sicommunity.domain.developer.data;

import com.mysema.commons.lang.Assert;
import lombok.Builder;
import org.springframework.util.StringUtils;

public record FindDevelopersRequest(String developerName) {

    @Builder
    public FindDevelopersRequest{
        Assert.isTrue(StringUtils.hasText(developerName) && developerName.length() >= 2, "2자 이상의 이름이 필수입니다.");
    }
}
