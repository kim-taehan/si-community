package org.devleopx.sicommunity.developer.api;

import lombok.RequiredArgsConstructor;
import org.devleopx.sicommunity.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.developer.data.GetDeveloperResponse;
import org.devleopx.sicommunity.developer.service.DeveloperService;
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

    @GetMapping("/{developerId}")
    public ResponseEntity<GetDeveloperResponse> getDeveloper(@PathVariable Long developerId) {
        GetDeveloperResponse response = developerService.getDeveloper(developerId);
        return ResponseEntity.ok(response);
    }


}
