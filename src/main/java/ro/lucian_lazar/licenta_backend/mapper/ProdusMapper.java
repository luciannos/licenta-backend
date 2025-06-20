package ro.lucian_lazar.licenta_backend.mapper;

import ro.lucian_lazar.licenta_backend.dto.ProdusDto;
import ro.lucian_lazar.licenta_backend.entity.Produs;

public class ProdusMapper {

    public static ProdusDto toDto(Produs entity) {
        ProdusDto dto = new ProdusDto();
        dto.setId(entity.getId());
        dto.setNume(entity.getNume());
        dto.setPret(entity.getPret());
        return dto;
    }

    public static Produs toEntity(ProdusDto dto) {
        Produs entity = new Produs();
        entity.setId(dto.getId());
        entity.setNume(dto.getNume());
        entity.setPret(dto.getPret());
        return entity;
    }
}