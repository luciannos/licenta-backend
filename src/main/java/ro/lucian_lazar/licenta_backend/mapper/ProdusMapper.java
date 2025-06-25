package ro.lucian_lazar.licenta_backend.mapper;

import org.springframework.stereotype.Component;
import ro.lucian_lazar.licenta_backend.dto.ProdusDto;
import ro.lucian_lazar.licenta_backend.entity.Produs;

@Component
public class ProdusMapper {

    public Produs dtoToEntity(ProdusDto dto) {
        if (dto == null) {
            return null;
        }
        return new Produs(
                dto.getId(),
                dto.getDenumire(),
                dto.getDescriere(),
                dto.getCategorie(),
                dto.getPret(),
                dto.getImagine(),
                dto.getStoc(),
                dto.getNumarVanzari()
        );
    }

    public ProdusDto entityToDto(Produs entity) {
        if (entity == null) {
            return null;
        }
        return new ProdusDto(
                entity.getId(),
                entity.getDenumire(),
                entity.getDescriere(),
                entity.getCategorie(),
                entity.getPret(),
                entity.getImagine(),
                entity.getStoc(),
                entity.getNumarVanzari()
        );
    }
}
