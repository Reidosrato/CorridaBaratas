package corridabaratas.corridabaratas.repository;

import corridabaratas.corridabaratas.entity.Obstaculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObstaculoRepository extends JpaRepository <Obstaculo, Integer> {
}
