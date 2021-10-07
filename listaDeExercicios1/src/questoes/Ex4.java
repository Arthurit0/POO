package questoes;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número:");
        int N = scanner.nextInt();

        System.out.println("Digite 'e' para Exponenciação ou 'r' para Resto da Divisão: ");
        String o = scanner.next();

        if(o.equals("e")){
            System.out.println("\n=> Opção escolhida foi \"Exponenciação\".\n");
            System.out.println("Digite o expoente da exponenciação: ");
            int e = scanner.nextInt();
    
            int P = N;
            for (int i = 1; i<e; i++){
                P = P*N;
            }

            System.out.println("\nO número "+N+" elevado a "+e+" é igual a "+P);

        }else if(o.equals("r")){
            System.out.println("\n=> Opção escolhida foi \"Resto da Divisão\".\n");
            System.out.println("Por qual número deseja dividir "+N+"?");

            int D = scanner.nextInt();
            int R = N - (D*(N/D));

            System.out.println("\nO resto da divisão de "+N+" por "+D+" é igual a "+R);

        }else{
            System.out.println("\nOperação inválida, tente novamente");
        }

        scanner.close();


    }


}
