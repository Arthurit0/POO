package Ex2;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Trapezio trapezio1 = new Trapezio();
        Losango losango1 = new Losango();
        Circulo circulo1 = new Circulo();

        System.out.println("==================================================");
        System.out.println("Calculando Trapézio com dados do usuário:\n");
        System.out.printf("Digite o valor da base menor do Trapézio: ");
        trapezio1.setBaseMenor(Integer.parseInt(scanner.nextLine()));
        System.out.printf("Digite o valor da base maior do Trapézio: ");
        trapezio1.setBaseMaior(Integer.parseInt(scanner.nextLine()));
        System.out.printf("Digite o valor da altura do Trapézio: ");
        trapezio1.setAltura(Integer.parseInt(scanner.nextLine()));

        System.out.println("\n-> Resultado do Trapézio nº1:\n\n"+trapezio1.toString());

        System.out.printf("\nPressione Enter para continuar...");
        scanner.nextLine();

        System.out.println("\n==================================================");

        System.out.println("Calculando Losango com dados do usuário:\n");
        System.out.printf("Digite o valor da diagonal menor do Losango: ");
        losango1.setd(Integer.parseInt(scanner.nextLine()));
        System.out.printf("Digite o valor da diagonal maior do Losango: ");
        losango1.setD(Integer.parseInt(scanner.nextLine()));

        System.out.println("\n-> Resultado do Losango nº1:\n\n"+losango1.toString());
        System.out.printf("\nPressione Enter para continuar...");
        scanner.nextLine();

        System.out.println("\n==================================================");
        System.out.println("Calculando Círculo com dados do usuário:\n");
        System.out.printf("Digite o valor do raio do círculo: ");
        circulo1.setRaio(Integer.parseInt(scanner.nextLine()));

        System.out.println("\n-> Resultado do Círculo nº1:\n\n"+circulo1.toString());
        System.out.printf("\nPressione Enter para continuar...");
        scanner.nextLine();
        System.out.println("\n==================================================");
        System.out.println("=> Testes padrão:");

        Trapezio trapezio2 = new Trapezio(5,20,12);
        Losango losango2 = new Losango(9,16);
        Circulo circulo2 = new Circulo(7);

        System.out.println("\n-> Resultado do Trapézio nº2:\n\n"+trapezio2.toString());
        System.out.println("\n-> Resultado do Losango nº2:\n\n"+losango2.toString());
        System.out.println("\n-> Resultado do Círculo nº2:\n\n"+circulo2.toString());
        System.out.printf("\nPressione Enter para fechar o programa...");
        scanner.nextLine();

    }
}
