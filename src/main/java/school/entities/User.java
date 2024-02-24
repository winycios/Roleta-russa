package school.entities;

import javax.swing.*;
import java.util.Random;

import static java.lang.System.exit;

/**
 * The type User.
 */
public class User {

    private final Random rand = new Random();
    private String username;
    private Integer lives;
    private Integer pontuacao;

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param lives    the lives
     */
    public User(String username, Integer lives) {
        this.username = username;
        this.lives = lives;
        this.pontuacao = 0;
    }

    /**
     * Atirar.
     *
     * @param arma    the arma
     * @param escolha the escolha
     */
    public void atirar(Arma arma, Boolean escolha) {

        int value = rand.nextInt(arma.getPente().size());

        // A bala esta carregada e atirou em si mesmo
        if (arma.getPente().get(value).getStatus() && escolha) {
            lives -= 1;

            JOptionPane.showMessageDialog(null, "powwww !!!!!");
            verificarVida();
            JOptionPane.showMessageDialog(null, "Estamos te revivendo !!!!");

            // A bala esta carregada mas atirou reto
            // A bala não esta carregada mas atirou em si mesmo
        } else if ((arma.getPente().get(value).getStatus() && !escolha) || (!arma.getPente().get(value).getStatus() && escolha)) {
            pontuacao += 1;
            JOptionPane.showMessageDialog(null, "Acertou !!!!!");

        } else {
            JOptionPane.showMessageDialog(null, "Errou . . .");
        }

        arma.getPente().remove(value);
        verificarPente(arma);

    }

    public void verificarPente(Arma arma) {

        if (arma.getPente().isEmpty()) {
            arma.recarregarArma();

            JOptionPane.showMessageDialog(null, arma);
        }
    }

    public String verDados(String message) {
        return String.format("""
                %s
                Nome: %s
                Vidas: %d
                Pontuação: %d""", message, getUsername(), getLives(), getPontuacao());
    }

    private void verificarVida() {

        if (lives == 0) {
            JOptionPane.showMessageDialog(null, verDados("Fim de jogo!!"));
            exit(0);
        }
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets lives.
     *
     * @return the lives
     */
    public Integer getLives() {
        return lives;
    }

    /**
     * Gets pontuacao.
     *
     * @return the pontuacao
     */
    public Integer getPontuacao() {
        return pontuacao;
    }

    @Override
    public String toString() {
        return "User : " + username + ", lives=" + lives + ", Pontuação = " + pontuacao;
    }
}
