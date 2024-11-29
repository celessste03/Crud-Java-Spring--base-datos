package com.crud.Crud.Modificado.Servicios;
import com.crud.Crud.Modificado.DTO.CarroDTO;
import com.crud.Crud.Modificado.DTO.ServicioDTO;
import com.crud.Crud.Modificado.Entities.Carro;
import com.crud.Crud.Modificado.Entities.Persona;
import com.crud.Crud.Modificado.Entities.Servicio;
import com.crud.Crud.Modificado.Mappers.CarroMapper;
import com.crud.Crud.Modificado.Repository.CarroRepository;
import com.crud.Crud.Modificado.Repository.PersonaRepository;
import com.crud.Crud.Modificado.Repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServicioCarro {

    private final CarroRepository carroRepository;
    private final PersonaRepository personaRepository;
    private final ServicioRepository servicioRepository;
    private final CarroMapper carroMapper;

    @Autowired
    public ServicioCarro(CarroRepository carroRepository, PersonaRepository personaRepository,
                         ServicioRepository servicioRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.personaRepository = personaRepository;
        this.servicioRepository = servicioRepository;
        this.carroMapper = carroMapper;
    }

    public List<CarroDTO> getCarros() {
        return carroRepository.findAll().stream()
                .map(carroMapper::carroToCarroDTO)
                .collect(Collectors.toList());
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.map(carroMapper::carroToCarroDTO);
    }

    public CarroDTO crearCarro(CarroDTO carroDTO) {
        Carro carro = carroMapper.carroDTOToCarro(carroDTO);
        Optional<Persona> persona = personaRepository.findById(carroDTO.getPersonaId());
        if (persona.isPresent()) {
            carro.setPersona(persona.get());
            Set<Servicio> servicios = new HashSet<>();
            for (ServicioDTO servicioDTO : carroDTO.getServicios()) {
                Optional<Servicio> servicio = servicioRepository.findById(servicioDTO.getId());
                servicio.ifPresent(servicios::add);
            }
            carro.setServicios(servicios);
            Carro carroGuardado = carroRepository.save(carro);
            return carroMapper.carroToCarroDTO(carroGuardado);
        } else {
            throw new IllegalArgumentException("Persona no encontrada.");
        }
    }

    public Optional<CarroDTO> actualizarCarro(Long id, CarroDTO detallesCarroDTO) {
        Optional<Carro> carroExistente = carroRepository.findById(id);
        if (carroExistente.isPresent()) {
            Carro carro = carroExistente.get();
            carro.setMarca(detallesCarroDTO.getMarca());
            carro.setModelo(detallesCarroDTO.getModelo());
            carro.setPlaca(detallesCarroDTO.getPlaca());
            Optional<Persona> persona = personaRepository.findById(detallesCarroDTO.getPersonaId());
            persona.ifPresent(carro::setPersona);
            Set<Servicio> servicios = new HashSet<>();
            for (ServicioDTO servicioDTO : detallesCarroDTO.getServicios()) {
                Optional<Servicio> servicio = servicioRepository.findById(servicioDTO.getId());
                servicio.ifPresent(servicios::add);
            }
            carro.setServicios(servicios);
            Carro carroActualizado = carroRepository.save(carro);
            return Optional.of(carroMapper.carroToCarroDTO(carroActualizado));
        }
        return null;
    }

    public boolean EliminarCarro(Long id) {
        return false;
    }

}