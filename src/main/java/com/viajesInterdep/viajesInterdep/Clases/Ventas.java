package com.viajesInterdep.viajesInterdep.Clases;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @Column(unique = true, nullable = false)
    private Long ventaId;
    private LocalDateTime fecha;
    private String departamento;
    private String ciudad;
    private String parada;

    public Ventas(Long viajeId, LocalDateTime fecha, String departamento, String ciudad, String parada, Long asiento, Long cedula) {
        this.ventaId = viajeId;
        this.fecha = fecha;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.parada = parada;
        this.asiento = asiento;
        this.cedula = cedula;
    }

    public Ventas(){

    }
    private Long asiento;
    private Long cedula;

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Viajes{" +
                "fecha:" + fecha +
                ", departamento:'" + departamento + '\'' +
                ", ciudad:'" + ciudad + '\'' +
                ", parada:'" + parada + '\'' +
                ", asiento:'" + asiento + '\'' +
                ", cedula:" + cedula +
                '}';
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getParada() {
        return parada;
    }

    public Long getAsiento() {
        return asiento;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public void setAsiento(Long asiento) {
        this.asiento = asiento;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

}
