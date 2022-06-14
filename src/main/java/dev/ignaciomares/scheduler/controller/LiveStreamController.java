package dev.ignaciomares.scheduler.controller;

import dev.ignaciomares.scheduler.model.LiveStream;
import dev.ignaciomares.scheduler.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {


    private final LiveStreamRepository repository;

//Constructor
//using constructor injection because we added "@Component" to the class of LiveStreamRepository
//usually would have '@Autowired' key word but using it this way we don't need it
    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }


// GET https://localhost8080/streams
    @GetMapping
    public List<LiveStream> findAll(){
        return repository.findAll();
    }


//find a stream by an individual id
// GET http://localhost:8080/streams/someidnumber
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id){
        return repository.findById(id);
}

//create a new live stream
// POST http://localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@Valid @RequestBody LiveStream stream){
        return repository.create(stream);
    }


// update
// PUT http://localhost:8080/streams/someidnumber
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id){
        repository.update(stream, id);
    }

// delete request
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }



}
