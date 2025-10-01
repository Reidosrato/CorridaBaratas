package corridabaratas.corridabaratas.dto.request;

import java.util.List;

public class CorridaDTORequest {
    private String trackId;
    private List<String> participants;
    private String type;

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
}
