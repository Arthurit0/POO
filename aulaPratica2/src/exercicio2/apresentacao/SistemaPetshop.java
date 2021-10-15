package exercicio2.apresentacao;

import exercicio2.dados.*;
import java.util.Scanner;

public class SistemaPetshop {
    static Veterinario Veterinarios[] = new Veterinario[50];
    static int quantVet = 0;
    static Animal animais[] = new Animal[Veterinarios.length*5];
    static int quantAni = 0;
    static Scanner scanner = new Scanner(System.in);
    static Boolean donoRegistrado = false;
    public static void main(String[] args) {
        int op, op2;
        
        do{
            imprimeMenu();
            op = Integer.parseInt(scanner.nextLine());
            switch(op){

                case 1:
                    limpaTela();
                    cadastrarVeterinario();
                break;
            
                case 2:
                    limpaTela();
                    mostrarVeterinarios();
                break;
                
                case 3:
                    limpaTela();
                    System.out.printf("Digite \"1\" para cadastrar o endereço de um Veterinário, ou \"2\" para o endereço de um Dono: ");
                    op2 = Integer.parseInt(scanner.nextLine());

                    limpaTela();
                    if(op2 == 1){
                        cadastrarEnderecoVeterinario();
                    }else if(op2 == 2){
                        cadastrarEnderecoDono();
                    }else{
                        System.out.printf("\nNúmero inválido! ");
                    }
                break;

                case 4:
                    limpaTela();
                    cadastrarAnimal();
                break;
                
                case 5:
                    limpaTela();
                    mostrarAnimais();
                break;

                case 6:
                    limpaTela();
                    cadastrarDono();
                break;   
            }
            System.out.printf("Pressione \"Enter\" para continuar...");
            scanner.nextLine();
            limpaTela();
        }while (op != 0);
    }

    public static void imprimeMenu(){
        System.out.println("|======== Menu de Opções ========|");
        System.out.println("| 0 - Sair do programa           |");
        System.out.println("| 1 - Cadastrar Veterinário      |");
        System.out.println("| 2 - Mostrar Veterinários       |");
        System.out.println("| 3 - Cadastrar Endereço         |");
        System.out.println("| 4 - Cadastrar Animal           |");
        System.out.println("| 5 - Mostrar Animais            |");
        System.out.println("| 6 - Cadastrar Dono             |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");
    }

    public static void limpaTela(){
        for (int i=0; i<100; i++){
            System.out.println();
        }
    }

    private static void cadastrarVeterinario() {

        if (quantVet < Veterinarios.length){
        Veterinario v = new Veterinario();

        System.out.printf("Digite o nome do veterinário: ");
        v.setNome(scanner.nextLine());
        System.out.printf("\nDigite o salário do veterinário: R$ ");
        v.setSalario(Float.parseFloat(scanner.nextLine()));

        Veterinarios[quantVet] = v;
        quantVet++;
        System.out.println("\n"+Veterinarios[quantVet-1].toString());

            System.out.printf("\nVeterinário registrado com Sucesso! ");
        }else{
            System.out.printf("\nO Array de Veterinários já está cheio! ");
        }
    }

    private static void mostrarVeterinarios() {
        System.out.println("\nLista de Veterinários:");

        if(quantVet>0){
        System.out.println();
        for (int i=0; i<quantVet;i++){
            System.out.println("Posição ["+i+"]:\n"+Veterinarios[i].toString());
            System.out.println();
        }
        }else{
        System.out.printf("\nNão há Veterinários cadastrados! ");
    }

    }

    private static Endereco cadastrarEndereco(){
        Endereco end = new Endereco();

        System.out.printf("\nDigite o nome da rua: ");
        end.setRua(scanner.nextLine());
        System.out.printf("\nDigite o número da casa: ");
        end.setNumero(Integer.parseInt(scanner.nextLine()));
        System.out.printf("\nDigite o nome do bairro: ");
        end.setBairro(scanner.nextLine());
        System.out.printf("\nDigite o nome da cidade: ");
        end.setCidade(scanner.nextLine());
        System.out.printf("\nDigite o nome do estado: ");
        end.setEstado(scanner.nextLine());
        System.out.printf("\nDigite o CEP: ");
        end.setCep(Integer.parseInt(scanner.nextLine()));

        return end;

    }

    private static void cadastrarEnderecoVeterinario() {
        
        if(quantVet>0){
        int opV;

        mostrarVeterinarios();
        System.out.printf("Selecione um veterinário, digitando sua posição: ");
        opV = Integer.parseInt(scanner.nextLine());

        Veterinarios[opV].setEncereco(cadastrarEndereco());
        
        System.out.println("\n"+Veterinarios[opV].getEncereco());

        System.out.printf("\nEndereço registrado com sucesso! ");
    }else{
        System.out.printf("\nNão há Veterinários cadastrados! ");
    }
    }

    private static void cadastrarAnimal() {
        
        Animal ani = new Animal();
        int op2;

        if(quantVet>0){
        System.out.println("\nLista de Veterinários:\n");
        
        for(int i=0; i<quantVet; i++){
            System.out.println("Posição ["+i+"]: "+Veterinarios[i].getNome()+"\n");
        }

        System.out.printf("Selecione um veterinário, digitando sua posição: ");
        op2 = Integer.parseInt(scanner.nextLine());

        if(Veterinarios[op2].getQuantidadeAnimais() < 5){
        System.out.printf("\nDigite o nome do animal: ");
        ani.setNome(scanner.nextLine());
        System.out.printf("\nDigite a espécie do animal: ");
        ani.setEspecie(scanner.nextLine());
        System.out.printf("\nDigite uma breve descrição do animal: ");
        ani.setDescricao(scanner.nextLine());

        Veterinarios[op2].setAnimais(ani);
        animais[quantAni] = ani;
        quantAni++;

        System.out.printf("\nAnimal registrado com sucesso! ");
        }else{
        System.out.printf("\nO Veterinário já está atendendo o máximo de animais! ");
        }
    }
    }

    private static void mostrarAnimais() {
        int op2;

        if(quantVet>0){
        
        System.out.println("\nLista de Veterinários:\n");
        for(int i=0; i<quantVet; i++){
            System.out.println("Pos ["+i+"]: "+Veterinarios[i].getNome()+"\n");
        }

        System.out.printf("Selecione um veterinário, digitando sua posição: ");
        op2 = Integer.parseInt(scanner.nextLine());

            if(Veterinarios[op2].getQuantidadeAnimais()>0){
                System.out.println("\nAnimais atendidos pelo Veterinário "+Veterinarios[op2].getNome()+":\n");

                for(int i=0; i<Veterinarios[op2].getQuantidadeAnimais();i++){
                System.out.println("Animal nº"+(i+1)+":\n"+Veterinarios[op2].getAnimais()[i]+"\n");
                }

            }else{
                System.out.printf("\nEste veterinário não possui animais cadastrados! ");
            }

        }
    }

    private static void cadastrarDono() {
        int op1;
        Dono dono = new Dono();

        if (quantVet>0){
            if (quantAni>0){ 
                System.out.println("Lista de animais: \n");
                for (int i=0; i<quantAni; i++){
                    System.out.println("Posição ["+i+"]:\n"+animais[i]+"\n");
                }

                System.out.print("Selecione a posição do animal do dono: ");
                op1 = Integer.parseInt(scanner.nextLine());

                System.out.printf("\nDigite o nome do dono: ");
                dono.setNome(scanner.nextLine());
                System.out.printf("\nDigite o CPF do dono: ");
                dono.setCpf(Integer.parseInt(scanner.nextLine()));

                animais[op1].setDono(dono);
                System.out.println("\n"+animais[op1].getDono());

                donoRegistrado = true;

                System.out.printf("\nDono registrado com sucesso! ");
            }else{
                System.out.printf("\nNão há animais registrados! ");
            }
        }else{
                System.out.printf("\nNão há veterinários registrados! ");
        }
    }

    private static void cadastrarEnderecoDono() {
        int op1;
        if (quantAni>0){
            if(donoRegistrado){
                System.out.println("Lista de animais: \n");
                for (int i=0; i<quantAni; i++){
                    System.out.println("Posição ["+i+"]:\n"+animais[i]+"\n");
                }

                System.out.printf("Digite a posição do animal que deseja registrar o endereço do dono: ");
                op1 = Integer.parseInt(scanner.nextLine());

                if (animais[op1].getDono() == null){
                    System.out.printf("\nO dono deste animal ainda não foi registrado! ");
                }else{
                    System.out.println("\n"+animais[op1].getDono());
                    animais[op1].getDono().setEndereco(cadastrarEndereco());

                    System.out.println("\n"+animais[op1].getDono().getEndereco());

                    System.out.printf("\nEndereço do dono registrado com sucesso! ");

                }

            }else{
                System.out.printf("Não há nenhum dono registrado! ");
            }   
        }else{
            System.out.printf("Não há animais registrados! ");
        }
    }

}




