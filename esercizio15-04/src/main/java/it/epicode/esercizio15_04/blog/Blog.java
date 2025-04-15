package it.epicode.esercizio15_04.blog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="blogs")
public class Blog {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
@Column
private String categoria;
@Column
private String titolo;
@Column
private String contenuto;
@Column
private int tempoDiLettura;
}
