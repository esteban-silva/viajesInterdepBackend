package com.viajesInterdep.viajesInterdep.Clases;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Viajes")
public class Viajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long viajeId;
    private String partida;
    private String destino;
    private Long asientosTotales;
    private Short diaSemana;
    private Time hora;

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public Viajes(String partida, String destino, Long asientosTotales, Short diaSemana, Time hora) {
        this.partida = partida;
        this.destino = destino;
        this.asientosTotales = asientosTotales;
        this.diaSemana = diaSemana;
        this.hora = hora;
    }

    public Viajes(){};

    @Override
    public String toString() {
        return "Viajes{" +
                "partida='" + partida + '\'' +
                ", destino='" + destino + '\'' +
                ", asientosTotales=" + asientosTotales +
                ", diaSemana=" + diaSemana +
                ", hora=" + hora +
                '}';
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setAsientosTotales(Long asientosTotales) {
        this.asientosTotales = asientosTotales;
    }

    public void setDiaSemana(Short diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getPartida() {
        return partida;
    }

    public String getDestino() {
        return destino;
    }

    public Long getAsientosTotales() {
        return asientosTotales;
    }

    public Short getDiaSemana() {
        return diaSemana;
    }

    public Time getHora() {
        return hora;
    }






}
