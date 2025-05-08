package ru.webrise.tech_spec_java_spring_final_v2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.webrise.tech_spec_java_spring_final_v2.model.StreamingPlatform;
import ru.webrise.tech_spec_java_spring_final_v2.service.StreamingPlatformService;

@Slf4j
@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class StreamingPlatformController {
    private final StreamingPlatformService streamingPlatformService;

    @PostMapping
    public StreamingPlatform addStreamingPlatform(@RequestBody StreamingPlatform streamingPlatform) {
        log.info("add streaming platform {}", streamingPlatform);
        return streamingPlatformService.addNew(streamingPlatform);
    }
}
