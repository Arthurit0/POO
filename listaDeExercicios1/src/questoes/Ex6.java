package questoes;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a String nº1: ");
        String S1 = scanner.next();
        System.out.println("\nDigite a String nº2: ");
        String S2 = scanner.next();

        int L1 = S1.length();
        int L2 = S2.length();

        String F = "";
        //Coletando letras iguais em ambas as strings
        for (int i=0; i<L1; i++){
            for (int j=0; j<L2; j++){
                if (S1.toLowerCase().charAt(i) == S2.toLowerCase().charAt(j)){
                    F = F + S1.toUpperCase().charAt(i);
                }
            }
        }

        System.out.println(F+"\n");

        //Identificando repetições e substituindo por espaços vazios
        int L3 = F.length();
        char F2[] = F.toCharArray();
        int spacecont = 0;

        for (int i = 0; i<L3; i++){
            for (int j=0; j<L3; j++){
                if((F2[i] == F2[j])&&(i!=j)){
                   F2[j] = ' ';
                }
            }
        }

        for (int i=0; i<L3;)

        System.out.println("VALORES: "+L3+" e "+spacecont);
        System.out.println(F2);
    
        //Criando vetor sem espaços
        char F3[] = new char[L3-spacecont];
        int F3Index = 0;

        for(int i=0; i<L3; i++){
            if(F2[i] != ' '){
                F3[F3Index] = F2[i];
                F3Index++;
            }
        }

        System.out.println(F3);

        scanner.close();

    }

}
