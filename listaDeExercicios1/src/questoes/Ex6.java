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
        scanner.close();

        int L1 = S1.length();
        int L2 = S2.length();

        String V = new String();
        V = "";
        int indexV = 0, contV = 0;

        //Comparando cada letra da primeira string com a da segunda. 
        for (int i=0; i<L1; i++){
            for (int j=0; j<L2; j++){
                if (S1.toLowerCase().charAt(i) == S2.toLowerCase().charAt(j)){

                    //if guarda a primeira letra encontrada em ambas as strings na primeira posição da string
                    if (indexV == 0){
                        V = V + S1.toUpperCase().charAt(i);
                        indexV++;
                    }else{
                        //Percorrendo vetor do início até o contador indexV
                        for (int k=0; k<indexV;k++){
                            //Comparando se a letra igual encontrada pelos dois fors já está na string V, se estiver,
                            //o contador aumenta para que não entre no próximo if
                            if (S1.toUpperCase().charAt(i) == V.toUpperCase().charAt(k)){
                                contV++;
                            }
                        }
                        //if para filtrar se a letra encontrada se repetiu na string, se não for o caso,
                        //a letra será guardada na próxima posição de V
                        if (contV == 0){
                            V = V + S1.toUpperCase().charAt(i);
                            indexV++;
                        }
                        contV = 0;
                    }
                }
            }
        }
        System.out.println(V);

        //Ordenando em ordem Alfabética
        
    }
}
