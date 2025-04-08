package it.epicode.pizza_express_2.tavoli;
import org.springframework.stereotype.Service;

@Service
public class TavoloService  {

    // creare tavolo
    public Tavolo creaTavolo(int numeroTavolo, int numeroCoperti) {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(2);
        tavolo.setNumeroCoperti(1);
        tavolo.setStato(Stato.LIBERO);
        return tavolo;
    }
}
