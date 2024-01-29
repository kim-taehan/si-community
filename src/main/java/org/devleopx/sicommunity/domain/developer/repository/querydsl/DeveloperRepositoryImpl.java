package org.devleopx.sicommunity.domain.developer.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersRequest;
import org.devleopx.sicommunity.domain.developer.entity.Developer;
import org.devleopx.sicommunity.global.querydsl.Querydsl4RepositorySupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import static org.devleopx.sicommunity.domain.developer.entity.QDeveloper.developer;


public class DeveloperRepositoryImpl extends Querydsl4RepositorySupport implements DeveloperRepositoryQueryDsl {

    public DeveloperRepositoryImpl() {
        super(Developer.class);
    }
    @Override
    public Page<Developer> findDevelopers(FindDevelopersRequest request, Pageable pageable) {
        return applyPagination(pageable,
                contentQuery -> contentQuery
                        .selectFrom(developer)
                        .where(
                                developerNameStartWith(request.developerName())
                        )
        );
    }

    private BooleanExpression developerNameStartWith(String developerName) {
        return StringUtils.hasText(developerName) ? developer.developerName.startsWith(developerName) : null;
    }
}
