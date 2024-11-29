package com.crud.Crud.Modificado.Mappers;
import com.crud.Crud.Modificado.DTO.ServicioDTO;
import com.crud.Crud.Modificado.Entities.Servicio;
import org.springframework.stereotype.Component;

@Component
public class ServicioMapper {

    public ServicioDTO servicioToServicioDTO(Servicio servicio) {
        if (servicio == null) {
            return null;
        }

        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setId(servicio.getId());
        servicioDTO.setNombre(servicio.getNombre());
        servicioDTO.setDescripcion(servicio.getDescripcion());

        return servicioDTO;
    }

    public Servicio servicioDTOToServicio(ServicioDTO servicioDTO) {
        if (servicioDTO == null) {
            return null;
        }

        Servicio servicio = new Servicio();
        servicio.setId(servicioDTO.getId());
        servicio.setNombre(servicioDTO.getNombre());
        servicio.setDescripcion(servicioDTO.getDescripcion());

        return servicio;
    }
}
