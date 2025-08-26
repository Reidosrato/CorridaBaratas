package corridabaratas.corridabaratas.repository;

import corridabaratas.corridabaratas.entity.Barata;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository

public interface BarataRepository extends JpaRepository<Barata, Integer> {
}
