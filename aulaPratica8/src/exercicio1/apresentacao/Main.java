package exercicio1.apresentacao;

import java.util.Scanner;

import exercicio1.dados.Pessoa;
import exercicio1.negocio.Sistema;

public class Main {
    private static Sistema sistema = new Sistema();
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int op = -1;

        while (op != 0) {
            imprimeMenu();
            op = Integer.parseInt(s.nextLine());

            switch (op) {
                case 0:
                    break;
                
                case 1:
                    sistema.adicionarPessoa(novaPessoa());
                    break;
                
                case 2:
                    sistema.removerPessoa(escolherPessoa());
                    break;

                case 3:
                    mostrarPessoas();
                    break;
                
                default:
                    System.out.println("Número Inválido!");
                    break;
            }
            
        }


    }

    private static Pessoa novaPessoa() {
        Pessoa p = new Pessoa();

        System.out.printf("Digite o nome: ");
        p.setNome(s.nextLine());
        System.out.printf("Digite a idade: ");
        p.setIdade(Integer.parseInt(s.nextLine()));
        System.out.printf("Digite a altura: ");
        p.setAltura(Float.parseFloat(s.nextLine()));
        System.out.printf("Digite a massa: ");
        p.setMassa(Float.parseFloat(s.nextLine()));

        return p;
    }

    private static void mostrarPessoas() {
        for (int i = 0; i < sistema.getList().size(); i++) {
            System.out.println("Pessoa" + i);
            System.out.println(sistema.getList().get(i));
            System.out.println();
        }
    }

    private static Pessoa escolherPessoa() {
        mostrarPessoas();

        System.out.println("Escolha uma Pessoa:");

        int escolha = Integer.parseInt(s.nextLine());

        if(escolha < sistema.getList().size()){
            return sistema.getList().get(escolha);
        }else{
            return null;
        }
    }

    public static void imprimeMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar pessoa");
        System.out.println("2 - Remover pessoa");
        System.out.println("3 - Mostrar pessoas");
    }
}