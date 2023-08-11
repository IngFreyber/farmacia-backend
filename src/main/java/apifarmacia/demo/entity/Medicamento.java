package apifarmacia.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "MEDICAMENTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "LABORATORIO_FABRICA")
    private String laboratorioFabrica;

    @Column(name = "FECHA_FABRICACION")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFabricacion;

    @Column(name = "FECHA_VENCIMIENTO")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimiento;

    @Column(name = "CANTIDAD_STOCK")
    private Long cantidadStock;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;
}
