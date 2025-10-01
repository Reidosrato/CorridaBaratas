package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Barata;
import corridabaratas.corridabaratas.service.BarataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/barata")
public class BarataController {
private final BarataService barataService;

public BarataController(BarataService barataService) { this.barataService = barataService;}

    @GetMapping("/listar")

    public ResponseEntity<List<Barata>>listarBarata(){
    return ResponseEntity.ok(barataService.listarBarata());
    }
}
