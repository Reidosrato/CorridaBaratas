package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Historico;
import corridabaratas.corridabaratas.service.HistoricoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/historico")
public class HistoricoController {
    private final HistoricoService historicoService;
    public HistoricoController(HistoricoService historicoService) {this.historicoService = historicoService;}
    @GetMapping("/listar")
    public ResponseEntity<List<Historico>>listarHistorico(){return ResponseEntity.ok(historicoService.listarHistorico());}
}
