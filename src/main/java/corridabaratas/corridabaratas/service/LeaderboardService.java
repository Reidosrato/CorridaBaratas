package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Leaderboards;
import corridabaratas.corridabaratas.repository.LeaderboardsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Service
public class LeaderboardService {
    private final LeaderboardsRepository leaderboardsRepository;

    public LeaderboardService(LeaderboardsRepository leaderboardsRepository) {this.leaderboardsRepository = leaderboardsRepository;}
    public List<Leaderboards> listarLeaderboards(){return this.leaderboardsRepository.findAll();}

    public Optional<Leaderboards> buscarPorId(Integer id){return leaderboardsRepository.findById(id);}

    @Transactional
    public Leaderboards criar(Leaderboards leaderboards){return leaderboardsRepository.save(leaderboards);}

    @Transactional
    public Leaderboards atualizar(Integer id, Leaderboards update){
        Leaderboards existente = leaderboardsRepository.findById(id).orElseThrow(() -> new RuntimeException("Leaderboards não encontrada"));
        existente.setRank(update.getRank());
        return leaderboardsRepository.save(existente);
    }

    @Transactional
    public void deletar(Integer id){leaderboardsRepository.deleteById(id);} 
}
