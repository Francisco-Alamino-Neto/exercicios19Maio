package exercicios;

import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite as sequências separadas por espaço (ex: 4H 7A 2C):");
        
        String entradaUsuario = scanner.nextLine(); // Lê a entrada do usuário
        String[] sequencias = entradaUsuario.split(" "); // Divide a entrada em um array
        
        String resultado = reconstruirCodigo(sequencias);
        System.out.println("Código reconstruído: " + resultado);
        
        scanner.close();
    }

    public static String reconstruirCodigo(String[] sequencias) {
        StringBuilder codigo = new StringBuilder();
        for (String item : sequencias) {
            int numero = Integer.parseInt(item.replaceAll("[^0-9]", "")); // Extrai o número
            char letra = item.replaceAll("[^A-Za-z]", "").charAt(0); // Extrai a letra
            codigo.append(String.valueOf(letra).repeat(numero)); // Repete a letra
        }
        return codigo.toString();
    }
}
