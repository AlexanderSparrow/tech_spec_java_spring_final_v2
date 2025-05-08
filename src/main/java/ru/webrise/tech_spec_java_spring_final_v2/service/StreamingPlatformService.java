package ru.webrise.tech_spec_java_spring_final_v2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.webrise.tech_spec_java_spring_final_v2.model.StreamingPlatform;
import ru.webrise.tech_spec_java_spring_final_v2.repository.StreamingPlatformRepository;

@Service
@RequiredArgsConstructor
public class StreamingPlatformService {

    private final StreamingPlatformRepository streamingPlatformRepository;

    public StreamingPlatform addNew(StreamingPlatform streamingPlatform) {
        return streamingPlatformRepository.save(streamingPlatform);
    }
}
