package corridabaratas.corridabaratas.repository;

import corridabaratas.corridabaratas.entity.Pista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PistaRepository extends JpaRepository<Pista, Integer> {
}
