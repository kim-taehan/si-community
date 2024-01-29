package org.devleopx.sicommunity.domain.developer.entity.embeds;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.devleopx.sicommunity.domain.developer.enums.Gender;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.*;

@Embeddable
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Identifier {

    private LocalDate birthDate;

    @Enumerated(STRING)
    private Gender gender;

    @Builder
    public Identifier(LocalDate birthDate, Gender gender) {
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public int getAge() {
        // 만나이 구하기 로직 필요합니다.
        return LocalDate.now().compareTo(birthDate);
    }
}
