package ex1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<IOperacaoInteira> operacoes = new LinkedList<IOperacaoInteira>();

        int v1 = rand.nextInt(50)+2;
        int v2 = rand.nextInt(50)+2;

        System.out.println("Valores "+v1+" e "+v2+", operando nesta ordem em Soma, Multiplicacao, MDC e Resto da divisão, respectivamente:");

        operacoes.add(new Soma());
        operacoes.add(new Multiplicacao());
        operacoes.add(new MDC());
        operacoes.add(new Mod());

        
        for(IOperacaoInteira op : operacoes){
            System.out.println(op.executar(v1, v2));
        }

    }
}
