package ro.lucian_lazar.licenta_backend.mapper;

import org.springframework.stereotype.Component;
import ro.lucian_lazar.licenta_backend.dto.ProductOrderDto;
import ro.lucian_lazar.licenta_backend.entity.Comanda;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import ro.lucian_lazar.licenta_backend.model.ProductOrder;

@Component
public class ProductOrderMapper {

    public static ProductOrderDto toDto(ProductOrder entity) {
        ProductOrderDto dto = new ProductOrderDto();
        dto.setId_comanda(entity.getId_comanda());
        dto.setCantitate(entity.getCantitate());

        if (entity.getComanda() != null) {
            dto.setComandaId(entity.getComanda().getId());
        }

        if (entity.getProdus() != null) {
            dto.setProdusId(entity.getProdus().getId());
        }

        return dto;
    }

    public static ProductOrder toEntity(ProductOrderDto dto, Comanda comanda, Produs produs) {
        ProductOrder entity = new ProductOrder();

        entity.setId_comanda(dto.getId_comanda());
        entity.setCantitate(dto.getCantitate());
        entity.setComanda(comanda);
        entity.setProdus(produs);

        return entity;
    }
}
