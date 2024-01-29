package org.devleopx.sicommunity.developer.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.devleopx.sicommunity.developer.entity.embeds.Identifier;
import org.devleopx.sicommunity.developer.enums.Gender;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Developer {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "developer_id")
    private Long id;

    @Column(length = 10)
    private String developerName;

    @Embedded
    private Identifier identifier;



    @Builder
    public Developer(String developerName, LocalDate birthDate, Gender gender) {
        this.developerName = developerName;
        this.identifier = new Identifier(birthDate, gender);
    }
}
