package questoes;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu dia de nascimento:");
        int d = scanner.nextInt();
        System.out.println("Digite seu mês de nascimento:");
        int m = scanner.nextInt();
        System.out.println("Digite seu ano de nascimento:");
        int a = scanner.nextInt();

        LocalDate nasc = LocalDate.of(a, m, d);
        LocalDate hoje = LocalDate.now();

        Period p = Period.between(nasc, hoje);

        System.out.println("Sua idade é aproximadamente "+(p.getDays()+p.getMonths()*31+p.getYears()*365)+" dias");
        scanner.close();
    }
}
