package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Obstaculo;
import corridabaratas.corridabaratas.service.ObstaculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/obstaculo")
public class ObstaculoController {

    private final ObstaculoService obstaculoService;

    public ObstaculoController(ObstaculoService obstaculoService) {this.obstaculoService = obstaculoService;}

    @GetMapping("/listar")

    public ResponseEntity<List<Obstaculo>>listarObstaculo(){return ResponseEntity.ok(obstaculoService.listarObstaculo());}

    @GetMapping("/{id}")
    public ResponseEntity<Obstaculo> getById(@PathVariable Integer id){
        Optional<Obstaculo> o = obstaculoService.buscarPorId(id);
        return o.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Obstaculo> criar(@RequestBody Obstaculo obstaculo){
        return ResponseEntity.ok(obstaculoService.criar(obstaculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Obstaculo> atualizar(@PathVariable Integer id, @RequestBody Obstaculo update){
        return ResponseEntity.ok(obstaculoService.atualizar(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        obstaculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
