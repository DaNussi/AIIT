package net.nussi.springbootbasics.api.stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RequestMapping("/api/stream")
@RestController
public class ApiController {


    @GetMapping(value = "/data", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Object> streamDataFlux() {
        

        return Flux.interval(Duration.ofSeconds(1)).map(i -> "Data stream line - " + i );
    }
}
