package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Obstaculo;
import corridabaratas.corridabaratas.service.ObstaculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/obstaculo")
public class ObstaculoController {

    private final ObstaculoService obstaculoService;

    public ObstaculoController(ObstaculoService obstaculoService) {this.obstaculoService = obstaculoService;}

    @GetMapping("/listar")

    public ResponseEntity<List<Obstaculo>>listarObstaculo(){return ResponseEntity.ok(obstaculoService.listarObstaculo());}
}
