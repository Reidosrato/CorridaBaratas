package corridabaratas.corridabaratas.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CorridaDTOResponse {
    private String id;
    private LocalDateTime date;
    private String trackId;
    private List<String> participants;
    private String type;
    private String status;
    private ResultadoDTO results;
    private SimulacaoDTO simulationData;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultadoDTO getResults() {
        return results;
    }

    public void setResults(ResultadoDTO results) {
        this.results = results;
    }

    public SimulacaoDTO getSimulationData() {
        return simulationData;
    }

    public void setSimulationData(SimulacaoDTO simulationData) {
        this.simulationData = simulationData;
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

    public static class ResultadoDTO {
        private String winner;
        private List<String> ranking;
        private List<MorteDTO> deaths;

        public String getWinner() {
            return winner;
        }

        public void setWinner(String winner) {
            this.winner = winner;
        }

        public List<String> getRanking() {
            return ranking;
        }

        public void setRanking(List<String> ranking) {
            this.ranking = ranking;
        }

        public List<MorteDTO> getDeaths() {
            return deaths;
        }

        public void setDeaths(List<MorteDTO> deaths) {
            this.deaths = deaths;
        }
    }

    public static class MorteDTO {
        private String cockroachId;
        private String cause;
        private Integer turn;

        public String getCockroachId() {
            return cockroachId;
        }

        public void setCockroachId(String cockroachId) {
            this.cockroachId = cockroachId;
        }

        public String getCause() {
            return cause;
        }

        public void setCause(String cause) {
            this.cause = cause;
        }

        public Integer getTurn() {
            return turn;
        }

        public void setTurn(Integer turn) {
            this.turn = turn;
        }
    }

    public static class SimulacaoDTO {
        private List<TurnoDTO> turns;

        public List<TurnoDTO> getTurns() {
            return turns;
        }

        public void setTurns(List<TurnoDTO> turns) {
            this.turns = turns;
        }
    }

    public static class TurnoDTO {
        private Integer number;
        private Map<String, Integer> positions;
        private List<EventoDTO> events;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Map<String, Integer> getPositions() {
            return positions;
        }

        public void setPositions(Map<String, Integer> positions) {
            this.positions = positions;
        }

        public List<EventoDTO> getEvents() {
            return events;
        }

        public void setEvents(List<EventoDTO> events) {
            this.events = events;
        }
    }

    public static class EventoDTO {
        private String type;
        private String cockroachId;
        private String description;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCockroachId() {
            return cockroachId;
        }

        public void setCockroachId(String cockroachId) {
            this.cockroachId = cockroachId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
