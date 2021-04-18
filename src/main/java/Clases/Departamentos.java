package Clases;

import javax.persistence.*;

@Entity
@Table(name = "Departamentos")
public class Departamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String departamentoNombre;

    public Departamentos(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }


    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }


    public String getDepartamentoNombre() {
        return departamentoNombre;
    }
}
