package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Historico;
import corridabaratas.corridabaratas.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Service

public class HistoricoService {
    private final HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository) {this.historicoRepository = historicoRepository;}

    public List<Historico> listarHistorico(){return this.historicoRepository.findAll();}

    public Optional<Historico> buscarPorId(Integer id){return historicoRepository.findById(id);}

    @Transactional
    public Historico criar(Historico historico){return historicoRepository.save(historico);}

    @Transactional
    public Historico atualizar(Integer id, Historico update){
        Historico existente = historicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Historico não encontrado"));
        existente.setData(update.getData());
        existente.setResultado(update.getResultado());
        return historicoRepository.save(existente);
    }

    @Transactional
    public void deletar(Integer id){historicoRepository.deleteById(id);} 
}
