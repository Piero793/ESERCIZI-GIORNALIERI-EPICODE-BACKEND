package it.epicode.esercizio15_04.blog;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {
    @NotBlank(message = "Inserisci una categoria")
    private String categoria;
    @NotBlank(message = "Inserisci un titolo")
    private String titolo;
    @NotEmpty(message = "Inserisci un contenuto")
    private String contenuto;
    @NotEmpty(message = "Inserisci un tempo di lettura")
    private int tempoDiLettura;
    @NotEmpty(message = "Inserisci un autore")
    private Long autoreId;
}
