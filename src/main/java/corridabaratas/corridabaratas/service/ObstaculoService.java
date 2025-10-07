package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Obstaculo;
import corridabaratas.corridabaratas.repository.ObstaculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Service

public class ObstaculoService {
    private final ObstaculoRepository obstaculoRepository;
    public ObstaculoService(ObstaculoRepository obstaculoRepository) {this.obstaculoRepository = obstaculoRepository;}
    public List<Obstaculo> listarObstaculo(){return this.obstaculoRepository.findAll();}

    public Optional<Obstaculo> buscarPorId(Integer id){return obstaculoRepository.findById(id);}

    @Transactional
    public Obstaculo criar(Obstaculo obstaculo){return obstaculoRepository.save(obstaculo);}

    @Transactional
    public Obstaculo atualizar(Integer id, Obstaculo update){
        Obstaculo existente = obstaculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Obstaculo não encontrado"));
        existente.setTipo(update.getTipo());
        existente.setDescricao(update.getDescricao());
        return obstaculoRepository.save(existente);
    }

    @Transactional
    public void deletar(Integer id){obstaculoRepository.deleteById(id);} 
}
