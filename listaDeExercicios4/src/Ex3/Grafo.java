package Ex3;

import java.util.ArrayList;
import java.util.List;

public class Grafo extends Digrafo{
    
    public void adicionarAresta(int origem, int destino) {

        if(origem >= 0 && origem <= cont && destino >= 0 && destino <= cont){
            List<Integer> listaOrigem, listaDestino = new ArrayList<Integer>();

            listaOrigem = getMatrizAdjacencia2().get(origem);
            listaDestino = getMatrizAdjacencia2().get(destino);

            listaOrigem.set(destino, 1);
            listaDestino.set(origem, 1);

        }
    }
}
