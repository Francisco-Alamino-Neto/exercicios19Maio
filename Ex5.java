

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	
	int votosA = 0, votosB = 0, votosC = 0, votosTotais = 0;
	System.out.println("Vote em um ds seguintes mascotes:");
	System.out.println("1 - Mascote A;");
	System.out.println("2 - Mascote B;");
	System.out.println("3 - Mascote C;");
	System.out.println("Digite 'Fim' para sair da votação.");
	
	while (true) {
        System.out.print("Digite seu voto (1, 2 ou 3): ");
        String voto = sc.nextLine().toLowerCase();

        // Conta o voto de acordo com a opção
        switch (voto) {
            case "1":
                votosA++;
                votosTotais++;
                System.out.println("Você votou no Mascote A.");
                System.out.println("Votos totais: " + votosTotais);
                break;
            case "2":
                votosB++;
                votosTotais++;
                System.out.println("Você votou no Mascote B.");
                System.out.println("Votos totais: " + votosTotais);
                break;
            case "3":
                votosC++;
                votosTotais++;
                System.out.println("Você votou no Mascote C.");
                System.out.println("Votos totais: " + votosTotais);
                break;
            default:
                System.out.println("Voto inválido! Por favor, digite 1, 2 ou 3.");
                break;
        }
     // Verifica se o usuário quer sair e coloca os resultados
        if (voto.equals("fim")) {
        	double porcentagemA = (votosTotais > 0) ? (100.0 * votosA / votosTotais) : 0;
        	double porcentagemB = (votosTotais > 0) ? (100.0 * votosB / votosTotais) : 0;
        	double porcentagemC = (votosTotais > 0) ? (100.0 * votosC / votosTotais) : 0;
        	System.out.println("Votos totais: " +  votosTotais);
        	System.out.printf("Mascote A: %d votos (%.2f%%)\n", votosA, porcentagemA);
        	System.out.printf("Mascote B: %d votos (%.2f%%)\n", votosB, porcentagemB);
        	System.out.printf("Mascote C: %d votos (%.2f%%)\n", votosC, porcentagemC);
        	break;
        }
	}
	}
}