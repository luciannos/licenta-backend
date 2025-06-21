package ro.lucian_lazar.licenta_backend.mapper;

import ro.lucian_lazar.licenta_backend.dto.ProdusDto;
import ro.lucian_lazar.licenta_backend.entity.Produs;

public class ProdusMapper {

    public static ProdusDto toDto(Produs entity) {
        ProdusDto dto = new ProdusDto();
        dto.setId(entity.getId());
        dto.setDenumire(entity.getDenumire());
        dto.setPret(entity.getPret());
        dto.setStoc(entity.getStoc());
        dto.setCategorie(entity.getCategorie());
        return dto;
    }

    public static Produs toEntity(ProdusDto dto) {
        Produs entity = new Produs();
        entity.setId(dto.getId());
        entity.setDenumire(dto.getDenumire());
        entity.setPret(dto.getPret());
        entity.setStoc(dto.getStoc());
        entity.setCategorie(dto.getCategorie());
        return entity;
    }
}
