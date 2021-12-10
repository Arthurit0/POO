package ex2;

import java.util.List;
import java.util.Random;

import ex2.exceptions.ProcessoSemJuizException;

public class Main {
    static SistemaProcessos sistema = new SistemaProcessos();
    static Random rand = new Random();
    public static void main(String[] args) {

        instaciaJuizesEProcessos();

        Sorteio();

        ImprimeJuizes();

    }
    
    private static void ImprimeJuizes() {
        for (int i = 0; i < sistema.juizes.size(); i++) {
            System.out.println(sistema.getJuizes().get(i));
        }
    }
    
    private static void Sorteio() {
        try {
            sistema.distribuirProcessos();
        } catch (ProcessoSemJuizException e) {
            System.err.println(e.getMessage());

            List<Processo> processosSemJuiz = sistema.getProcessos();

            System.out.println();
            for (int i = 0; i < processosSemJuiz.size(); i++) {
                System.out.println(">>"+processosSemJuiz.get(i));
            }

            System.out.println();
        }
    }

    private static void instaciaJuizesEProcessos() {
        for (int i = 0; i < 3; i++) {
            Juiz juiz = new Juiz(5);
            juiz.setNome("Nº"+(i+1));
            sistema.cadastrarJuiz(juiz);

        }

        for (int i = 0; i < 18; i++) {
            Processo processo = new Processo();
            processo.setId(1000 + i);
            processo.setNome("Processo Nº"+(i+1));

            sistema.cadastrarProcesso(processo);
        }

    }
}
