package school.entities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arma {

    private final Random rand = new Random();

    private List<Balas> pente;

    public Arma() {
        this.pente = new ArrayList<>();
    }

    public void recarregarArma() {
        JOptionPane.showMessageDialog(null,"Recarregando arma ...");
        int x = rand.nextInt(8 - 1) + 1;

        for (int i = 1; i <= x; i++) {
            pente.add(new Balas(rand.nextBoolean()));
        }
    }

    private long qtdRecarregada() {

        return pente.stream().filter(Balas::getStatus).count();
    }

    public List<Balas> getPente() {
        return pente;
    }

    @Override
    public String toString() {
        return String.format("""
                Balas no pente = %s
                Recarregadas = %d e vazias = %d""", pente, qtdRecarregada(), pente.size() - qtdRecarregada());
    }
}
