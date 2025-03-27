package it.epicode.classi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "partite_di_calcio")
public class PartitaDiCalcio extends Evento{

    @Column
    private String squadraDiCasa;

    @Column
    private String squadraOspite;

    @Column
    private String squadraVincente;

    @Column
    private Integer golSquadraDiCasa;

    @Column
    private Integer golSquadraOspite;
}
