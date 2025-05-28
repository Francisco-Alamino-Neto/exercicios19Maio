import java.util.*;

class Hero {
    String nome;
    int forca;
    int inteligencia;
    int velocidade;

    public Hero(String nome, int forca, int inteligencia, int velocidade) {
        this.nome = nome;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.velocidade = velocidade;
    }

    public double poderTotal(double pesoForca, double pesoInteligencia, double pesoVelocidade) {
        return forca * pesoForca + inteligencia * pesoInteligencia + velocidade * pesoVelocidade;
    }

    @Override
    public String toString() {
        return nome + " (Força: " + forca + ", Inteligência: " + inteligencia + ", Velocidade: " + velocidade + ")";
    }
}

public class ex4 {
    static List<Hero> herois = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static double pesoForca = 1.0, pesoInteligencia = 1.0, pesoVelocidade = 1.0;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== RANKING DE SUPER-HERÓIS ===");
            System.out.println("1. Adicionar herói");
            System.out.println("2. Listar ranking");
            System.out.println("3. Comparar dois heróis");
            System.out.println("4. Ajustar fórmula de poder");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> adicionarHeroi();
                case 2 -> listarRanking();
                case 3 -> compararHerois();
                case 4 -> ajustarFormula();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static void adicionarHeroi() {
        System.out.print("Nome do herói: ");
        String nome = sc.nextLine();
        System.out.print("Força (0-100): ");
        int forca = sc.nextInt();
        System.out.print("Inteligência (0-100): ");
        int inteligencia = sc.nextInt();
        System.out.print("Velocidade (0-100): ");
        int velocidade = sc.nextInt();
        sc.nextLine(); // limpar buffer
        herois.add(new Hero(nome, forca, inteligencia, velocidade));
        System.out.println("Herói adicionado com sucesso!");
    }

    static void listarRanking() {
        herois.sort((h1, h2) -> Double.compare(
            h2.poderTotal(pesoForca, pesoInteligencia, pesoVelocidade),
            h1.poderTotal(pesoForca, pesoInteligencia, pesoVelocidade)
        ));
        System.out.println("\n--- RANKING ---");
        for (int i = 0; i < herois.size(); i++) {
            Hero h = herois.get(i);
            System.out.printf("%d. %s - Poder Total: %.2f\n", i + 1, h.toString(),
                h.poderTotal(pesoForca, pesoInteligencia, pesoVelocidade));
        }
    }

    static void compararHerois() {
        if (herois.size() < 2) {
            System.out.println("Você precisa de pelo menos dois heróis cadastrados.");
            return;
        }

        System.out.print("Nome do primeiro herói: ");
        String nome1 = sc.nextLine();
        System.out.print("Nome do segundo herói: ");
        String nome2 = sc.nextLine();

        Hero h1 = encontrarHeroi(nome1);
        Hero h2 = encontrarHeroi(nome2);

        if (h1 == null || h2 == null) {
            System.out.println("Um ou ambos os heróis não foram encontrados.");
            return;
        }

        double poder1 = h1.poderTotal(pesoForca, pesoInteligencia, pesoVelocidade);
        double poder2 = h2.poderTotal(pesoForca, pesoInteligencia, pesoVelocidade);

        System.out.printf("%s: %.2f\n", h1.nome, poder1);
        System.out.printf("%s: %.2f\n", h2.nome, poder2);

        if (poder1 > poder2)
            System.out.println(h1.nome + " é mais poderoso.");
        else if (poder2 > poder1)
            System.out.println(h2.nome + " é mais poderoso.");
        else
            System.out.println("Os dois heróis têm o mesmo poder.");
    }

    static Hero encontrarHeroi(String nome) {
        return herois.stream().filter(h -> h.nome.equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    static void ajustarFormula() {
        System.out.print("Peso para FORÇA: ");
        pesoForca = sc.nextDouble();
        System.out.print("Peso para INTELIGÊNCIA: ");
        pesoInteligencia = sc.nextDouble();
        System.out.print("Peso para VELOCIDADE: ");
        pesoVelocidade = sc.nextDouble();
        sc.nextLine(); // limpar buffer
        System.out.println("Fórmula ajustada!");
    }
}
