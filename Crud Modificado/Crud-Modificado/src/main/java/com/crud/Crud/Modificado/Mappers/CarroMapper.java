package com.crud.Crud.Modificado.Mappers;

import com.crud.Crud.Modificado.DTO.CarroDTO;
import com.crud.Crud.Modificado.DTO.ServicioDTO;
import com.crud.Crud.Modificado.Entities.Carro;
import com.crud.Crud.Modificado.Entities.Persona;
import com.crud.Crud.Modificado.Entities.Servicio;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CarroMapper {

    public CarroDTO carroToCarroDTO(Carro carro) {
        if (carro == null) {
            return null;
        }

        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(carro.getId());
        carroDTO.setMarca(carro.getMarca());
        carroDTO.setModelo(carro.getModelo());
        carroDTO.setPlaca(carro.getPlaca());

        if (carro.getPersona() != null) {
            carroDTO.setPersonaId(carro.getPersona().getId());
        }

        Set<ServicioDTO> servicioDTOs = carro.getServicios().stream()
                .map(this::servicioToServicioDTO)
                .collect(Collectors.toSet());
        carroDTO.setServicios(servicioDTOs);

        return carroDTO;
    }

    public Carro carroDTOToCarro(CarroDTO carroDTO) {
        if (carroDTO == null) {
            return null;
        }

        Carro carro = new Carro();
        carro.setId(carroDTO.getId());
        carro.setMarca(carroDTO.getMarca());
        carro.setModelo(carroDTO.getModelo());
        carro.setPlaca(carroDTO.getPlaca());

        Set<Servicio> servicioDTOs = carroDTO.getServicios().stream()
                .map(this::servicioDTOToServicio)
                .collect(Collectors.toSet());
        carro.setServicios(servicioDTOs);

        return carro;
    }

    private ServicioDTO servicioToServicioDTO(Servicio servicio) {
        if (servicio == null) {
            return null;
        }

        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setId(servicio.getId());
        servicioDTO.setNombre(servicio.getNombre());
        servicioDTO.setDescripcion(servicio.getDescripcion());

        return servicioDTO;
    }

    private Servicio servicioDTOToServicio(ServicioDTO servicioDTO) {
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
