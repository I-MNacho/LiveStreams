package dev.ignaciomares.scheduler.repository;

import dev.ignaciomares.scheduler.model.LiveStream;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository(){
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building Rest APIs with SpringBoot",
                """
                Spring Boot is a very convenient to use when building REST APIs;
                """,
                "https://www.nacho.tv/nacho",
                LocalDateTime.of(2022, 2, 16, 11, 0),
                LocalDateTime.of(2022, 2, 16, 12, 0)
        ));
    }

    public List<LiveStream> findAll(){
        return streams;
    }

    public LiveStream findById(String id){
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElse(findById(id));
    }

    public LiveStream create(LiveStream stream){
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id){
        LiveStream exsisting = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(exsisting);
        streams.set(i, stream);
    }

    public void delete(String id){
        streams.removeIf(stream -> stream.id().equals(id));
    }


}
