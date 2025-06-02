

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	//variável para cada moeda, e varriável semanas
	int umCent, cincoCent, dezCent, vinteCincoCent, cinquentaCent, umReal, semanas;
	//Quantidade de moedas será armazenada na respectiva variável	
	System.out.println("Insira a quantidade de moedas que você colocou no cofre, na respectiva ordem:");
	System.out.println("De 1 centavo: ");
	umCent = sc.nextInt();
	
	System.out.println("De 5 centavos: ");
	cincoCent = sc.nextInt();
	
	System.out.println("De 10 centavos: ");
	dezCent = sc.nextInt();
	
	System.out.println("De 25 centavos:");
	vinteCincoCent = sc.nextInt();
	
	System.out.println("De 50 centavos:");
	cinquentaCent = sc.nextInt();
	
	System.out.println("De 1 real:");
	umReal = sc.nextInt();
	
	double resultado = (0.01 * umCent) + (0.05 * cincoCent) + (0.10 * dezCent) + (0.25 * vinteCincoCent) + (0.50 * cinquentaCent) + (1 * umReal);
	
	double quantofalta = 100 - resultado;
	System.out.println("Você juntou " + resultado + " reais, falta " + quantofalta + " reais para alcançar 100 reais.");
	
	
	  double acumulado = resultado;
      semanas = 0;
      //Sempre que o valor das somas das moedas forem menor que 100, somará o valor delas novamente.
      //Acumulando a quantidade de vezes que isso acontecer na variável "semanas".
      while (acumulado < 100) {
          acumulado += resultado;
          semanas++;
      }
	System.out.println("Levará mais " + semanas + " semanas para juntar 100 reais.");
	}
}
