package com.crud.Crud.Modificado.Mappers;
import com.crud.Crud.Modificado.DTO.PersonaDTO;
import com.crud.Crud.Modificado.Entities.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

    public PersonaDTO personaToPersonaDTO(Persona persona) {
        if (persona == null) {
            return null;
        }

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setId(persona.getCedula());

        return personaDTO;
    }

    public Persona personaDTOToPersona(PersonaDTO personaDTO) {
        if (personaDTO == null) {
            return null;
        }

        Persona persona = new Persona();
        persona.setId(personaDTO.getId());
        persona.setNombre(personaDTO.getNombre());
        persona.setCedula(personaDTO.getCedula());

        return persona;
    }
}
