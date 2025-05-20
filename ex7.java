package exercicios;

import java.util.Scanner;

public class ex7 {

	public static void main(String[] args) {
		String[] feiticos = {"Aceleratio", "Defensio", "Expelliarmus", "Lumos", "Wingardium Leviosa"};
        Scanner scanner = new Scanner(System.in);

        // Exibir a lista de feitiços com numeração
        System.out.println("Lista de feitiços:");
        for (int i = 0; i < feiticos.length; i++) {
            System.out.println(i + " - " + feiticos[i]);
        }

        // Solicitar ao usuário um número
        System.out.print("Digite o número do feitiço que deseja encontrar: ");
        int indiceBuscado = scanner.nextInt();

        if (indiceBuscado >= 0 && indiceBuscado < feiticos.length) {
            System.out.println("Feitiço encontrado: " + feiticos[indiceBuscado] + " na posição " + indiceBuscado);
        } else {
            System.out.println("Número inválido. Feitiço não encontrado.");
        }

        scanner.close();
    }
}
