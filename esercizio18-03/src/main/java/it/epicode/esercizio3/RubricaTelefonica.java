package it.epicode.esercizio3;

import lombok.Getter;

@Getter
public class RubricaTelefonica {
    String nome;
    int telefono;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public RubricaTelefonica(String nome, int telefono) {
        this.nome = nome;
        this.telefono = telefono;
    }

    public RubricaTelefonica() {
    }


}
