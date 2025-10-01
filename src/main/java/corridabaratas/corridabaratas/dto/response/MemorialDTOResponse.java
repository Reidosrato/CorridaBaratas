package corridabaratas.corridabaratas.dto.response;

import java.time.LocalDateTime;

public class MemorialDTOResponse {
    private String id;
    private String cockroachId;
    private LocalDateTime deathDate;
    private String cause;
    private String raceId;
    private Integer turn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCockroachId() {
        return cockroachId;
    }

    public void setCockroachId(String cockroachId) {
        this.cockroachId = cockroachId;
    }

    public LocalDateTime getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDateTime deathDate) {
        this.deathDate = deathDate;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
