package questoes;

import java.util.Random;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int n, m;
    
        System.out.println("Digite o tamanho das linhas das matrizes"); 
        n = scanner.nextInt();
        System.out.println("Digite o tamanho das colunas das matrizes");
        m = scanner.nextInt();


        int m1[][] = new int[n][m];
        int m2[][] = new int[n][m];


        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                m1[i][j] = 1 + rand.nextInt(100);
                m2[i][j] = 1 + rand.nextInt(100);
            }
        }

        System.out.println("\nMatriz m1:\n");
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.printf(m1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matriz m2:\n");
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.printf(m2[i][j]+" ");
            }
            System.out.println();
        }


        int m3[][] = new int[n][m];
        
        int T;
        if (n<m){
            T = n;
        }else{
            T = m;
        }
        //m4 sempre será uma matriz quadrada (para ter uma diagonal principal)
        //do menor valor entre n e m, para que sempre seja possível comparar 
        //entre as posições m1[i][j] e m2[i][j] sem que fique "out of bounds"
        int m4[][] = new int[T][T];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ((m1[i][j])>(m2[i][j])){
                    m3[i][j] = m1[i][j];
                }else{
                    m3[i][j] = m2[i][j];
                }
            }
        }

        for (int i=0; i<T; i++){
            for (int j=0; j<T; j++){
                if (j>=i){
                    m4[i][j] = 0;
                }else{
                    if ((m1[i][j])<(m2[i][j])){
                        m4[i][j] = m1[i][j];
                    }else{
                        m4[i][j] = m2[i][j];
                    }
                }
            }
        }

        System.out.println("\nMatriz m3:\n");
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.printf(m3[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz m4:\n");
        for (int i=0; i<T; i++){
            for (int j=0; j<T; j++){
                System.out.printf(m4[i][j]+" ");
            }
            System.out.println();
        }

        scanner.close();
    
}
}
