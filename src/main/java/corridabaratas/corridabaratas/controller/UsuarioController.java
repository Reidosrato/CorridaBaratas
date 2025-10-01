package corridabaratas.corridabaratas.controller;

import corridabaratas.corridabaratas.entity.Usuario;
import corridabaratas.corridabaratas.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {this.usuarioService = usuarioService;}
    @GetMapping("/listar")

    public ResponseEntity<List<Usuario>>listarUsuario(){return ResponseEntity.ok(usuarioService.listarUsuario());}
}
