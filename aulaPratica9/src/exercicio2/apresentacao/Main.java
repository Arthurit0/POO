package exercicio2.apresentacao;

import java.util.List;
import java.util.Scanner;

import exercicio2.dados.Animal;
import exercicio2.dados.Aquario;
import exercicio2.dados.Peixe;
import exercicio2.dados.Viveiro;
import exercicio2.exceptions.AlocacaoInvalidaException;
import exercicio2.exceptions.EspacoInsuficienteException;
import exercicio2.exceptions.TemperaturaInadequadaException;
import exercicio2.negocio.Zoologico;

public class Main {
    static Zoologico zoo = new Zoologico();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op;

        do {
            mostraMenu();
            op = Integer.parseInt(scanner.nextLine());

            systemcls();

            switch (op) {
                case 1:
                    cadastraViveiro();
                    break;

                case 2:
                    alocarAnimal();
                    break;

                case 3:
                    mostrarAnimais();  
                    break;

                case 4:
                    mostrarTodosViveiros();
                    break;

                case 0:
                    break;
                    
                default:
                    break;
            }

            System.out.printf("Pressione Enter para continuar...");
            scanner.nextLine();
            systemcls();
        } while (op != 0);
    }

    private static void mostrarTodosViveiros() {
        List<Viveiro> todosViveiros = zoo.getViveiros();

        System.out.println("Lista de Viveiros:\n");

        for(int i=0; i<todosViveiros.size(); i++){
            Viveiro viveiroAtual = todosViveiros.get(i);

            System.out.println("/--------------\\");
            System.out.printf("  Nº"+(i+1)+": ");

            if(viveiroAtual instanceof Aquario){
                System.out.printf("Aquário  \n");
            }else{
                System.out.printf("Viveiro  \n");
            }

            System.out.println("\\--------------/\n");
            System.out.println(viveiroAtual);
            System.out.println(viveiroAtual.toStringAnimais());
        }

    }

    private static void mostrarAnimais() {
        List<Animal> animaisReg = zoo.getAnimais();

        System.out.println("Lista de Animais:");


        for(int i=0; i<animaisReg.size(); i++){
            System.out.println("\nAnimal nº"+(i+1)+":\n");
            System.out.println(animaisReg.get(i));
        }

        System.out.println();
    }

    private static void alocarAnimal() {
        int op, op2;
        Animal animal = new Animal();

        if(zoo.getViveiros().size()>0){

            System.out.println("1 - Animal");
            System.out.println("2 - Peixe\n");
            System.out.print("Selecione o tipo do novo animal: ");

            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    animal = novoAnimal();
                    break;

                case 2:
                    animal = novoPeixe();
            
                default:
                    break;
            }
            
            System.out.printf("Pressione Enter para continuar...");
            scanner.nextLine();
            systemcls();

            Viveiro viveiro;
            mostrarTodosViveiros();
            System.out.printf("Selecione um viveiro para alocar o animal: ");
            op2 = (Integer.parseInt(scanner.nextLine()))-1;
            viveiro = zoo.getViveiros().get(op2);

            try {
                zoo.alocarAnimal(animal, viveiro);
            }catch (AlocacaoInvalidaException e) {
                systemcls();
                System.err.printf(e.getMessage());
            }catch (EspacoInsuficienteException e){
                systemcls();
                System.err.printf(e.getMessage());
            }catch (TemperaturaInadequadaException e){
                systemcls();
                System.err.printf(e.getMessage());
            }

            System.out.println();

        }else{
            System.out.printf("Não há viveiros registrados! ");
        }
        
    }

    private static Animal novoPeixe() {
        Peixe peixe = new Peixe();
        
        System.out.printf("\nDigite o nome do peixe: ");
        peixe.setNome(scanner.nextLine());
        System.out.printf("Digite a cor do peixe: ");
        peixe.setCor(scanner.nextLine());
        System.out.printf("Digite a espécie do peixe: ");
        peixe.setEspecie(scanner.nextLine());
        System.out.printf("Digite a idade do peixe: ");
        peixe.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.printf("Digite a largura do peixe: ");
        peixe.setLargura(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite o comprimento do peixe: ");
        peixe.setComprimento(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite a altura do peixe: ");
        peixe.setAltura(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite a temperatura ideal do peixe: ");
        peixe.setTemperaturaIdeal(Float.parseFloat(scanner.nextLine()));

        System.out.println("\n"+peixe+"\n");

        return peixe;
    }


    private static Animal novoAnimal() {
        Animal animal = new Animal();

        System.out.printf("\nDigite o nome do animal: ");
        animal.setNome(scanner.nextLine());
        System.out.printf("Digite a cor do animal: ");
        animal.setCor(scanner.nextLine());
        System.out.printf("Digite a espécie do animal: ");
        animal.setEspecie(scanner.nextLine());
        System.out.printf("Digite a idade do animal: ");
        animal.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.printf("Digite a largura do animal: ");
        animal.setLargura(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite o comprimento do animal: ");
        animal.setComprimento(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite a altura do animal: ");
        animal.setAltura(Float.parseFloat(scanner.nextLine()));

        System.out.println("\n"+animal+"\n");

        return animal;
    }


    private static void cadastraViveiro() {
        int op;

        System.out.println("1 - Viveiro");
        System.out.println("2 - Aquário");
        System.out.printf("\nDigite o número do tipo de viveiro que deseja cadastrar: ");

        op = Integer.parseInt(scanner.nextLine());

        switch (op) {
            case 1:
                zoo.cadastrarViveiro(novoViveiro());
                break;

            case 2:
                zoo.cadastrarViveiro(novoAquario());
                break;
        
            default:
                System.out.printf("Opção inválida! ");
                break;
        }


    }


    private static Aquario novoAquario() {
        Aquario aquario = new Aquario();

        System.out.println();
        System.out.printf("Digite o nome do aquario: ");
        aquario.setNome(scanner.nextLine());
        System.out.printf("Digite o comprimento do aquario: ");
        aquario.setComprimento(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite a largura do aquario: ");
        aquario.setLargura(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite a altura do aquario: ");
        aquario.setAltura(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite a temperatura do aquario: ");
        aquario.setTemperatura(Float.parseFloat(scanner.nextLine()));

        System.out.println("\n"+aquario+"\n");

        return aquario;
    }


    private static Viveiro novoViveiro() {
        Viveiro viveiro = new Viveiro();

        System.out.println();
        System.out.printf("Digite o nome do viveiro: ");
        viveiro.setNome(scanner.nextLine());
        System.out.printf("Digite o comprimento do viveiro: ");
        viveiro.setComprimento(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Digite a largura do viveiro: ");
        viveiro.setLargura(Float.parseFloat(scanner.nextLine()));

        System.out.println("\n"+viveiro+"\n");

        return viveiro;
    }


    private static void systemcls() {
        for(int i=0; i<100; i++){
            System.out.println();
        }
    }


    private static void mostraMenu() {
        System.out.println("|======== Menu de Opções ========|");
        System.out.println("| 1 - Cadastrar Viveiro          |");
        System.out.println("| 2 - Cadastrar Animal           |");
        System.out.println("| 3 - Mostrar Animais            |");
        System.out.println("| 4 - Mostrar Viveiros           |");        
        System.out.println("| 0 - Sair do programa           |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");
    }
}

