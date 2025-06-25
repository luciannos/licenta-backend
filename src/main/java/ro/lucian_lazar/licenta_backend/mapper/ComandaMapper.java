package ro.lucian_lazar.licenta_backend.mapper;

import org.springframework.stereotype.Component;
import ro.lucian_lazar.licenta_backend.dto.ComandaDto;
import ro.lucian_lazar.licenta_backend.dto.DetaliuComandaDto;
import ro.lucian_lazar.licenta_backend.entity.Comanda;
import ro.lucian_lazar.licenta_backend.entity.DetaliuComanda;

import java.util.stream.Collectors;

@Component
public class ComandaMapper {

    public ComandaDto toDto(Comanda comanda) {
        if (comanda == null) {
            return null;
        }

        ComandaDto dto = new ComandaDto();
        dto.setId(comanda.getId());
        dto.setIdUtilizator(comanda.getUtilizator().getId());
        dto.setUserName(comanda.getUtilizator().getNume() + " " + comanda.getUtilizator().getPrenume());
        dto.setDataComanda(comanda.getData_comenzii());
        dto.setStatus(comanda.getStatus());
        dto.setTotal(comanda.getTotal());
        dto.setAdresaLivrare(comanda.getAdresaLivrare());
        if (comanda.getDetaliiComanda() != null) {
            dto.setDetaliiComanda(comanda.getDetaliiComanda().stream()
                    .map(this::toDetaliuDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    private DetaliuComandaDto toDetaliuDto(DetaliuComanda detaliu) {
        if (detaliu == null) {
            return null;
        }
        DetaliuComandaDto dto = new DetaliuComandaDto();
        dto.setIdProdus(detaliu.getProdus().getId());
        dto.setCantitate(detaliu.getCantitate());
        dto.setPretUnitar(detaliu.getPret_unitar());
        dto.setDenumireProdus(detaliu.getProdus().getDenumire());
        return dto;
    }
} 