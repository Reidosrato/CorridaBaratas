package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Pista;
import corridabaratas.corridabaratas.repository.PistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PistaService {
    private PistaRepository pistaRepository;

    public PistaService(PistaRepository pistaRepository) {this.pistaRepository = pistaRepository;}
    public List<Pista> listarPista(){return this.pistaRepository.findAll();}
}
