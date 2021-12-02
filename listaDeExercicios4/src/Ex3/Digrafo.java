package Ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Digrafo {
    private Map<Integer, List<Integer>> matrizAdjacencia2 = new HashMap<Integer, List<Integer>>();
    int cont = 0;

    public Map<Integer, List<Integer>> getMatrizAdjacencia2() {
        return matrizAdjacencia2;
    }

    public void setMatrizAdjacencia2(Map<Integer, List<Integer>> matrizAdjacencia2) {
        this.matrizAdjacencia2 = matrizAdjacencia2;
    }

    public Digrafo(){
        List<Integer> lista = new ArrayList<Integer>();

        matrizAdjacencia2.put(0, lista);
        matrizAdjacencia2.get(0).add(0);
    }

    public void adicionarVertice(){
        List<Integer> lista = new ArrayList<Integer>();

        for(int i = 0; i < matrizAdjacencia2.size(); i++){
            lista = matrizAdjacencia2.get(i);
            lista.add(0);
        }

        lista = new ArrayList<Integer>();

        cont++;
        matrizAdjacencia2.put(cont, lista);

        for(int i = 0; i < matrizAdjacencia2.size(); i++){
            matrizAdjacencia2.get(cont).add(0);
        }
    }
   

    public void adicionarAresta(int origem, int destino){
        if(origem >= 0 && origem <= cont && destino >= 0 && destino <= cont){
            List<Integer> listaOrigem = new ArrayList<Integer>();
            listaOrigem = matrizAdjacencia2.get(origem);
            listaOrigem.set(destino,1);
        }
    }
        
    public String toString() {
        String str = "   ";

        for (int i = 0; i < matrizAdjacencia2.size(); i++) {
            str += i+" ";
        }

        str += "\n  ";

        for(int i = 0; i < cont; i++){
            str += "---";
        }
    

        str += "\n";

        for (int i = 0; i < matrizAdjacencia2.size(); i++) {
            str += i+"| ";
            for (int j = 0; j < matrizAdjacencia2.size(); j++) {
                str += +matrizAdjacencia2.get(i).get(j)+" ";
            }
            str += "\n";
        }

        return str;
    }

}
