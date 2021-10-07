package questoes;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maiorAtual=0;

        System.out.println("Digite o tamanho do array:");
        int T = scanner.nextInt();
        int V[] = new int[T];

        for (int i=0; i<T; i++){
            System.out.println("Digite o valor na posição ["+i+"]:");
            V[i] = scanner.nextInt();
            
            if (i==0){
                maiorAtual = V[i];
            }

            maiorAtual = buscaMaior(V, maiorAtual, i);
            if (i<(T-1)){
                System.out.println("\n-> Maior valor atual: "+maiorAtual+"\n");
            }else{
                System.out.println("\n => RESULTADO: O maior valor do vetor é "+maiorAtual+"\n");
            }

        }
        scanner.close();
    }

    public static int buscaMaior(int vetor[], int maiorAtual, int indice){
        int maior = maiorAtual;
        for(int i=0; i<=indice; i++){
            if(vetor[i]>maiorAtual){
                maior = vetor[i];
            }
        }
        return maior;
    }
}
