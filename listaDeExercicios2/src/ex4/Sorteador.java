package ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteador {
    List <Pessoa> lista = new ArrayList<Pessoa>();
    Random rand = new Random();

    public Pessoa sortearProximo(){
        int posSorteada = rand.nextInt(lista.size());
        Pessoa sorteado = lista.get(posSorteada);

        lista.remove(posSorteada);
        
        return sorteado;
    }

    public void mostraParticipantes(){
        System.out.println("\n===========================");
        for(Pessoa pessoa : lista){
            System.out.println(pessoa);
        }
        System.out.println("===========================\n");
    }


}
