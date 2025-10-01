package corridabaratas.corridabaratas.dto.request;

import java.util.List;

public class TimeDTORequest {
    private String nome;
    private String cor;
    private List<String> baratas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<String> getBaratas() {
        return baratas;
    }

    public void setBaratas(List<String> baratas) {
        this.baratas = baratas;
    }
}
