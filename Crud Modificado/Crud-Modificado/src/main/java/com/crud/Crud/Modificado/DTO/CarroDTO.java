package com.crud.Crud.Modificado.DTO;
import java.util.Set;
import java.util.stream.Stream;

public class CarroDTO {

    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private Long personaId;
    private Set<ServicioDTO> servicioDTOs;
    private Set<ServicioDTO> servicios;

    public CarroDTO(Long id, String marca, String modelo, String placa, Long personaId) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.personaId = personaId;
    }

    public CarroDTO() {
        
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    /*public ServicioDTO[] getServicios() {
        return new ServicioDTO[0];
    }

    public void setServicios(Set<ServicioDTO> servicioDTOs) {
        this.servicioDTOs = servicioDTOs;
    }*/
    public Set<ServicioDTO> getServicios() {

        Set<ServicioDTO> servicios = null;
        return servicios; } // Asegúrate de tener el setter para servicios

    public void setServicios(Set<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

}