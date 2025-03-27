package it.epicode.classi;

import it.epicode.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "eventi")
//named questies per fare il getPartiteVinteInCasa
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT e FROM Evento e WHERE e.location.citta = :citta")
//named questies per fare il getPartiteVinteInTrasferta
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT e FROM Evento e WHERE e.location.citta = :citta")
public abstract class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String titolo;

    @Column
    private LocalDate dataEvento;

    @Column
    private String descrizione;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column
    private Integer numeroMassimoPartecipanti;

    @ManyToOne
    private Location location;

    @OneToOne
    private Partecipazione partecipazione;

}
