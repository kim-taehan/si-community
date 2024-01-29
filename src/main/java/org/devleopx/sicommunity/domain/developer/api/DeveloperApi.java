package org.devleopx.sicommunity.domain.developer.api;

import lombok.RequiredArgsConstructor;
import org.devleopx.sicommunity.domain.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersRequest;
import org.devleopx.sicommunity.domain.developer.data.FindDevelopersResponse;
import org.devleopx.sicommunity.domain.developer.data.GetDeveloperResponse;
import org.devleopx.sicommunity.domain.developer.service.DeveloperService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/developers")
@RequiredArgsConstructor
public class DeveloperApi {

    private final DeveloperService developerService;

    @PostMapping("")
    public ResponseEntity<Long> addDeveloper(@RequestBody AddDeveloperRequest request) {
        Long developerId = developerService.addDeveloper(request);
        return new ResponseEntity(developerId, HttpStatusCode.valueOf(201));
    }

    @GetMapping("")
    public ResponseEntity<Page<FindDevelopersResponse>> findDevelopers(@RequestParam FindDevelopersRequest request, @PageableDefault(size=10, page = 0) Pageable pageable) {
        Page<FindDevelopersResponse> rets = developerService.findDevelopers(request, pageable);
        return ResponseEntity.ok(rets);
    }

    @GetMapping("/{developerId}")
    public ResponseEntity<GetDeveloperResponse> getDeveloper(@PathVariable Long developerId) {
        GetDeveloperResponse response = developerService.getDeveloper(developerId);
        return ResponseEntity.ok(response);
    }


}
