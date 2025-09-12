package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Leaderboards;
import corridabaratas.corridabaratas.service.LeaderboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/leaderboards")
public class LeaderboardsController {
    private LeaderboardService leaderboardService;
    public LeaderboardsController(LeaderboardService leaderboardService) {this.leaderboardService = leaderboardService;}
    @GetMapping("/listar")
    public ResponseEntity<List<Leaderboards>>listarLeaderboards(){return ResponseEntity.ok(leaderboardService.listarLeaderboards());}
}
