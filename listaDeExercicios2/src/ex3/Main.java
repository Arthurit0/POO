package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Imobiliaria imobiliaria = new Imobiliaria();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op = 0;

        do{
            mostraMenu();
            op = Integer.parseInt(scanner.nextLine());

            limpaTela();
            switch (op) {
                case 1:
                    nomeiaImobiliaria(imobiliaria);
                    break;
            
                case 2:
                    cadastraImovel();
                    break;

                case 3:
                    filtrarImoveis();
                    break;

                case 4:
                    mostrarImobiliaria();
                    break;

                default:
                    break;
            }
            
            System.out.printf("Pressione Enter para continuar...");
            scanner.nextLine();
            limpaTela();
        }while(op!=0);
        
    }

    private static void mostrarImobiliaria() {
        System.out.println(imobiliaria.toString());
    }

    private static void filtrarImoveis() {
        List<Imovel> imoveisFiltrados = new ArrayList<Imovel>();

        float x;

        System.out.printf("Digite o valor mínimo da área dos imoveis: ");
        x = Float.parseFloat(scanner.nextLine());

        imoveisFiltrados = imobiliaria.filtrarPorArea(x);


        for(int i=0; i < imoveisFiltrados.size(); i++){
            System.out.println("\n=> Imóvel nº"+(i+1)+":");
            System.out.println(imoveisFiltrados.get(i));
        }
        System.out.println();
    }

    private static void cadastraImovel() {
            Imovel imovel = new Imovel();

            System.out.printf("Digite a largura do imóvel: ");
            imovel.setLargura(Float.parseFloat(scanner.nextLine()));
            System.out.printf("Digite o comprimento do imóvel: ");
            imovel.setComprimento(Float.parseFloat(scanner.nextLine()));
            System.out.printf("Digite o valor do imóvel: ");
            imovel.setValor(Float.parseFloat(scanner.nextLine()));

            imobiliaria.cadastraImovel(imovel);
            System.out.printf("\nImóvel cadastrado com sucesso! ");
        
    }

    private static void nomeiaImobiliaria(Imobiliaria imobiliaria) {
            System.out.printf("Digite o nome da Imobiliária: ");
            imobiliaria.setNome(scanner.nextLine());
            System.out.printf("\nImobiliária nomeada com sucesso! ");
    }


    public static void mostraMenu(){
        System.out.println("|======== Menu de Opções ========|");
        System.out.println("| 1 - Nomear Imobiliaria         |");
        System.out.println("| 2 - Cadastrar Imóvel           |");
        System.out.println("| 3 - Filtrar Imóveis            |");
        System.out.println("| 4 - Mostrar Imobiliária        |");
        System.out.println("| 0 - Sair do programa           |");
        System.out.println("|================================|");
        System.out.printf("\nSelecione uma opção: ");
    }

    public static void limpaTela(){
        for(int i=0; i<100; i++){
            System.out.println();
        }
    }
}
