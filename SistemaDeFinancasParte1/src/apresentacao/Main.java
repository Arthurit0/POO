package apresentacao;

import java.util.List;
import java.util.Scanner;
import dados.*;
import negocio.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Financas sys = new Financas();

    public static void main(String[] args) {
        int opLog = -1, opMenu = -1;

        do {
            //Menu de login, em recursão até logar
            do{
                if (sys.verifLog() == false){
                    systemCls();
                    mostraMenuLogin();

                    opLog = Integer.parseInt(scanner.nextLine());
    
                    switch (opLog) {
                        case 1:
                            systemCls();
                            loginDeUsuario();
                            break;
    
                        case 2:
                            systemCls();
                            criaUsuario();
                            break;
                        
                        case 0:
                            return;
                    
                        default:
                            break;
                    }
                    systemPause();
                }
    
            }while(sys.verifLog() == false);
            
            systemCls();

            //Menu das despesas de um usuário
            mostraMenu();

            opMenu = Integer.parseInt(scanner.nextLine());

            switch (opMenu) {
                case 1:
                    systemCls();
                    registrarGasto();
                    break;

                case 2:
                    systemCls();
                    mostrarGastos(sys.getGastos());
                    break;

                case 3:
                    systemCls();
                    filtrarGastos();
                    break;
                    
                case 4:
                    systemCls();
                    editarGasto();
                    break;

                case 5:
                    systemCls();
                    excluirGasto();
                    break;
                

                case 6:
                    sys.logoffUsuario();
                    break;

                case 0:
                    sys.logoffUsuario();
                    return;

                default:
                    break;
            }

            systemPause();
        } while (opMenu != 0);
    }



    private static void excluirGasto() {
        int index;

        mostrarGastos(sys.getGastos());
        System.out.printf("\nDigite o Nº do gasto que deseja excluir: ");
        index = Integer.parseInt(scanner.nextLine());
        index--;

        if(sys.deletaGasto(index)){
            System.out.printf("\nGasto deletado! ");
        }else{
            System.out.printf("\nGasto não foi deletado! ");
        }
    }

    private static void editarGasto() {
        int index, opEdit;

        mostrarGastos(sys.getGastos());
        System.out.printf("\nDigite o Nº do gasto que deseja alterar: ");
        index = Integer.parseInt(scanner.nextLine());
        index--;

        systemCls();

        System.out.println("==============================");
        System.out.println(sys.getGastos().get(index));
        System.out.println("==============================\n");
        mostraMenuEdicao();

        opEdit = Integer.parseInt(scanner.nextLine());
        System.out.println();

        switch (opEdit) {
            case 1:
                String nome;
                System.out.printf("Digite o novo nome: ");
                nome = scanner.nextLine();
                if(sys.editaGastoNome(index, nome)){
                    System.out.printf("\nNome alterado! ");
                }else{
                    System.out.printf("\nNome não foi alterado! ");
                }
                
                break;

            case 2:
                String descricao;
                System.out.printf("Digite a nova descricao: ");
                descricao = scanner.nextLine();
                if(sys.editaGastoDescricao(index, descricao)){
                    System.out.printf("\nDescrição alterada! ");
                }else{
                    System.out.printf("\nDescrição não foi alterada! ");
                }
                
                break;
            
            case 3:
                Data data = new Data();
                System.out.println("Digite a nova data:");
                System.out.printf("-> Dia: ");
                data.setDia(Integer.parseInt(scanner.nextLine()));
                System.out.printf("-> Mês: ");
                data.setMes(Integer.parseInt(scanner.nextLine()));
                System.out.printf("-> Ano: ");
                data.setAno(Integer.parseInt(scanner.nextLine()));

                if(sys.editaGasto(index, data)){
                    System.out.printf("\nData alterada! ");
                }else{
                    System.out.printf("\nData não foi alterada! ");
                }

                break;

            case 4:
                float valor;
                System.out.printf("Digite o novo valor: ");
                valor = Float.parseFloat(scanner.nextLine());

                if(sys.editaGasto(index, valor)){
                    System.out.printf("\nValor foi alterado! ");
                }else{
                    System.out.printf("\nValor não foi alterado! ");
                }

                break;

            case 5:
                int categoria;

                mostraCategorias();
                System.out.printf("Digite o número da categoria que substituirá a antiga: ");
                categoria = (Integer.parseInt(scanner.nextLine()));
                categoria--;

                if(sys.editaGasto(index, categoria)){
                    System.out.printf("\nCategoria foi alterada! ");
                }else{
                    System.out.printf("\nCategoria não foi alterada! ");
                }

                break;
        
            case 0:
                break;

            default:
                System.out.printf("Opção inválida, tente novamente! ");
                break;
        }
        
    }

    private static void mostraMenuEdicao() {
        System.out.println("|========== Editando Gasto ===========|");
        System.out.println("| => Editar:                          |");
        System.out.println("|                                     |");
        System.out.println("| 1 - Nome                            |");
        System.out.println("| 2 - Descrição                       |");
        System.out.println("| 3 - Data                            |");
        System.out.println("| 4 - Valor                           |");
        System.out.println("| 5 - Categoria                       |");
        System.out.println("| 0 - Cancelar                        |");
        System.out.println("|_____________________________________|");
        System.out.printf("\nSelecione uma opção: ");
    }

    private static void filtrarGastos() {
        int opFilt = -1;
        mostraMenuFiltragem();
        
        opFilt = Integer.parseInt(scanner.nextLine());

        switch (opFilt) {
            case 1:
                systemCls();
                filtrarPorMes();
                break;

            case 2:
                systemCls();
                filtrarPorCategoria();
                break;
            
            case 0:
                break;
            
            default:
                System.out.println("Opção inválida, tente novamente! ");
                break;
        }
    }

    private static void filtrarPorCategoria() {
        int categoria;
        
        mostraCategorias();
        System.out.printf("Digite a categoria em que deseja ver os gastos: ");
        categoria = Integer.parseInt(scanner.nextLine());

        List<Gasto> gastosCateg = sys.filtraGastosCategoria(categoria-1);

        mostrarGastos(gastosCateg);
    }

    private static void filtrarPorMes() {
        int mes;

        System.out.printf("Digite o mês (deste ano) que deseja ver os gastos: ");
        mes = Integer.parseInt(scanner.nextLine());

        List<Gasto> gastosMes = sys.filtraGastosMes(mes);

        mostrarGastos(gastosMes);
    }

    private static void mostrarGastos(List<Gasto> gastos) {
        int cont = 1;
        System.out.println();


        if(gastos.size() >0){
            for (Gasto gasto : gastos) {
                System.out.println("==============================");
                System.out.println("Nº"+cont+":"); cont++;
                System.out.println(gasto);
            }
            System.out.println("==============================\n");
        }else{
            System.out.printf("Nenhuma despesa foi registrada! ");
        }
    }

    private static void registrarGasto() {
        String nome, descricao;
        int dia, mes, ano;
        Float valor;
        int categoria;

        System.out.println("|======== Registrando Gasto ========|");
        System.out.printf("\n -> Digite o nome/razão do gasto: ");
        nome = scanner.nextLine();
        System.out.println(" -> Digite o dia, mês e ano do gasto: ");
        System.out.printf(" --> Dia: ");
        dia = Integer.parseInt(scanner.nextLine());
        System.out.printf(" --> Mês: ");
        mes = Integer.parseInt(scanner.nextLine());
        System.out.printf(" --> Ano: ");
        ano = Integer.parseInt(scanner.nextLine());
        System.out.printf(" -> Digite o valor do gasto: ");
        valor = Float.parseFloat(scanner.nextLine());

        mostraCategorias();
        System.out.printf(" -> Digite o número da categoria do Gasto: ");
        categoria = (Integer.parseInt(scanner.nextLine()))-1;
        System.out.printf(" -> Digite uma descrição para o gasto: ");
        descricao = scanner.nextLine();

        Data data = new Data(dia, mes, ano);

        Gasto gasto = new Gasto(nome, descricao, data, valor, categoria);

        if(sys.novoGasto(gasto)){
            System.out.printf("\nDespesa registrada! ");
        }else{
            System.out.println("\nErro, despesa não registrada! ");
        }


    }

    private static void mostraCategorias() {
        Categorias allCategorias[] = Categorias.values();

        System.out.println("\n|======== Categorias Disponíveis ========|");
        for(int i=0; i< allCategorias.length; i++){
            System.out.println(" "+(i+1)+" - "+allCategorias[i]);
        }

        System.out.println();
    }

    private static void loginDeUsuario() {
        String login, senha;

        System.out.println("|======== Login do Usuário ========|");
        System.out.printf("\n -> Digite o nome de usuário: ");
        login = scanner.nextLine();
        System.out.printf(" -> Digite a senha: ");
        senha = scanner.nextLine();

        if(sys.loginUsuario(login, senha)){
            System.out.printf("\nUsuário Logado! ");
        }else{
            System.out.printf("\nLogin mal-sucedido! Usuário não existe, ou senha está incorreta! Tente novamente! ");
        }
    }

    private static void criaUsuario() {
        String login, senha;

        System.out.println("|===== Criando novo usuário... =====|");
        System.out.printf("\n -> Digite um nome de usuário: ");
        login = scanner.nextLine();
        System.out.printf(" -> Digite uma nova senha: ");
        senha = scanner.nextLine();

        sys.novoUsuario(login, senha);

        System.out.printf("\nUsuário criado com sucesso! ");

        }
    
    private static void mostraMenu() {
        System.out.println("|=====================================|");
        System.out.println("|               Menu do               |");
        System.out.println("|         Sistema de Finanças         |");
        System.out.println("|=====================================|");
        System.out.println("|                                     |");
        System.out.println("| 1 - Registrar Gasto                 |");
        System.out.println("| 2 - Visualizar Finanças             |");
        System.out.println("| 3 - Visualizar Finanças com filtro  |");
        System.out.println("| 4 - Alterar Registro de Gasto       |");
        System.out.println("| 5 - Excluir Registro de Gasto       |");
        System.out.println("| 6 - Deslogar                        |");
        System.out.println("| 0 - Fechar Programa                 |");
        System.out.println("|_____________________________________|");
        System.out.printf("\nSelecione uma opção: ");
    }
    
    private static void mostraMenuLogin() {
        System.out.println("|=====================================|");
        System.out.println("|             Bem-vindo ao            |");
        System.out.println("|         Sistema de Finanças         |");
        System.out.println("|=====================================|");
        System.out.println("|                                     |");
        System.out.println("| 1 - Fazer Login                     |");
        System.out.println("| 2 - Criar Nova Conta                |");
        System.out.println("| 0 - Fechar programa                 |");
        System.out.println("|_____________________________________|");                                    
        System.out.printf("\nSelecione uma opção: ");
    }

    private static void mostraMenuFiltragem() {
        System.out.println("|========= Filtrando Gastos ==========|");
        System.out.println("|                                     |");
        System.out.println("| 1 - Filtrar por mês                 |");
        System.out.println("| 2 - Filtrar por categoria           |");
        System.out.println("| 0 - Cancelar                        |");
        System.out.println("|_____________________________________|");
        System.out.printf("\nSelecione uma opção: ");
    }

    private static void systemPause() {
        System.out.printf("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void systemCls() {
        for(int i=0; i<10; i++){
            System.out.println();
        }
    }

}


