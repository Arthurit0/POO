package apresentacao;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op = 0;

        do {
            mostraMenu();
            op = Integer.parseInt(scanner.nextLine());

            
            switch (op) {
                case 1:
                    limpaTela();    
                    break;
            
                case 2:
                    limpaTela();
                    break;
                
                case 3:
                    limpaTela();
                    break;

                case 4:
                    limpaTela();
                    break;

                case 0:
                    System.exit(0);
                    break;
                
                default:
                    System.out.printf("\nOpção inválida, tente novamente! ");
                    break;
            }

            System.out.printf("Pressione Enter para continuar...");
            scanner.nextLine();
            limpaTela();
          
        } while (op != 0);
    }

    private static void mostraMenu() {
            System.out.println("|======== Menu de Opções ========|");
            System.out.println("| 1 -           |");
            System.out.println("| 2 -           |");
            System.out.println("| 3 -           |");
            System.out.println("| 4 -           |");        
            System.out.println("| 0 -           |");
            System.out.println("|================================|");
            System.out.printf("\nSelecione uma opção: ");
    }

    private static void limpaTela() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
