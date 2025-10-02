package corridabaratas.corridabaratas.dto.response;

import java.time.LocalDateTime;

public class UsuarioDTOResponse {
    private String id;
    private String nome;
    private LocalDateTime dataregistro;
    private String nacionalidade;

    private String login;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getDataregistro() {
        return dataregistro;
    }

    public void setDataregistro(LocalDateTime dataregistro) {
        this.dataregistro = dataregistro;
    }

    public LocalDateTime getDataRegistro() {
        return dataregistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataregistro = dataRegistro;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
