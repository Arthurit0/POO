package exercicio2.apresentacao;

import exercicio2.dados.*;
import java.util.Scanner;

public class SistemaPetshop {
    static Veterinario Veterinarios[] = new Veterinario[50];
    static int quantidadeVeterinarios = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op, op2;
        
        do{
            imprimeMenu();
            op = Integer.parseInt(scanner.nextLine());
            switch(op){
                case 1:
                limpaTela();
                cadastrarVeterinario();
                continue;
            
                case 2:
                limpaTela();
                mostrarVeterinarios();
                break;
                
                case 3:
                limpaTela();
                System.out.printf("Digite 1 para endereço de um Veterinário, ou 2 para o endereço de um Dono: ");
                op2 = Integer.parseInt(scanner.nextLine());
                
                if(op2 == 1){
                    cadastrarEnderecoVeterinario();
                    continue;
                }else if(op2 == 2){
                    
                    continue;
                }else{
                    System.out.println("Número inválido, tente novamente!");
                    scanner.nextLine();
                    continue;
                }

                case 4:
                    cadastrarAnimal();
                    continue;
                
                case 5:
                    mostrarAnimais();
                    break;
            
            
            }

            System.out.printf("\nPressione qualquer tecla para continuar...");
            scanner.nextLine();
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
        System.out.println("| 7 - Mostrar Donos              |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");
    }

    public static void limpaTela(){
        for (int i=0; i<100; i++){
            System.out.println();
        }
    }

    private static void cadastrarVeterinario() {

        if (quantidadeVeterinarios < Veterinarios.length){
        Veterinario v = new Veterinario();

        System.out.printf("Digite o nome do veterinário: ");
        v.setNome(scanner.nextLine());
        System.out.printf("\nDigite o salário do veterinário: R$ ");
        v.setSalario(Float.parseFloat(scanner.nextLine()));

        Veterinarios[quantidadeVeterinarios] = v;
        quantidadeVeterinarios++;

        System.out.printf("\nVeterinário registrado com Sucesso! Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        }else{
            System.out.printf("\nO Array de Veterinários já está cheio! Pressione qualquer tecla para continuar...");
            scanner.nextLine();
        }
    }

    private static void mostrarVeterinarios() {
        System.out.println();
        for (int i=0; i<quantidadeVeterinarios;i++){
            System.out.println("Pos ["+i+"]: "+Veterinarios[i].getNome());
        }

    }

    private static void cadastrarEnderecoVeterinario() {
        
        if(Veterinarios.length>0){
            int opV;
        Endereco end = new Endereco();
        mostrarVeterinarios();
        System.out.printf("\nSelecione um veterinário, digitando sua posição: ");
        opV = Integer.parseInt(scanner.nextLine());

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

        Veterinarios[opV].setEncereco(end);

        System.out.printf("\nEndereço registrado com sucesso! Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }else{
        System.out.printf("\nNão há veterinários cadastrados! Pressione qualquer tecla para continuar...");
    }
    }

    private static void cadastrarAnimal() {
        Animal ani = new Animal();
        int op2;
        mostrarVeterinarios();

        System.out.printf("\nSelecione um veterinário, digitando sua posição: ");
        op2 = Integer.parseInt(scanner.nextLine());

        if(Veterinarios[op2].getQuantidadeAnimais() < 5){
        System.out.printf("\nDigite o nome do animal: ");
        ani.setNome(scanner.nextLine());
        System.out.printf("\nDigite a espécie do animal: ");
        ani.setEspecie(scanner.nextLine());
        System.out.printf("\nDigite uma breve descrição do animal: ");
        ani.setDescricao(scanner.nextLine());

        Veterinarios[op2].setAnimais(ani);

        System.out.printf("\nAnimal registrado com sucesso! Pressione qualquer tecla para continuar...");
            scanner.nextLine();
        }else{
        System.out.printf("\nO Veterinário já está atendendo o máximo de animais! Pressione qualquer tecla para continuar...");
            scanner.nextLine();
        }
    }

    private static void mostrarAnimais() {
        int op2;

        mostrarVeterinarios();

        System.out.printf("\nSelecione um veterinário, digitando sua posição: ");
        op2 = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<Veterinarios[op2].getQuantidadeAnimais();i++){
            System.out.println("Pos ["+i+"]: "+Veterinarios[op2].getAnimais()[i].getNome());
        }

    }
}




