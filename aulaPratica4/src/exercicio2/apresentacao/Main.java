package exercicio2.apresentacao;

import java.util.List;
import java.util.Scanner;

import exercicio2.dados.Animal;
import exercicio2.dados.Aquario;
import exercicio2.dados.Peixe;
import exercicio2.dados.Viveiro;
import exercicio2.negocio.Zoologico;

public class Main {
    static Zoologico zoo = new Zoologico();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op;

        do {
            mostraMenu();
            op = Integer.parseInt(scanner.nextLine());

            limpaTela();

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
            limpaTela();
        } while (op != 0);
    }

    private static void mostrarTodosViveiros() {
        if(zoo.getSoViveiros().size()>0){
            System.out.println("=> Viveiros:\n");
            mostrarViveiros();
        }
        
        if(zoo.getSoAquarios().size()>0){
            System.out.println("=> Aquarios:\n");
            mostrarAquarios();
        }
    }

    private static void mostrarAnimais() {
        List<Animal> animaisReg = zoo.getAnimais();

        for(int i=0; i<animaisReg.size(); i++){
            System.out.println("\nAnimal nº"+i+":\n");
            System.out.println(animaisReg.get(i));
        }

        System.out.println();
    }

    private static void mostrarViveiros() {
        List<Viveiro> viveiros = zoo.getSoViveiros();

        if(viveiros.size() > 0){
            for(int i=0; i<viveiros.size(); i++){
                System.out.println("Viveiro nº"+i);
                System.out.println(viveiros.get(i));
                System.out.println(viveiros.get(i).toStringAnimais());
            }
        }
    }

    private static void mostrarAquarios() {
        List<Aquario> aquarios = zoo.getSoAquarios();

        if(aquarios.size()>0){
            for(int i=0; i<aquarios.size(); i++){
                System.out.println("Aquário nº"+i);
                System.out.println(aquarios.get(i));
                System.out.println(aquarios.get(i).toStringAnimais());
            }
        }
    }


    private static void alocarAnimal() {
        int op, op2;
        Animal novoAnimal = new Animal();

        if(zoo.getViveiros().size()>0){

            System.out.println("1 - Animal");
            System.out.println("2 - Peixe\n");
            System.out.print("Selecione o tipo do novo animal: ");

            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    novoAnimal = novoAnimal();
                    break;

                case 2:
                    novoAnimal = novoPeixe();
            
                default:
                    break;
            }
            
            System.out.printf("Pressione Enter para continuar...");
            scanner.nextLine();
            limpaTela();


            if(novoAnimal instanceof Peixe){
                mostrarAquarios();
                Aquario aquarioEscolhido;

                System.out.printf("Selecione um aquário para alocar o peixe: ");
                op2 = Integer.parseInt(scanner.nextLine());
                aquarioEscolhido = zoo.getSoAquarios().get(op2);

                if(zoo.alocarAnimal(novoAnimal, aquarioEscolhido)){
                    zoo.cadastrarAnimais(novoAnimal);
                    System.out.printf("\nPeixe alocado! ");
                }else{
                    System.out.printf("\nPeixe não foi alocado (cheque o tamanho do peixe, ou temperatura)! ");
                }
            }else{
                mostrarViveiros();
                Viveiro viveiroEscolhido;

                System.out.printf("Selecione um viveiro para alocar o animal: ");
                op2 = Integer.parseInt(scanner.nextLine());
                viveiroEscolhido = zoo.getSoViveiros().get(op2);

                if(zoo.alocarAnimal(novoAnimal, viveiroEscolhido)){
                    zoo.cadastrarAnimais(novoAnimal);
                    System.out.printf("\nAnimal alocado! ");
                }else{
                    System.out.printf("\nAnimal não alocado (cheque o tamanho do animal)! ");
                }
            }
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

        System.out.println(aquario+"\n");

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

        System.out.println(viveiro+"\n");

        return viveiro;
    }


    private static void limpaTela() {
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

