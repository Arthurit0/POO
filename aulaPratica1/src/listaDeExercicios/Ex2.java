package listaDeExercicios;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        String tempNome, nomes[] = new String[5];
        int tempIdade, idades[] = new int[5];
        Scanner scr = new Scanner(System.in);

        //Scanneando
        for(int i=0; i<5; i++){
            System.out.println("Digite o nome da pessoa "+(i+1));
            nomes[i] = scr.next();
            
            System.out.println("Digite a idade do(a) "+nomes[i]);
            idades[i] = scr.nextInt();
        }

        //verificando maior e ordenando nomes e idades
        for(int i=0; i<5; i++){
            for (int j=i+1; j<5; j++){

                if(idades[j]>idades[i]){
                tempIdade = idades[i];
                idades[i] = idades[j];
                idades[j] = tempIdade;

                tempNome = nomes[i];
                nomes[i] = nomes[j];
                nomes[j] = tempNome;
            }
        }
    }

        //Imprimindo nomes
        for(int i=0; i<5; i++){
            System.out.println("Posição "+(i+1)+": "+nomes[i]);
        }

        scr.close();
    }
}
