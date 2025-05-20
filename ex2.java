package exercicios;

import java.util.Random;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		String[] opcoes = {"Pedra", "Papel", "Tesoura", "Lagarto", "Spock"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Exibir opções
        System.out.println("Escolha uma opção:");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + " - " + opcoes[i]);
        }

        // Jogador escolhe
        System.out.print("Digite o número da sua escolha: ");
        int escolhaJogador = scanner.nextInt();
        if (escolhaJogador < 0 || escolhaJogador >= opcoes.length) {
            System.out.println("Opção inválida! Tente novamente.");
            return;
        }

        // Computador escolhe
        int escolhaComputador = random.nextInt(opcoes.length);

        System.out.println("Você escolheu: " + opcoes[escolhaJogador]);
        System.out.println("Computador escolheu: " + opcoes[escolhaComputador]);

        // Determinar vencedor
        String resultado = determinarVencedor(escolhaJogador, escolhaComputador);
        System.out.println(resultado);

        scanner.close();
    }

    public static String determinarVencedor(int jogador, int computador) {
        if (jogador == computador) {
            return "Empate!";
        }

        if ((jogador == 0 && (computador == 2 || computador == 3)) || // Pedra vence Tesoura e Lagarto
            (jogador == 1 && (computador == 0 || computador == 4)) || // Papel vence Pedra e Spock
            (jogador == 2 && (computador == 1 || computador == 3)) || // Tesoura vence Papel e Lagarto
            (jogador == 3 && (computador == 1 || computador == 4)) || // Lagarto vence Papel e Spock
            (jogador == 4 && (computador == 0 || computador == 2))) { // Spock vence Pedra e Tesoura
            return "Você venceu!";
        } else {
            return "Computador venceu!";
        }
    }
}
