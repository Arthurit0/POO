package oldMenu;

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
                if(LoginBemSucedido == false){
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
                            System.out.println();
                        } catch (SelectException | UsuarioNaoExisteException | SenhaIncorretaException e) {
                            System.err.printf(e.getMessage());
                        }
                            
                            break;
                    
                        case 2:
                            limpaTela();
                            criaUsuario();
                            break;
                        
                        case 3:
                            limpaTela();
                            deletaUsuario();
                            break;

                        case 0:
                            System.exit(0);
                            break;
                            
                        default:
                            break;
                    }

                    System.out.printf("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limpaTela();
                }
            } while (LoginBemSucedido == false);

            mostraMenu();
            opMenu = Integer.parseInt(scanner.nextLine());
            
            switch (opMenu) {
                case 1:
                    limpaTela();
                    adicionarGasto();
                    break;
            
                case 2:
                    limpaTela();
                    verGastos();
                    break;

                case 3:
                    limpaTela();
                    filtraGastos();
                    break;

                case 4:
                    limpaTela();
                    editarGasto();
                    break;

                case 5:
                    limpaTela();
                    deletarGasto();
                    break;

                case 6:
                    financas.logoff();
                    LoginBemSucedido = false;
                    limpaTela();
                    System.out.println("\nFazendo Logoff...\n");

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

    private static void filtraGastos() {
        System.out.println("|=======  Filtrar Gastos  =======|");
        System.out.println("| Deseja ver os gastos por:      |");
        System.out.println("| 1 - Categoria                  |");
        System.out.println("| 2 - Mês do Gasto               |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");

        int op = Integer.parseInt(scanner.nextLine());

        switch (op) {
            case 1:
                imprimeCategorias();
                System.out.printf("\nSelecione a categoria de Gasto que deseja ver: ");
                int cat = Integer.parseInt(scanner.nextLine());

                try {
                    System.out.println();
                    imprimirGastos(financas.selectGastosFromCategoria(cat));
                } catch (SelectException e) {
                    System.err.println(e.getMessage());
                }
                
                break;

            case 2:
                System.out.printf("\nSelecione qual mês que deseja ver os gastos (entre 1 e 12): ");
                int mes = Integer.parseInt(scanner.nextLine());

                try {
                    System.out.println();
                    imprimirGastos(financas.selectGastosFromMes(mes));
                } catch (SelectException e) {
                    System.err.println(e.getMessage());
                }

        
            default:
                break;
        }


    }

    private static void deletaUsuario() {
        System.out.printf("Digite o login do usuário a ser deletado: ");
        String login =  scanner.nextLine();

        try {
            financas.removeUser(login);
            System.out.println();
        } catch (DeleteException | SelectException e) {
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
            financas.addUser(user);
            System.out.printf("\nUsuário criado com sucesso! ");
        } catch (InsertException | SelectException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void deletarGasto() {
        verGastos();

        try {
            System.out.printf("Digite o ID do gasto que deseja deletar: ");
            
            Gasto deletado = financas.selectGasto(Integer.parseInt(scanner.nextLine()));

            financas.removeGasto(deletado);
            System.out.printf("\nGasto deletado! ");
            
        } catch (SelectException | DeleteException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void editarGasto() {
        verGastos();

            System.out.printf("Digite o ID do gasto que deseja editar: ");

            try {
                Gasto editado = financas.selectGasto(Integer.parseInt(scanner.nextLine()));

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

                System.out.printf("Digite o valor do gasto: R$ ");
                editado.setValor(Float.parseFloat(scanner.nextLine()));
                imprimeCategorias();
                System.out.printf("Digite o número da categoria que se encaixa com o gasto: ");
                editado.setCategoria(Integer.parseInt(scanner.nextLine()));

                try {
                    financas.updateGasto(editado);
                    System.out.printf("\nGasto editado com sucesso! ");
                } catch (UpdateException e) {
                    System.err.println(e.getMessage());
                }

            } catch (NumberFormatException | SelectException e) {
                System.err.printf(e.getMessage());
            }
    }

    private static void verGastos() {
        try {
            List<Gasto> gastos = financas.seeAllGastos();

            System.out.println("Lista de gastos:\n");

            imprimirGastos(gastos);

        } catch (SelectException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void imprimirGastos(List<Gasto> gastos){
        for (Gasto g : gastos) {
            System.out.println(g+"\n");
        }
    }

    private static void adicionarGasto(){
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

        System.out.printf("Digite o valor do gasto: R$ ");
        gasto.setValor(Float.parseFloat(scanner.nextLine()));
        imprimeCategorias();
        System.out.printf("Digite o número da categoria que se encaixa com o gasto: ");
        gasto.setCategoria(Integer.parseInt(scanner.nextLine()));

        try {
            financas.addGasto(gasto);
            System.out.printf("\nGasto registrado com sucesso! ");
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
        System.out.println("| 3 - Deletar Usuário            |");
        System.out.println("| 0 - Sair do Programa           |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");
    }

    private static void mostraMenu() {
            System.out.println("|======  Menu de Finanças  ======|");
            System.out.println("| 1 - Adicionar Gasto            |");
            System.out.println("| 2 - Ver Todos os Gastos        |");
            System.out.println("| 3 - Ver Gastos com Filtro      |");
            System.out.println("| 4 - Editar Gasto               |");
            System.out.println("| 5 - Deletar Gasto              |");
            System.out.println("| 6 - Logoff                     |");
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
