package questoes;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soma=0, somaprimo=0, cont=0, maior=0, menor=0;
        int T;

        System.out.println("Insira o tamanho do vetor:");
        T = scanner.nextInt();
        int V[] = new int[T];

        System.out.println("Insira os valores do vetor:");      

        for(int i=0;i<T;i++){
            V[i] = scanner.nextInt();
            if (i==0){
                maior = V[i];
                menor = V[i];
            }
            soma += V[i];
            if (V[i]>maior){
                maior = V[i];
            }
            if (V[i]<menor){
                menor = V[i];
            }
            if (V[i]>1){
                if ((V[i]==2)||(V[i]==3)){
                    somaprimo += V[i];
                }else if (V[i]%2 != 0){
                    for (int j=3; j<=Math.sqrt(V[i]); j=j+2){
                        if (V[i]%j == 0){
                            cont++;
                            break;
                        }
                    }
                    if (cont<1){
                        somaprimo+= V[i];
                    }
                }
            }
            cont=0;
        }
        
        System.out.println("\nVetor:");
        System.out.printf("[");
        for(int i=0; i<(T-1); i++){
            System.out.printf(V[i]+", ");
        }
        System.out.printf(V[T-1]+"]\n");
        System.out.println("\n- Soma dos valores do vetor: "+soma);
        System.out.println("- Menor valor: "+menor);
        System.out.println("- Maior valor: "+maior);
        System.out.println("- Média: "+(soma/T));
        System.out.println("- Soma dos números primos: "+somaprimo);
        scanner.close();
    }   
}
