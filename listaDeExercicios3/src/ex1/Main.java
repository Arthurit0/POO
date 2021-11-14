package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Lista lista = new Lista();
    static Scanner scanner;

    
    public static void main(String[] args) {
        
        try {
            scanner = new Scanner(new File("lista.txt"));
        } catch (FileNotFoundException e) {
            scanner = new Scanner(System.in);
        }
        scanner.nextLine();
        
        
        int op = 0;

        do {
            System.out.println("Digite 1 para adicionar mais uma pessoa a lista, e -1 para sair do Programa");
            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    adicionarPessoa();
                    break;
                
                case -1:
                    System.out.printf("Saindo do Programa! Aperte Enter para continuar...");
                    scanner.nextLine();
                    break;

                default:
                    System.out.printf("Opção inválida, tente novamente! Aperte Enter para continuar...");
                    scanner.nextLine();
                    break;
            }

            

        } while (op != -1);
    }


    static void adicionarPessoa() {
        Pessoa pessoa = new Pessoa();

        System.out.printf("\nDigite o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());
        System.out.printf("Digite o cpf: ");
        pessoa.setCpf(scanner.nextLine());
        System.out.printf("Digite a idade: ");
        pessoa.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.printf("Digite a cidade: ");
        pessoa.setCidade(scanner.nextLine());

        System.out.println("\n");

        lista.adicionaPessoa(pessoa);
        mostrarListaAtual();
    }


    private static void mostrarListaAtual() {
        lista.getLista().forEach((chave,pessoas)->{
            System.out.println("- "+chave+"");

            pessoas.forEach(pessoa ->{
                System.out.println("  "+pessoa);
            });
        });
        System.out.println();
    }
}
