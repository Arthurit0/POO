package listaDeExercicios;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int num, media=0, valores[] = new int[5];

        //scanneando
        for (int i = 0; i<5; i++){
            System.out.println("Digite o valor da posição["+(i+1)+"]:");
            num = scr.nextInt();
            valores[i] = num;
        }
        //media
        for (int i = 0; i<5; i++){
            media += valores[i];
        }

        System.out.println("\nA média é igual a "+(media/5));
        scr.close();
    }
}