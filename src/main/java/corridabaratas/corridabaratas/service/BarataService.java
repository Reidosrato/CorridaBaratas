package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Barata;
import corridabaratas.corridabaratas.repository.BarataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarataService {
    private final BarataRepository barataRepository;
    public BarataService(BarataRepository barataRepository) { this.barataRepository = barataRepository;}

    public List<Barata> listarBarata(){return this.barataRepository.findAll();}
}
