package ex4;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static Turma turma = new Turma();
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {   
        int op = 0;

        turma.adicionarAluno(new Aluno("Julia", 18, 9.7, 9.7, 9.7, 9.7, 9.7));
        turma.adicionarAluno(new Aluno("Gabriela", 17, 9.2, 9.2, 9.2, 9.2, 9.2));
        turma.adicionarAluno(new Aluno("Matheus", 15, 8.7, 8.7, 8.7, 8.7, 8.7));
        turma.adicionarAluno(new Aluno("Isabela", 16, 8.4, 8.4, 8.4, 8.4, 8.4));
        turma.adicionarAluno(new Aluno("Lucas", 15, 7.8, 7.8, 7.8, 7.8, 7.8));
        turma.adicionarAluno(new Aluno("Marcos", 15, 7.5, 7.5, 7.5, 7.5, 7.5));
        turma.adicionarAluno(new Aluno("Letícia", 17, 7.2, 7.2, 7.2, 7.2, 7.2));
        turma.adicionarAluno(new Aluno("Beatriz", 18, 6.6, 6.6, 6.6, 6.6, 6.6));
        turma.adicionarAluno(new Aluno("Rafael", 19, 5.6, 5.6, 5.6, 5.6, 5.6));
        turma.adicionarAluno(new Aluno("Gabriel", 15, 4.7, 4.7, 4.7, 4.7, 4.7));

        do {
            System.out.println("Digite 1 para adicionar mais um aluno na turma, e -1 para exibir as equipes: ");
            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    adicionarAluno();
                    break;
                
                case -1:
                    exibirEquipes();
                    System.out.printf("Saindo do Programa! Aperte Enter para continuar...");
                    scanner.nextLine();
                    break;

                default:
                    System.out.printf("Opção inválida, tente novamente! Aperte Enter para continuar...");
                    scanner.nextLine();
                    break;
            }
            
            System.out.println();
        }while(op != -1);
}

    private static void exibirEquipes() {
        List<Equipe<Aluno>> equipes = turma.separarEmEquipes();

        System.out.println();
        for (Equipe<Aluno> equipe : equipes) {
            System.out.println(equipe+"\n");
        }
    }

    private static void adicionarAluno() {
        Aluno aluno = new Aluno();

        System.out.printf("Digite o nome do aluno: ");
        aluno.setNome(scanner.nextLine());
        System.out.printf("Digite a idade do aluno: ");
        aluno.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.println("Digite as cinco notas do aluno:");
        
        for(int i = 0; i < 5; i++){
            System.out.printf("Nota "+(i+1)+": ");
            aluno.getNotas().add(Double.parseDouble(scanner.nextLine()));
        }

        turma.adicionarAluno(aluno);
    }
}
