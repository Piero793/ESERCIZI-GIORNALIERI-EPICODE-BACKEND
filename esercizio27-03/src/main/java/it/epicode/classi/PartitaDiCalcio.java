package it.epicode.classi;

import jakarta.persistence.*;
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
        @NamedQuery(
                name = "getPartiteVinteInCasa",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa AND p.location.citta = :citta"
        )
        @NamedQuery(
                name = "getPartiteVinteInTrasferta",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite AND p.location.citta = :citta"
        )

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
