package questoes;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma String: ");
        String S = scanner.next();
        System.out.println();

        int SLength = S.length();
        String RS = "";

        for (int i = (SLength-1); i>=0; i--){
            RS = RS + S.charAt(i);
        }

        if(S.toLowerCase().equals(RS.toLowerCase())){
            System.out.printf("\""+S+"\" é um palíndromo!");
        }else{
            System.out.printf("\""+S+"\" não é um palíndromo!");
        }

        int contV=0, contC=0;
        for (int i=0; i<SLength; i++){
            if((S.toLowerCase().charAt(i) == 'a')||
            (S.toLowerCase().charAt(i) == 'e')||
            (S.toLowerCase().charAt(i) == 'i')||
            (S.toLowerCase().charAt(i) == 'o')||
            (S.toLowerCase().charAt(i) == 'u')){
                contV++;
            }else{
                contC++;
            }
        }

        System.out.println(" Possui "+contV+" vogais e "+contC+" consoantes.\nA string invertida é \""+RS+"\".");
        scanner.close();
    }
    
}
