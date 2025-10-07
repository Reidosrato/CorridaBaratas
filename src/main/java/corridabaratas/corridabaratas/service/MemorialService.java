package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Memorial;
import corridabaratas.corridabaratas.repository.MemorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Service
public class MemorialService {
    private final MemorialRepository memorialRepository;

    public MemorialService(MemorialRepository memorialRepository) {this.memorialRepository = memorialRepository;}

    public List<Memorial> listarMemorial(){return this.memorialRepository.findAll();}

    public Optional<Memorial> buscarPorId(Integer id){return memorialRepository.findById(id);}

    @Transactional
    public Memorial criar(Memorial memorial){return memorialRepository.save(memorial);}

    @Transactional
    public Memorial atualizar(Integer id, Memorial update){
        Memorial existente = memorialRepository.findById(id).orElseThrow(() -> new RuntimeException("Memorial não encontrado"));
        existente.setCausa(update.getCausa());
        existente.setDatamorte(update.getDatamorte());
        return memorialRepository.save(existente);
    }

    @Transactional
    public void deletar(Integer id){memorialRepository.deleteById(id);} 
}
