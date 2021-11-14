package ex4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Turma {
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private Random rand = new Random();

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    private void ordenaAlunosPorMedia(){
        alunos.sort(Comparator.comparing(Aluno::calcularMedia));
    }

    public List<Equipe<Aluno>> separarEmEquipes(){
        ordenaAlunosPorMedia();

        List<Aluno> alunosSemEquipe = alunos;
        List<Equipe<Aluno>> equipes = new ArrayList<Equipe<Aluno>>();
        int numeroEquipe = 1, umOuDois;

        while(alunosSemEquipe.size() > 0){
            Equipe<Aluno> novaEquipe = new Equipe<Aluno>();

            if(alunosSemEquipe.size() >= 4){
                umOuDois = rand.nextInt(2) + 1;
                System.out.println(umOuDois);
                
                switch (umOuDois) {
                    case 1:
                        novaEquipe.getEquipeAlunos().add(alunosSemEquipe.get(0));
                        novaEquipe.getEquipeAlunos().add(alunosSemEquipe.get(alunosSemEquipe.size()-1));
                        novaEquipe.getEquipeAlunos().add(alunosSemEquipe.get(alunosSemEquipe.size()-2));

                        alunosSemEquipe.remove(0);
                        alunosSemEquipe.remove(alunosSemEquipe.size()-1);
                        alunosSemEquipe.remove(alunosSemEquipe.size()-2);
                        
                        break;
                    
                    case 2:
                        novaEquipe.getEquipeAlunos().add(alunosSemEquipe.get(0));
                        novaEquipe.getEquipeAlunos().add(alunosSemEquipe.get(1));
                        novaEquipe.getEquipeAlunos().add(alunosSemEquipe.get(alunosSemEquipe.size()-1));

                        alunosSemEquipe.remove(0);
                        alunosSemEquipe.remove(1);
                        alunosSemEquipe.remove(alunosSemEquipe.size()-1);
                        
                        break;

                    default:
                    System.out.println("\nNúmero randômico tá errado!");
                        break;
                }
                
            }else{
                novaEquipe.getEquipeAlunos().addAll(alunosSemEquipe);
                alunosSemEquipe.clear();
            }
            
            novaEquipe.setNome("Equipe nº"+numeroEquipe);
            numeroEquipe++;
            equipes.add(novaEquipe);
        }

        return equipes;
    }

}
