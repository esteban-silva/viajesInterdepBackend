package Clases;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Viajes")
public class Viajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    private LocalDateTime salida;

    public Viajes(LocalDateTime salida) {
        this.salida = salida;
    }


    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

}
