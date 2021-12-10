package ex2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ex2.exceptions.PilhaCheiaException;
import ex2.exceptions.ProcessoSemJuizException;

public class SistemaProcessos {
    List<Juiz> juizes = new LinkedList<Juiz>();
    List<Processo> processos = new LinkedList<Processo>();
    Random rand = new Random();

    public void cadastrarProcesso(Processo processo){
        processos.add(processo);
    }

    public void cadastrarJuiz(Juiz juiz){
        juizes.add(juiz);
    }

    public void distribuirProcessos() throws ProcessoSemJuizException{
        int randNum;
        Processo processoSorteado;


        for (Juiz juiz : juizes) {
            boolean aceitaProcessos = true;

            while(aceitaProcessos){

            randNum = rand.nextInt(processos.size());
            processoSorteado = processos.get(randNum);

            try {
                juiz.getProcessos().inserir(processoSorteado);
                processos.remove(processoSorteado);
            } catch (PilhaCheiaException e) {
                aceitaProcessos = false;
            }
        }
            
        }

        if(processos.size() > 0){
            throw new ProcessoSemJuizException("Há processos não distribuídos a juízes! ");
        }

    }

}
