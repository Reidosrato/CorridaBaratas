package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Barata;
import corridabaratas.corridabaratas.repository.BarataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

@Service
public class BarataService {
    private final BarataRepository barataRepository;
    public BarataService(BarataRepository barataRepository) { this.barataRepository = barataRepository;}

    public List<Barata> listarBarata(){return this.barataRepository.findAll();}

    public Optional<Barata> buscarPorId(Integer id){return this.barataRepository.findById(id);}

    @Transactional
    public Barata criar(Barata barata){
        return barataRepository.save(barata);
    }

    @Transactional
    public Barata atualizar(Integer id, Barata update){
        Barata existente = barataRepository.findById(id).orElseThrow(() -> new RuntimeException("Barata não encontrada"));
        existente.setNome(update.getNome());
        existente.setVelocidade(update.getVelocidade());
        existente.setAgilidade(update.getAgilidade());
        existente.setVida(update.getVida());
        existente.setCor(update.getCor());
        existente.setNacionalidade(update.getNacionalidade());
        existente.setGenero(update.getGenero());
        return barataRepository.save(existente);
    }

    @Transactional
    public void deletar(Integer id){
        barataRepository.deleteById(id);
    }
}
