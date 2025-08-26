package corridabaratas.corridabaratas.repository;

import corridabaratas.corridabaratas.entity.Memorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemorialRepository extends JpaRepository<Memorial, Integer> {
}
