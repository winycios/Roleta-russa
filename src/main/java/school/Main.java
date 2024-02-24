package school;

import school.entities.Arma;
import school.entities.User;

import javax.swing.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Arma espingarda = new Arma();

        JOptionPane.showMessageDialog(null, "Olá, bem vindo a roleta russa do winyc");

        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        Integer life = Integer.valueOf(JOptionPane.showInputDialog("Digite quantas vidas queres ter: "));

        User user = new User(nome, life);

        user.verificarPente(espingarda);
        do {
            int option = Integer.parseInt(JOptionPane.showInputDialog(String.format("""
                    Pontuação = %d e Vida = %d
                    Selecione alguma das opções abaixo:
                    1) Atirar em você mesmo:
                    2) Atirar reto:
                    3) Sair""", user.getPontuacao(), user.getLives())));

            switch (option) {

                case 1: {
                    user.atirar(espingarda, true);
                    break;
                }

                case 2: {
                    user.atirar(espingarda, false);
                    break;
                }

                case 3: {
                    JOptionPane.showMessageDialog(null, user.verDados("Obrigado por jogar!!"));
                    exit(1);
                    break;
                }

                default: {
                    JOptionPane.showMessageDialog(null, "Opção invalida");
                }
            }
        } while (user.getLives() != 0);
    }
}
