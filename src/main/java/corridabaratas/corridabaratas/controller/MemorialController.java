package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Memorial;
import corridabaratas.corridabaratas.service.MemorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/memorial")

public class MemorialController {
    private final MemorialService memorialService;
    public MemorialController(MemorialService memorialService) {this.memorialService = memorialService;}
    @GetMapping("/listar")

    public ResponseEntity<List<Memorial>>listarMemorial() {return ResponseEntity.ok(memorialService.listarMemorial());}

    @GetMapping("/{id}")
    public ResponseEntity<Memorial> getById(@PathVariable Integer id){
        Optional<Memorial> m = memorialService.buscarPorId(id);
        return m.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Memorial> criar(@RequestBody Memorial memorial){
        return ResponseEntity.ok(memorialService.criar(memorial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Memorial> atualizar(@PathVariable Integer id, @RequestBody Memorial update){
        return ResponseEntity.ok(memorialService.atualizar(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        memorialService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
