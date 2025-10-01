package corridabaratas.corridabaratas.repository;

import corridabaratas.corridabaratas.entity.Barata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface BarataRepository extends JpaRepository<Barata, Integer> {
}
