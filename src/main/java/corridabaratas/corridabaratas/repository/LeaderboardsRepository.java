package corridabaratas.corridabaratas.repository;

import corridabaratas.corridabaratas.entity.Leaderboards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardsRepository extends JpaRepository<Leaderboards, Integer> {
}
