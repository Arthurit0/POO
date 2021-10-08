package questoes;

import java.util.Scanner;

public class ExExtra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma string:");
        String P = scanner.next();
        scanner.close();
        int L = P.length();
        
        //Teclas:  2,3,4,5,6,7,8,9 
        int T[] = {0,0,0,0,0,0,0,0};

        for(int i=0; i<L; i++){
            switch(P.toLowerCase().charAt(i)){
                case 'a':
                    T[0]++;
                    break;

                case 'b':
                    T[0] = T[0]+2;
                    break;

                case 'c':
                    T[0] = T[0]+3;
                    break;

                case 'd':
                    T[1]++;
                    break;

                case 'e':
                    T[1] = T[1]+2;
                    break;

                case 'f':
                    T[1] = T[1]+3;
                    break;

                case 'g':
                    T[2]++;
                    break;

                case 'h':
                    T[2] = T[2]+2;
                    break;

                case 'i':
                    T[2] = T[2]+3;
                    break;

                case 'j':
                    T[3]++;
                    break;

                case 'k':
                    T[3] = T[3]+2;
                    break;

                case 'l':
                    T[3] = T[3]+3;
                    break;
                
                case 'm':
                    T[4]++;
                    break;

                case 'n':
                    T[4] = T[4]+2;
                    break;

                case 'o':
                    T[4] = T[4]+3;
                    break;

                case 'p':
                    T[5]++;
                    break;

                case 'q':
                    T[5] = T[5]+2;
                    break;

                case 'r':
                    T[5] = T[5]+3;
                    break;
                
                case 's':
                    T[5] = T[5]+4;
                    break;
                
                case 't':
                    T[6]++;
                    break;

                case 'u':
                    T[6] = T[6]+2;
                    break;

                case 'v':
                    T[6] = T[6]+3;
                    break;
                
                case 'w':
                    T[7]++;
                    break;

                case 'x':
                    T[7] = T[7]+2;
                    break;

                case 'y':
                    T[7] = T[7]+3;
                    break;
                
                case 'z':
                    T[7] = T[7]+4;
                    break;
            }
        } 
        
        System.out.println("\nPara a obtenção da palavra \""+P+"\":\n");
        for(int i = 0; i<8; i++){
            if(T[i]!=0){
                System.out.println("A Tecla "+(i+2)+" será apertada "+T[i]+" vez(es)");
            }
        }
    }
}
