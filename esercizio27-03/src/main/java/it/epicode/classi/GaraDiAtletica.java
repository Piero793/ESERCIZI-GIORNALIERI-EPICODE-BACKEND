package it.epicode.classi;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento{

    @ManyToMany
    private Set<Persona> atleti = new HashSet<>();

    @OneToOne
    private Persona vincitore;
}
