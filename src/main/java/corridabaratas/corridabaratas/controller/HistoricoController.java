package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Historico;
import corridabaratas.corridabaratas.service.HistoricoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/historico")
public class HistoricoController {
    private final HistoricoService historicoService;
    public HistoricoController(HistoricoService historicoService) {this.historicoService = historicoService;}
    @GetMapping("/listar")
    public ResponseEntity<List<Historico>>listarHistorico(){return ResponseEntity.ok(historicoService.listarHistorico());}

    @GetMapping("/{id}")
    public ResponseEntity<Historico> getById(@PathVariable Integer id){
        Optional<Historico> h = historicoService.buscarPorId(id);
        return h.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Historico> criar(@RequestBody Historico historico){
        return ResponseEntity.ok(historicoService.criar(historico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historico> atualizar(@PathVariable Integer id, @RequestBody Historico update){
        return ResponseEntity.ok(historicoService.atualizar(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        historicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
