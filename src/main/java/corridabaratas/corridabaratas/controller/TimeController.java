package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Time;
import corridabaratas.corridabaratas.service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/time")
public class TimeController {
    private final TimeService timeService;

    public TimeController (TimeService timeService) {this.timeService = timeService;}
    @GetMapping("/listar")
    public ResponseEntity<List<Time>>listarTime(){return ResponseEntity.ok(timeService.listarTime());}

    @GetMapping("/{id}")
    public ResponseEntity<Time> getById(@PathVariable Integer id){
        Optional<Time> t = timeService.buscarPorId(id);
        return t.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Time> criar(@RequestBody Time time){
        return ResponseEntity.ok(timeService.criar(time));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizar(@PathVariable Integer id, @RequestBody Time update){
        return ResponseEntity.ok(timeService.atualizar(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        timeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
