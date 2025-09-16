package corridabaratas.corridabaratas.dto.response;

import java.time.LocalDateTime;

public class HistoricoDTOResponse {
    private String id;
    private LocalDateTime data;
    private String resultado;
    private String cockroachId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCockroachId() {
        return cockroachId;
    }

    public void setCockroachId(String cockroachId) {
        this.cockroachId = cockroachId;
    }
}
