package it.epicode.esercizio3;

public class RubricaTelefonica {
    String nome;
    int telefono;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefono() {
        return telefono;
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
