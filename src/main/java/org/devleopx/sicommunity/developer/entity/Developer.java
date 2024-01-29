package org.devleopx.sicommunity.developer.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.devleopx.sicommunity.developer.enums.Gender;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.*;

@Entity
@Getter
public class Developer {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "developer_id")
    private Long id;

    @Column(length = 10)
    private String developerName;

    private LocalDate birthDate;

    @Enumerated(STRING)
    private Gender gender;

    @Builder
    public Developer(String developerName, LocalDate birthDate, Gender gender) {
        this.developerName = developerName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
