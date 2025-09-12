package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Memorial;
import corridabaratas.corridabaratas.service.MemorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/memorial")

public class MemorialController {
    private MemorialService memorialService;
    public MemorialController(MemorialService memorialService) {this.memorialService = memorialService;}
    @GetMapping("/listar")

    public ResponseEntity<List<Memorial>>listarMemorial() {return ResponseEntity.ok(memorialService.listarMemorial());}
}
