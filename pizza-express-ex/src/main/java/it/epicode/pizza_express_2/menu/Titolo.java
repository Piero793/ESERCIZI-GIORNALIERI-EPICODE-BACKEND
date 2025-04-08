package it.epicode.pizza_express_2.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Titolo implements RigaMenu {
    private String riga;

    @Override
    public String descrizioneRiga() {
        return riga;
    }
}
