package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Pista;
import corridabaratas.corridabaratas.repository.PistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Service
public class PistaService {
    private final PistaRepository pistaRepository;

    public PistaService(PistaRepository pistaRepository) {this.pistaRepository = pistaRepository;}
    public List<Pista> listarPista(){return this.pistaRepository.findAll();}

    public Optional<Pista> buscarPorId(Integer id){return pistaRepository.findById(id);}

    @Transactional
    public Pista criar(Pista pista){return pistaRepository.save(pista);}

    @Transactional
    public Pista atualizar(Integer id, Pista update){
        Pista existente = pistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pista não encontrada"));
    existente.setNome(update.getNome());
        existente.setDistancia(update.getDistancia());
        existente.setDificuldade(update.getDificuldade());
        return pistaRepository.save(existente);
    }

    @Transactional
    public void deletar(Integer id){pistaRepository.deleteById(id);} 
}
