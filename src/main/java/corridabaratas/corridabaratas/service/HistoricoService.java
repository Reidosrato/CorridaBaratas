package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Historico;
import corridabaratas.corridabaratas.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HistoricoService {
    private final HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository) {this.historicoRepository = historicoRepository;}

    public List<Historico> listarHistorico(){return this.historicoRepository.findAll();}
}
