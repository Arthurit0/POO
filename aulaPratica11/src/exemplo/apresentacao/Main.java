package exemplo.apresentacao;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import exemplo.dados.Endereco;
import exemplo.dados.Pessoa;
import exemplo.exceptions.DeleteException;
import exemplo.exceptions.InsertException;
import exemplo.exceptions.SelectException;
import exemplo.negocio.Sistema;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Sistema sistema;
    public static int id_pessoa = 1;
    public static int id_endereco = 1;
    public static void main(String[] args) {
        int op = 0;

        System.out.printf("Digite a senha: ");
        String senha = scanner.nextLine();

        try {
            sistema = new Sistema(senha);
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        do {
            mostraMenu();
            op = Integer.parseInt(scanner.nextLine());

            
            switch (op) {
                case 1:
                    limpaTela();
                    criarPessoa();
                    break;
            
                case 2:
                    limpaTela();
                    verPessoas();
                    break;
                
                case 3:
                    limpaTela();
                    deletarPessoa();
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


    private static void deletarPessoa() {
        verPessoas();
        try {
            List<Pessoa> pessoas = sistema.selectAll();

            System.out.printf("Digite a posição da pessoa a ser excluída: ");

            int pos = Integer.parseInt(scanner.nextLine()) -1;

            Pessoa excluida = pessoas.get(pos);

            sistema.deletePessoa(excluida);
        } catch (SelectException | DeleteException e) {
            
            System.err.println(e.getMessage());
        }


    }


    private static void verPessoas() {
        try {
            List<Pessoa> pessoas = sistema.selectAll();

            for(Pessoa p : pessoas){
                System.out.println(p);
                System.out.println();
            }
            
        } catch (SelectException e) {
            System.err.println(e.getMessage());
        }
    }


    private static void criarPessoa() {

        System.out.println("Criando pessoa...");

        int idNovaPessoa = id_pessoa;
        id_pessoa++;
        System.out.printf("\nDigite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.printf("Digite o cpf da pessoa: ");
        int cpf = Integer.parseInt(scanner.nextLine());
        System.out.printf("Digite o telefone da pessoa: ");
        int telefone = Integer.parseInt(scanner.nextLine());

        System.out.printf("\nCriando Endereço");

        int idNovoEndereco = id_endereco;
        id_endereco++;
        System.out.printf("\nDigite o nome da rua: ");
        String rua = scanner.nextLine();
        System.out.printf("Digite o número da casa: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.printf("Digite o nome da cidade: ");
        String cidade = scanner.nextLine();

        Endereco endereco = new Endereco(idNovoEndereco, rua, numero, cidade);
        Pessoa pessoa = new Pessoa(idNovaPessoa, nome, cpf, telefone, endereco);

        try {
            sistema.inserirPessoa(pessoa);
            System.out.println();
        } catch (InsertException | SelectException e) {
            System.err.println(e.getMessage());
        }
    }


    private static void mostraMenu() {
            System.out.println("|======== Menu de Opções ========|");
            System.out.println("| 1 - Criar Pessoa               |");
            System.out.println("| 2 - Ver pessoas cadastradas    |");
            System.out.println("| 3 - Deletar pessoa             |");
            System.out.println("| 4 -           |");        
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