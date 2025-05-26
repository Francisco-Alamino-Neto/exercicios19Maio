

import java.util.Scanner;

public class Ex4 {

	// Função para verificar se um número é primo
    public static boolean ehPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Função para verificar se a senha contém pelo menos um número primo
    public static boolean senhaContemPrimo(String senha) {
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (Character.isDigit(c)) {
                int numero = Character.getNumericValue(c);
                if (ehPrimo(numero)) {
                    return true;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	
	System.out.println("Digite sua senha: ");
	String senha = sc.nextLine();
	
	 // Verifica se a senha contém pelo menos um número primo
    if (senhaContemPrimo(senha)) {
        switch (senha) {
   	 case String s when !s.matches(".*[A-Z].*"): //Caso não contenha letra maiuscula, executa syso.
           System.out.println("Senha inválida, não contém letra maiúscula");
           break;
   	 case String s when !s.matches(".*[!@#$%^&*(),.?\":{}|<>].*"): //Caso não contenha caractere especial, executa syso.
            System.out.println("Senha inválida, não contém caractere especial");
            break;
   	 case String s when s.matches(".*[aeiouAEIOU]{2,}.*"): //Caso contenha vogais duplicadas seguidas, executa syso.
            System.out.println("Senha inválida, contém 2 ou mais vogais duplicadas seguidas");
            break;
            default:
           	 System.out.print(senha + ", senha válida");
         }
    } else {
        System.out.println("Senha inválida: deve conter pelo menos um número primo.");
    }
    
	sc.close();
	}
}