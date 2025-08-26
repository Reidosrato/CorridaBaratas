package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Memorial;
import corridabaratas.corridabaratas.repository.MemorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemorialService {
    private MemorialRepository memorialRepository;

    public MemorialService(MemorialRepository memorialRepository) {this.memorialRepository = memorialRepository;}

    public List<Memorial> listarMemorial(){return this.memorialRepository.findAll();}
}
