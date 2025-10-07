package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Leaderboards;
import corridabaratas.corridabaratas.service.LeaderboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/leaderboards")
public class LeaderboardsController {
    private final LeaderboardService leaderboardService;
    public LeaderboardsController(LeaderboardService leaderboardService) {this.leaderboardService = leaderboardService;}
    @GetMapping("/listar")
    public ResponseEntity<List<Leaderboards>>listarLeaderboards(){return ResponseEntity.ok(leaderboardService.listarLeaderboards());}

    @GetMapping("/{id}")
    public ResponseEntity<Leaderboards> getById(@PathVariable Integer id){
        Optional<Leaderboards> l = leaderboardService.buscarPorId(id);
        return l.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Leaderboards> criar(@RequestBody Leaderboards leaderboards){
        return ResponseEntity.ok(leaderboardService.criar(leaderboards));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leaderboards> atualizar(@PathVariable Integer id, @RequestBody Leaderboards update){
        return ResponseEntity.ok(leaderboardService.atualizar(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        leaderboardService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
