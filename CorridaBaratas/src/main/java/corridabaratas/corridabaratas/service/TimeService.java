package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Time;
import corridabaratas.corridabaratas.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {
    private TimeRepository timeRepository;
    public TimeService(TimeRepository timeRepository) {this.timeRepository = timeRepository;}
    public List<Time> listarTime(){return this.timeRepository.findAll();}
}
