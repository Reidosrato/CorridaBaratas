package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Pista;
import corridabaratas.corridabaratas.service.PistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pista")
public class PistaController {
    private PistaService pistaService;

    public PistaController(PistaService pistaService) {this.pistaService = pistaService;}

    @GetMapping("/listar")

    public ResponseEntity<List<Pista>>listaPista(){return ResponseEntity.ok(pistaService.listarPista());}
}
