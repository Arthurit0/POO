package SistemaViagem.apresentacao;

import java.util.Scanner;

import SistemaViagem.dados.*;
import SistemaViagem.negocio.ReservaPassagem;

public class Principal {
    static Scanner scanner = new Scanner(System.in);
    static ReservaPassagem reg = new ReservaPassagem();

    public static void main(String[] args) {
        int op=0;
        do{
            mostraMenu();
            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    limpaTela();
                    cadastrarCidade();
                    break;

                case 2:
                    limpaTela();       
                    cadastrarCliente();
                    break;

                case 3:
                    limpaTela(); 
                    fazerReserva();
                    break;

                case 4:
                    limpaTela(); 
                    mostrarReserva();
                    break;

                case 5:
                    limpaTela();
                    printCidades();
                    break;

                case 6:
                    limpaTela();
                    printClientes();
                    break;

                case 0:
                    return;

                default:
                    limpaTela(); 
                    System.out.println("Opção inválida! ");
                    break;
            }

        System.out.printf("Pressione Enter para continuar...");
        scanner.nextLine();
        limpaTela(); 
        }while(op!=0);
    }

    private static void cadastrarCidade() {
        Cidade cidade = new Cidade();

        System.out.printf("Digite o nome da cidade: ");
        cidade.setNome(scanner.nextLine());
        System.out.printf("\nDigite o nome do estado: ");
        cidade.setEstado(scanner.nextLine());

        reg.cadastrarCidade(cidade);
        System.out.println("\n=> "+cidade);

        System.out.printf("\nCidade cadastrada com sucesso! ");
    }

    private static void cadastrarCliente() {
        Cliente cliente = new Cliente();

        System.out.printf("Digite o CPF do cliente (apenas números): ");
        cliente.setCpf(Long.parseLong(scanner.nextLine()));
        System.out.printf("\nDigite o nome do cliente: ");
        cliente.setNome(scanner.nextLine());
        System.out.printf("\nDigite o endereco do cliente: ");
        cliente.setEndereco(scanner.nextLine());
        System.out.printf("\nDigite o telefone do cliente: ");
        cliente.setTelefone(Integer.parseInt(scanner.nextLine()));

        reg.cadastraCliente(cliente);  
        System.out.println(cliente);

        System.out.printf("\nCliente cadastrado(a) com sucesso! ");
      
    }

    private static void fazerReserva() {
        Reserva reserva = new Reserva();
        Cliente cliente = new Cliente();
        boolean found = false;
        long CPF;
        
        if(reg.getQuantClientes()>0){

        for(int i = 0; i<reg.getQuantClientes();i++){
            System.out.println("CPF do Cliente ["+i+"]: "+reg.mostrarClientes()[i].getCpf());
        }

        System.out.printf("\nDigite o CPF do cliente que deseja fazer uma reserva: ");
        CPF = Long.parseLong(scanner.nextLine());

        for(int i=0; i<reg.getQuantClientes(); i++){
            if (CPF == reg.mostrarClientes()[i].getCpf()){
                cliente = reg.mostrarClientes()[i];
                found = true;
                break;
            }
        }

            if(found){
            Cidade origem = new Cidade();
            Cidade destino = new Cidade();

            limpaTela();
            System.out.println("\nCliente válido, cadastrando reserva...");
            System.out.printf("\nDigite o número da reserva: ");
            reserva.setNumReserva(Integer.parseInt(scanner.nextLine()));
            System.out.printf("\nDigite a data do voo (formato \"dia/mês/ano\"): ");
            reserva.setDataVoo(scanner.nextLine());
            System.out.printf("\nDigite a hora do voo (formato \"hora:minuto\") :");
            reserva.setHoraVoo(scanner.nextLine());
            System.out.printf("\nDigite o preço da passagem: ");
            reserva.setPreco(Float.parseFloat(scanner.nextLine()));
            System.out.printf("\nDigite a classe do voo: ");
            reserva.setClasseVoo(scanner.nextLine());
            System.out.printf("\nDigite o número da poltrona: ");
            reserva.setPoltrona(Integer.parseInt(scanner.nextLine()));
            
            System.out.printf("\nDigite o nome da cidade de origem: ");
            origem.setNome(scanner.nextLine());
            System.out.printf("\nDigite o nome do estado de origem: ");
            origem.setEstado(scanner.nextLine());
    
            checkCidade(origem);

            System.out.printf("\nDigite o nome da cidade de destino: ");
            destino.setNome(scanner.nextLine());
            System.out.printf("\nDigite o nome do estado de destino: ");
            destino.setEstado(scanner.nextLine());

            checkCidade(destino);

            reserva.setOrigem(origem);
            reserva.setDestino(destino);

            System.out.printf("\nDeseja reservar a passagem de volta? (true ou false): ");
            reserva.setIdaEVolta(Boolean.parseBoolean(scanner.nextLine()));
            reg.reservarIda(cliente,reserva);
            

            if(reserva.getIdaEVolta()){
            Reserva reservaVolta = new Reserva();

            reservaVolta.setOrigem(reserva.getDestino());
            reservaVolta.setDestino(reserva.getOrigem());
            reservaVolta.setClasseVoo(reserva.getClasseVoo());

            limpaTela();
            System.out.println("\nReservando passagem de volta...");
            System.out.printf("\nDigite o número da reserva: ");
            reservaVolta.setNumReserva(Integer.parseInt(scanner.nextLine()));
            System.out.printf("\nDigite a data do voo (formato \"dia/mês/ano\"): ");
            reservaVolta.setDataVoo(scanner.nextLine());
            System.out.printf("\nDigite a hora do voo (formato \"hora:minuto\"): ");
            reservaVolta.setHoraVoo(scanner.nextLine());
            System.out.printf("\nDigite o preço da passagem: ");
            reservaVolta.setPreco(Float.parseFloat(scanner.nextLine()));
            System.out.printf("\nDigite o número da poltrona: ");
            reserva.setPoltrona(Integer.parseInt(scanner.nextLine()));

            reg.reservarVolta(cliente, reserva, reservaVolta);

            System.out.printf("\nReserva de passagem de ida e volta cadastrada com sucesso! ");
            }else{
                System.out.printf("\nReserva de passagem única cadastrada com sucesso! ");
            }
            
        }else{
            System.out.printf("\nCPF não encontrado! ");
        }
        }else{
            System.out.printf("\nNão há clientes cadastrados! ");
        }
    }

    private static void checkCidade(Cidade cidade) {
        boolean check = false;

        for(int i = 0; i<reg.getQuantCidades(); i++){
            if ((cidade.getNome().equals(reg.mostrarCidades()[i].getNome()))&&
            (cidade.getEstado().equals(reg.mostrarCidades()[i].getEstado()))){
                System.out.println("\nCidade encontrada no banco de dados!");
                check = true;
                break;
            }
        }

        if(check == false){
            System.out.println("\nCidade não encontrada no banco de dados! Registrando cidade...");
            reg.cadastrarCidade(cidade);
        }
    }

    private static void mostrarReserva() {
        Cliente cliente = new Cliente();
        long CPF;

        for(int i = 0; i<reg.getQuantClientes();i++){
            System.out.println("CPF do Cliente ["+i+"]: "+reg.mostrarClientes()[i].getCpf());
        }

        System.out.println("\nDigite o CPF do cliente que deseja ver as reservas:");
        CPF = Long.parseLong(scanner.nextLine());

        for(int i=0; i<reg.getQuantClientes(); i++){
            if (CPF == reg.mostrarClientes()[i].getCpf()){
                cliente = reg.mostrarClientes()[i];
                break;
            }
        }

        for(int i = 0; i<cliente.getNumReservas(); i++){
            System.out.println("Pos ["+i+"]: "+cliente.getReservas()[i]+"\n");
        }

    }

    private static void printCidades() {

        if(reg.getQuantCidades()>0){
        System.out.println("Lista de Cidades:\n");

        for (int i = 0; i < reg.getQuantCidades(); i++){
            System.out.println(reg.mostrarCidades()[i]);
        }
        System.out.println();
        }else{
            System.out.printf("Não há cidades cadastradas! ");
        }

    }

    private static void printClientes() {

        if(reg.getQuantClientes()>0){

        System.out.println("Lista de Clientes:");

        for(int i = 0; i < reg.getQuantClientes(); i++){
            System.out.println("\nCliente Nº"+(i+1)+reg.mostrarClientes()[i]);
        }
        System.out.println();
        }else{
            System.out.printf("Não há clientes cadastrados! ");
        }
    }


    public static void mostraMenu(){
        System.out.println("|======== Menu de Opções ========|");
        System.out.println("| 1 - Cadastrar Cidade           |");
        System.out.println("| 2 - Cadastrar Cliente          |");
        System.out.println("| 3 - Fazer Reserva              |");
        System.out.println("| 4 - Ver reservas               |");
        System.out.println("| 5 - Mostrar Cidades            |");
        System.out.println("| 6 - Mostrar Clientes           |");
        System.out.println("| 0 - Sair do programa           |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");
    }

    public static void limpaTela(){
        for (int i=0; i<100; i++){
            System.out.println();
        }
    }
}
