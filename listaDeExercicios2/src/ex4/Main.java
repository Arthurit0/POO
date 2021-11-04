package ex4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Sorteador sorteador = new Sorteador();
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int op = 0;
        Pessoa sorteado;

        sorteador.lista.add(new Pessoa("Pedro", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("João", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Paulo", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Rodrigo", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Leonardo", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Fabrício", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Julia", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Gabriela", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Manuela", rand.nextInt(1000)));
        sorteador.lista.add(new Pessoa("Fernanda", rand.nextInt(1000)));

        do {
            if(sorteador.lista.size() > 0){
                sorteador.mostraParticipantes();
                System.out.printf("Digite 1 para sortear, e qualquer outro número para sair do programa: ");

                op = Integer.parseInt(scanner.nextLine());

                if((op == 1)){
                    sorteado = sorteador.sortearProximo();
                    
                    System.out.printf("\nO ganhador é "+sorteado.getNome()+" de número "+sorteado.getNmrSorteio()+"! Pressione Enter para continuar...");
                    scanner.nextLine();
                }
            }else{
                System.out.printf("\nLista Vazia! Pressione Enter para continuar...");
                scanner.nextLine();
                op = -1;
            }
        }while(op == 1);
    }
}