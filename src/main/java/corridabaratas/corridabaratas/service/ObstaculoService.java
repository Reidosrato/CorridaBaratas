package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Obstaculo;
import corridabaratas.corridabaratas.repository.ObstaculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ObstaculoService {
    private final ObstaculoRepository obstaculoRepository;
    public ObstaculoService(ObstaculoRepository obstaculoRepository) {this.obstaculoRepository = obstaculoRepository;}
    public List<Obstaculo> listarObstaculo(){return this.obstaculoRepository.findAll();}
}
