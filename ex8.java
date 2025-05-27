package exercicios;

import java.util.Scanner;
import java.util.Random;

public class ex8 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        double numero1, numero2, resultadoCorreto, resultadoErrado;
        
        System.out.println("=== Calculadora de Cálculos Matematicamente Errados ===");
        System.out.println("Insira o primeiro número: ");
        numero1 = sc.nextDouble();
        
        System.out.println(numero1 + " foi selecionado");
        System.out.println("Insira o operador (+, -, *, /): ");
        char operador = sc.next().charAt(0);
        
        System.out.println(numero1 + " " + operador);
        System.out.println("Insira o segundo número: ");
        numero2 = sc.nextDouble();
        
        switch (operador) {
        case '+':
        	resultadoCorreto = numero1 + numero2;
        	break;
        case '-':
        	resultadoCorreto = numero1 - numero2;
        	break;
        case '*':
        	resultadoCorreto = numero1 * numero2;
        	break;
        case '/':
        	resultadoCorreto = numero1 / numero2;
        	break;
        default:
            System.out.println("Operador inválido.");
            sc.close();
            return;
        }
        double erro = 1 + (random.nextDouble() * 0.01);
        resultadoErrado = resultadoCorreto * erro;
        
        System.out.printf(numero1 + " " + operador + " " + numero2 + " = %.4f\n", resultadoErrado);
        
        sc.close();
    }
}
