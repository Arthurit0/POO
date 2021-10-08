package questoes;

import java.util.Arrays;
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
        scanner.close();

        int L1 = S1.length();
        int L2 = S2.length();

        char V[] = new char[26];
        int indexV = 0; 
        boolean repetV = false;

        //Comparando cada letra da primeira string com a da segunda. 
        for (int i=0; i<L1; i++){
            for (int j=0; j<L2; j++){
                if (S1.toLowerCase().charAt(i) == S2.toLowerCase().charAt(j)){

                    //if guarda a primeira letra encontrada em ambas as strings na primeira posição do vetor de array
                    if (indexV == 0){
                        V[indexV] = S1.toUpperCase().charAt(i);
                        indexV++;
                    }else{
                        //Percorrendo vetor do início até o contador indexV
                        for (int k=0; k<indexV;k++){
                            //Comparando se a letra igual encontrada pelos dois fors já está no array V, se estiver,
                            //repetV indicará true
                            if (S1.toUpperCase().charAt(i) == V[k]){
                                repetV = true;
                                break;
                            }
                        }
                        //if para filtrar se a letra encontrada se repetiu no array V, se não for o caso,
                        //a letra será guardada na próxima posição de V
                        if (repetV == false){
                            V[indexV] = S1.toUpperCase().charAt(i);
                            indexV++;
                        }
                        repetV = false;
                    }
                }
            }
        }

        Arrays.sort(V);
        System.out.printf("As letras presentes em ambas as strings (e ordenadas alfabeticamente) são: ");
        System.out.println(V);
    }
}
