package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Barata;
import corridabaratas.corridabaratas.service.BarataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/barata")
public class BarataController {
private final BarataService barataService;

public BarataController(BarataService barataService) { this.barataService = barataService;}

    @GetMapping("/listar")

    public ResponseEntity<List<Barata>>listarBarata(){
    return ResponseEntity.ok(barataService.listarBarata());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barata> getById(@PathVariable Integer id){
        Optional<Barata> b = barataService.buscarPorId(id);
        return b.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Barata> criar(@RequestBody Barata barata){
        return ResponseEntity.ok(barataService.criar(barata));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barata> atualizar(@PathVariable Integer id, @RequestBody Barata update){
        return ResponseEntity.ok(barataService.atualizar(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        barataService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
