package apifarmacia.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_MEDICAMENTO")
    private Long idMedicamento;

    @Column(name = "NOMBRE_MEDICAMENTO")
    private String nombreMedicamento;

    private String fecha;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    private Long cantidad;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
}
