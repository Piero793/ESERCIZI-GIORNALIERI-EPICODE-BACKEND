package it.epicode.pizza_express_2.tavoli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tavolo {
    private int numeroTavolo;
    private int numeroCoperti;
    private Stato stato;

}
