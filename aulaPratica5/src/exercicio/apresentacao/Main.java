package exercicio.apresentacao;

import java.util.List;
import java.util.Scanner;

import exercicio.dados.Contato;
import exercicio.negocio.ListaTelefonica;

public class Main {
    private static ListaTelefonica listaTelefonica = new ListaTelefonica();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op = 0;

        do {
            mostraMenu();
            op = Integer.parseInt(scanner.nextLine());

            
            switch (op) {
                case 1:
                    limpaTela();    
                    adicionarContato();
                    break;
            
                case 2:
                    limpaTela();
                    removerContato();
                    break;
                
                case 3:
                    limpaTela();
                    exibirContatos();
                    break;

                case 4:
                    limpaTela();
                    System.out.printf("Digite a inicial do contato: ");
                    char chave = scanner.nextLine().toUpperCase().charAt(0);

                    exibirContatos(chave);
                    
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


    private static void exibirContatos(char chave) {
        List<Contato> contatosLetra = listaTelefonica.buscarContatos(chave);


        if(contatosLetra != null){
            for (int i = 0; i < contatosLetra.size(); i++) {
                System.out.println("\nCódigo "+i+": ");
                System.out.println(contatosLetra.get(i));
            }
            System.out.println();
        }else{
            System.out.printf("Não há contato com esta inicial! ");
        }
    }


    private static void exibirContatos() {
        listaTelefonica.buscarContatos().forEach((chave, contatos) ->{
            System.out.println(chave + ":");

            contatos.forEach(contato ->{
                System.out.println("   "+contato);
            }
            );
        }
        );
        System.out.println();
    }


    private static void removerContato() {
        char chave;
        int cod;
        System.out.printf("Digite a inicial do contato que deseja remover: ");
        chave = scanner.nextLine().toUpperCase().charAt(0);

        if(listaTelefonica.buscarContatos(chave).size()>0){
            exibirContatos(chave);

            System.out.printf("Digite o código do contato que deseja remover: ");
            cod = Integer.parseInt(scanner.nextLine());

            if (cod < listaTelefonica.buscarContatos(chave).size()){
                listaTelefonica.buscarContatos(chave).remove(cod);
                System.out.println();
            }else{
                System.out.printf("\nNão há contato com este código! ");
            }

        }else{
            System.out.printf("\nNão há contato com esta inicial! ");
        }
    }

    private static void adicionarContato() {
        listaTelefonica.adicionaContato(novoContato());
    }

    private static Contato novoContato() {
        Contato contato = new Contato();

        System.out.printf("Digite o nome do contato: ");
        contato.setNome(scanner.nextLine());
        System.out.printf("Digite o número do contato: ");
        contato.setTelefone(Integer.parseInt(scanner.nextLine()));
        System.out.println();

        return contato;
    }

    private static void mostraMenu() {
            System.out.println("|======== Menu de Opções ========|");
            System.out.println("| 1 - Adicionar Contato          |");
            System.out.println("| 2 - Remover Contato            |");
            System.out.println("| 3 - Exibir Contatos            |");
            System.out.println("| 4 - Exibir Contatos (letra)    |");        
            System.out.println("| 0 - Sair do programa           |");
            System.out.println("|================================|");
            System.out.printf("\nSelecione uma opção: ");
    }

    private static void limpaTela() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
