package questoes;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a String nº1: ");
        String S1 = scanner.next();
        System.out.println();
        System.out.println("Digite a String nº2: ");
        String S2 = scanner.next();
        System.out.println();

        int L1 = S1.length();
        int L2 = S2.length();

        String F = "";
        //Coletando letras iguais em ambas as Strings, separadas por um espaço
        for (int i=0; i<L1; i++){
            for (int j=0; j<L2; j++){
                if (S1.toLowerCase().charAt(i) == S2.toLowerCase().charAt(j)){
                    F = F + S1.toUpperCase().charAt(i) + " ";
                }
            }
        }

        int L3 = F.length();
        char F2[] = F.toCharArray();

        for (int i = 0; i<L3; i++){
            for (int j=0; j<L3; j++){
                if(F2[i] == F2[j]){
                   
                }
            }
        }

        System.out.println(F);

    }
}
