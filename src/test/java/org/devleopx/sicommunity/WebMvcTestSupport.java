package org.devleopx.sicommunity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.devleopx.sicommunity.domain.developer.api.DeveloperApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {
        DeveloperApi.class
//        CustomerController.class,
//        ProjectController.class,
//        UserController.class,
//        ProposalController.class,
//        BookmarkController.class
}
//,excludeAutoConfiguration = SecurityAutoConfiguration.class
)
@WithMockUser(username = "USER", roles = "USER")
public abstract class WebMvcTestSupport {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
//    @MockBean
//    protected CustomerService customerService;
//    @MockBean
//    protected ProjectService projectService;
//    @MockBean
//    protected UserService userService;
//    @MockBean
//    protected ProposalService proposalService;
//    @MockBean
//    protected SlideService slideService;
//    @MockBean
//    protected ContextServiceImpl contextService;
//    @MockBean
//    protected BookmarkService bookmarkService;
//    @MockBean
//    protected TeamService teamService;

}
