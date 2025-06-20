package ro.lucian_lazar.licenta_backend.dto;

import java.util.List;

public class ComandaDto {
    private Long id;
    private String clientName;
    private List<Long> produseComandateIds;

    public ComandaDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Long> getProduseComandateIds() {
        return produseComandateIds;
    }

    public void setProduseComandateIds(List<Long> produseComandateIds) {
        this.produseComandateIds = produseComandateIds;
    }
}
