package com.viajesInterdep.viajesInterdep.Clases;

import javax.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String departamentoNombre;

    public Departamento(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }


    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }


    public String getDepartamentoNombre() {
        return departamentoNombre;
    }
}