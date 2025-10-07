package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Pista;
import corridabaratas.corridabaratas.service.PistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pista")
public class PistaController {
    private final PistaService pistaService;

    public PistaController(PistaService pistaService) {this.pistaService = pistaService;}

    @GetMapping("/listar")

    public ResponseEntity<List<Pista>>listaPista(){return ResponseEntity.ok(pistaService.listarPista());}

    @GetMapping("/{id}")
    public ResponseEntity<Pista> getById(@PathVariable Integer id){
        Optional<Pista> p = pistaService.buscarPorId(id);
        return p.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pista> criar(@RequestBody Pista pista){
        return ResponseEntity.ok(pistaService.criar(pista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pista> atualizar(@PathVariable Integer id, @RequestBody Pista update){
        return ResponseEntity.ok(pistaService.atualizar(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        pistaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
