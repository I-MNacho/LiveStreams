package dev.ignaciomares.scheduler.controller;

import dev.ignaciomares.scheduler.model.LiveStream;
import dev.ignaciomares.scheduler.repository.LiveStreamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {


    private final LiveStreamRepository repository;

//using constructor injection because we added "@Component" to the class of LiveStreamRepository
    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // GET https://localhost8080/streams
    @GetMapping
    public List<LiveStream> findAll(){
        return repository.findAll();
    }






}
