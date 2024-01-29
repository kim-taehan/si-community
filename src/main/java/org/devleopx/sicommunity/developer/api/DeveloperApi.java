package org.devleopx.sicommunity.developer.api;

import lombok.RequiredArgsConstructor;
import org.devleopx.sicommunity.developer.data.AddDeveloperRequest;
import org.devleopx.sicommunity.developer.service.DeveloperService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
