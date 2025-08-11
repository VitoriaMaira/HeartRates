import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
    private String nome;
    private String sobrenome;
    private int dia;
    private int mes;
    private int ano;

    public HeartRates(String nome, String sobrenome, int dia, int mes, int ano) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        LocalDate nascimento = LocalDate.of(ano, mes, dia);
        return Period.between(nascimento, hoje).getYears();
    }

    public int getFrequenciaMaxima() {
        return 220 - getIdade();
    }

    public double getFrequenciaAlvoMin() {
        return getFrequenciaMaxima() * 0.50;
    }

    public double getFrequenciaAlvoMax() {
        return getFrequenciaMaxima() * 0.85;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Dia de nascimento: ");
        int dia = sc.nextInt();

        System.out.print("Mês de nascimento: ");
        int mes = sc.nextInt();

        System.out.print("Ano de nascimento: ");
        int ano = sc.nextInt();

        HeartRates pessoa = new HeartRates(nome, sobrenome, dia, mes, ano);

        System.out.println("\nNome completo: " + nome + " " + sobrenome);
        System.out.println("Idade: " + pessoa.getIdade() + " anos");
        System.out.println("Frequência máxima: " + pessoa.getFrequenciaMaxima() + " bpm");
        System.out.printf("Frequência alvo: %.1f - %.1f bpm\n",
                pessoa.getFrequenciaAlvoMin(), pessoa.getFrequenciaAlvoMax());
      }
}
