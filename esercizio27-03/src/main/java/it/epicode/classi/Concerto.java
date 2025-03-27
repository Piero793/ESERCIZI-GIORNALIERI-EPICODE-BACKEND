package it.epicode.classi;

import it.epicode.enums.Genere;
import it.epicode.enums.Streaming;
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
@Table(name = "concerti")
public class Concerto extends Evento {

    @Column
    @Enumerated(EnumType.STRING)
    private Genere genere;

    @Column
    @Enumerated(EnumType.STRING)
    private Streaming streaming;
}
