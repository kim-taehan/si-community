package org.devleopx.sicommunity;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public abstract class DataJpaTestSupport extends DefaultTestSupport {

}
