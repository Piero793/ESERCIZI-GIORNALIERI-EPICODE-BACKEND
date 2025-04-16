package it.epicode.esercizio15_04.autori;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.esercizio15_04.blog.Blog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autori")
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String email;
    @Column
    private String dataDiNascita;

    @OneToMany(mappedBy = "autore")
    @JsonIgnore
    private List<Blog> blog;
}
