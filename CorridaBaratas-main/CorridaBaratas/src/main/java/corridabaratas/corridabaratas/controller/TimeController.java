package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Time;
import corridabaratas.corridabaratas.service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/time")
public class TimeController {
    private TimeService timeService;

    public TimeController (TimeService timeService) {this.timeService = timeService;}
    @GetMapping("/listar")
    public ResponseEntity<List<Time>>listarTime(){return ResponseEntity.ok(timeService.listarTime());}
}
