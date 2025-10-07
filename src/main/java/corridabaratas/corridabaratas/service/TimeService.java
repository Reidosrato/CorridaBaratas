package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Time;
import corridabaratas.corridabaratas.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Service
public class TimeService {
    private final TimeRepository timeRepository;
    public TimeService(TimeRepository timeRepository) {this.timeRepository = timeRepository;}
    public List<Time> listarTime(){return this.timeRepository.findAll();}

    public Optional<Time> buscarPorId(Integer id){return timeRepository.findById(id);}

    @Transactional
    public Time criar(Time time){return timeRepository.save(time);}

    @Transactional
    public Time atualizar(Integer id, Time update){
        Time existente = timeRepository.findById(id).orElseThrow(() -> new RuntimeException("Time não encontrado"));
        existente.setNome(update.getNome());
        existente.setCor(update.getCor());
        return timeRepository.save(existente);
    }

    @Transactional
    public void deletar(Integer id){timeRepository.deleteById(id);} 
}
