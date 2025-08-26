package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Leaderboards;
import corridabaratas.corridabaratas.repository.LeaderboardsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {
    private LeaderboardsRepository leaderboardsRepository;

    public LeaderboardService(LeaderboardsRepository leaderboardsRepository) {this.leaderboardsRepository = leaderboardsRepository;}
    public List<Leaderboards> ListarLeaderboards(){return this.leaderboardsRepository.findAll();}
}
