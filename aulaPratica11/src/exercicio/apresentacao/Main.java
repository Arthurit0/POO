package exercicio.apresentacao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import exercicio.negocio.ListaTelefonica;
import exercicio.dados.Contato;
import exercicio.exceptions.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ListaTelefonica listaTelefonica;
    public static void main(String[] args) {
        int op = 0;

        System.out.printf("Digite a senha: ");
        String senha = scanner.nextLine();

        try {
            listaTelefonica = new ListaTelefonica(senha);
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        limpaTela();

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
                    verContatos();
                    break;
                
                case 3:
                    limpaTela();
                    editarContato();
                    break;

                case 4:
                    limpaTela();
                    deletarContato();
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

    private static void deletarContato() {
        verContatos();

        System.out.printf("Digite a letra inicial do nome do contato a ser deletado: ");
        Character chave = scanner.nextLine().toUpperCase().charAt(0);

        try {
            List<Contato> listaLetra = listaTelefonica.getAllContatos().get(chave);

            if(!(listaLetra.isEmpty())){

                imprimeContatosDaChave(listaTelefonica.getAllContatos().get(chave));

                System.out.printf("Digite a posição do contato a ser deletado: ");

                int pos = Integer.parseInt(scanner.nextLine());

                if(pos < listaLetra.size()){
                    Contato excluido = listaLetra.get(pos);

                    listaTelefonica.removeContato(excluido);
                    System.out.printf("\nContato Deletado! ");
                }
            }else{
                System.out.println("Não há contato com esta letra! ");
            }

        } catch (SelectException | DeleteException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void editarContato() {
        verContatos();

        System.out.printf("Digite a letra inicial do nome do contato a ser editado: ");
        Character chave = scanner.nextLine().toUpperCase().charAt(0);

        try {
            List<Contato> listaLetra = listaTelefonica.getAllContatos().get(chave);
            
            if(!(listaLetra.isEmpty())){
                
            imprimeContatosDaChave(listaTelefonica.getAllContatos().get(chave));
            
            System.out.printf("Digite a posição do contato a ser editado: ");

            int pos = Integer.parseInt(scanner.nextLine());

            if(pos < listaLetra.size()){
                Contato atualizado = listaLetra.get(pos);

                System.out.printf("\nDigite o nome do contato: ");
                atualizado.setNome(scanner.nextLine());
                System.out.printf("Digite o telefone do contato: ");
                atualizado.setTelefone(Integer.parseInt(scanner.nextLine()));

                listaTelefonica.atualizaContato(atualizado);
                System.out.printf("\nContato Atualizado! ");
            }
        }else{
            System.out.printf("Não há contato com esta letra! ");
        }

        } catch (SelectException | UpdateException e) {
            System.err.println(e.getMessage());
        }

    }

    private static void imprimeContatosDaChave(List<Contato> lista) {
        //Não utilizei toString pois o formato que fiz é para o Map, e não apenas para alguma chave
        
        System.out.println("\nLista da Inicial:\n");
        
        for (int i = 0; i < lista.size(); i++) {
            String nome = lista.get(i).getNome();
            int telefone = lista.get(i).getTelefone();

            System.out.printf("Pos["+i+"]: ");
            System.out.println(nome+", "+telefone);
        }
        System.out.println();
    }

    private static void verContatos() {
        System.out.println("Lista de Contatos (número entre colchetes é o ID do contato):\n");

        try {
            listaTelefonica.getAllContatos().forEach((chave, contatos) ->{
                System.out.println(chave + ":");

                contatos.forEach(contato ->{
                    System.out.println("   "+contato);
                }
                );
            }
            );
        } catch (SelectException e) {
            System.err.println(e.getMessage());
        }
        System.out.println();
    }

    private static void adicionarContato() {
        Contato novoContato = new Contato();

        System.out.println("Criando Contato:\n");

        System.out.printf("Digite o nome do contato: ");
        novoContato.setNome(scanner.nextLine());
        System.out.printf("Digite o telefone do contato: ");
        novoContato.setTelefone(Integer.parseInt(scanner.nextLine()));

        try {
            listaTelefonica.adicionaContato(novoContato);
            System.out.printf("\nContato adicionado! ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void mostraMenu() {
            System.out.println("|======== Menu de Opções ========|");
            System.out.println("| 1 - Adicionar Novo Contato     |");
            System.out.println("| 2 - Ver Contatos               |");
            System.out.println("| 3 - Editar Contato             |");
            System.out.println("| 4 - Deletar Contato            |");    
            System.out.println("| 0 - Sair                       |");
            System.out.println("|================================|");
            System.out.printf("\nSelecione uma opção: ");
    }

    private static void limpaTela() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
