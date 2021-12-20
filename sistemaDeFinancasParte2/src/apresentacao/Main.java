package apresentacao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dados.Gasto;
import dados.User;
import negocio.Financas;
import exceptions.*;

public class Main {
    static Financas financas;
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String[] args) {
        int opLogin = 0, opMenu = 0;

        System.out.printf("Digite a senha do Banco de Dados: ");
        String senhaBdD = scanner.nextLine();

        try {
            financas = new Financas(senhaBdD);
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        boolean LoginBemSucedido = false;

        do {

            do {
                limpaTela();
                menuDeLogin();

                opLogin = Integer.parseInt(scanner.nextLine());

                switch (opLogin) {
                    case 1:
                    limpaTela();
                    System.out.println("\nDigite o login e senha do usuário:\n");
                    System.out.printf("Login: ");
                    String login = scanner.nextLine();
                    System.out.printf("Senha: ");
                    String senha = scanner.nextLine();
    
                    try {
                        LoginBemSucedido = financas.login(login, senha);
                    } catch (SelectException | UsuarioNaoExisteException | SenhaIncorretaException e) {
                        System.err.println(e.getMessage());
                        scanner.nextLine();
                    }
                        
                        break;
                
                    case 2:
                        limpaTela();
                        criaUsuario();
                        break;
                    
                    case 3:
                        limpaTela();
                        deletaUsuario();
                    
                    default:
                        break;
                }




            } while (LoginBemSucedido == false);

            mostraMenu();
            opMenu = Integer.parseInt(scanner.nextLine());
            
            switch (opMenu) {
                case 1:
                    limpaTela();
                    adcionarGasto();
                    break;
            
                case 2:
                    limpaTela();
                    verGastos();
                    break;
                
                case 3:
                    limpaTela();
                    editarGasto();
                    break;

                case 4:
                    limpaTela();
                    deletarGasto();
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
          
        } while (opMenu != 0);
    }

    private static void deletaUsuario() {
        System.out.printf("Digite o login do usuário a ser deletado: ");
        String login =  scanner.nextLine();

        try {
            financas.rmv(login);
        } catch (DeleteException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void criaUsuario() {
        User user = new User();
        
        System.out.println("Criando Usuário...\n");

        System.out.printf("Digite o nome do seu usuário: ");
        user.setLogin(scanner.nextLine());
        System.out.printf("Digite a senha do usuário: ");
        user.setSenha(scanner.nextLine());

        try {
            financas.add(user);
        } catch (InsertException | SelectException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void deletarGasto() {
        verGastos();

        try {
            List<Gasto> gastos = financas.seeAll();

            System.out.printf("Digite a posição do gasto que deseja deletar: ");
            int pos = Integer.parseInt(scanner.nextLine());

            Gasto deletado = gastos.get(pos);

            financas.rmv(deletado);
            
        } catch (SelectException | DeleteException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void editarGasto() {
        verGastos();

        try {
            List<Gasto> gastos = financas.seeAll();

            System.out.printf("Digite a posição do gasto que deseja editar: ");
            int pos = Integer.parseInt(scanner.nextLine());

            Gasto editado = gastos.get(pos);

            System.out.printf("\nDigite o nome do gasto: ");
            editado.setNome(scanner.nextLine());
            System.out.printf("Digite uma descrição para o gasto: ");
            editado.setDescricao(scanner.nextLine());
            System.out.printf("Digite a data do gasto (formato \"dia/mês/ano\"): ");
            
            try {
                editado.setData(sdf.parse(scanner.nextLine()));
            } catch (ParseException e) {
                e.printStackTrace();
            
            }
            System.out.printf("Digite o valor do gasto: ");
            editado.setValor(Float.parseFloat(scanner.nextLine()));
            imprimeCategorias();
            System.out.printf("Digite o número da categoria que se encaixa com o gasto: ");
            editado.setCategoria(Integer.parseInt(scanner.nextLine()));

            financas.updt(editado);

        } catch (SelectException | UpdateException e) {
            System.err.print(e.getMessage());
        }

    }

    private static void verGastos() {
        try {
            List<Gasto> gastos = financas.seeAll();

            System.out.println("Lista de gastos: ");

            int i=1;

            for (Gasto g : gastos) {
                System.out.println("Pos["+i+"]: "+g);
                i++;
            }

            System.out.println();


        } catch (SelectException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void adcionarGasto(){
        Gasto gasto = new Gasto();
        System.out.println("Adicionando Gasto...\n");

        System.out.printf("Digite o nome do gasto: ");
        gasto.setNome(scanner.nextLine());
        System.out.printf("Digite uma descrição para o gasto: ");
        gasto.setDescricao(scanner.nextLine());
        System.out.printf("Digite a data do gasto (formato \"dia/mês/ano\"): ");
        
        try {
            gasto.setData(sdf.parse(scanner.nextLine()));
        } catch (ParseException e) {
            e.printStackTrace();
        
        }
        System.out.printf("Digite o valor do gasto: ");
        gasto.setValor(Float.parseFloat(scanner.nextLine()));
        imprimeCategorias();
        System.out.printf("Digite o número da categoria que se encaixa com o gasto: ");
        gasto.setCategoria(Integer.parseInt(scanner.nextLine()));

        try {
            financas.add(gasto);
        } catch (InsertException | SelectException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void imprimeCategorias() {
        System.out.println();
        System.out.println(" 1 - Comida");
        System.out.println(" 2 - Lazer");
        System.out.println(" 3 - Educação");
        System.out.println(" 4 - Saúde");
        System.out.println(" 5 - Transporte");
        System.out.println(" 6 - Outros");
        System.out.println();
    }

    private static void menuDeLogin() {
        System.out.println("|========= Menu de Login ========|");
        System.out.println("| 1 - Fazer Login                |");
        System.out.println("| 2 - Criar Usuário              |");
        System.out.println("| 2 - Deletar Usuário            |");
        System.out.println("| 0 - Sair do Programa           |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");
    }

    private static void mostraMenu() {
            System.out.println("|======  Menu de Finanças  ======|");
            System.out.println("| 1 - Adicionar Gasto            |");
            System.out.println("| 2 - Ver Gastos                 |");
            System.out.println("| 3 - Editar Gasto               |");
            System.out.println("| 4 - Deletar Gasto              |");
            System.out.println("| 5 - Logoff                     |");
            System.out.println("| 0 - Sair do Programa           |");
            System.out.println("|================================|");
            System.out.printf("\nSelecione uma opção: ");
    }

    private static void limpaTela() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
