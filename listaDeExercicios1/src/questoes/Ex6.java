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

        char V[] = new char[L1+L2];
        int indexV = 0, contV = 0;

        //Coletando letras iguais em ambas as Strings
        for (int i=0; i<L1; i++){
            for (int j=0; j<L2; j++){
                if (S1.toLowerCase().charAt(i) == S2.toLowerCase().charAt(j)){
                    F = F + S1.toUpperCase().charAt(i);

                    if (indexV == 0){
                        V[indexV] = S1.toUpperCase().charAt(i);
                        indexV++;
                    }else{
                        for (int k=0; k<indexV;k++){
                            if (S1.toUpperCase().charAt(i) == V[k]){
                                contV++;
                            }
                        }
                        if (contV == 0){
                            V[indexV] = S1.toUpperCase().charAt(i);
                            indexV++;
                        }
                        contV = 0;
                    }
                    

                }
            }
        }

        System.out.println(F);
        System.out.println(V);
    }
}
