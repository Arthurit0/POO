package exemplo;

import java.util.*;

public class Tabuada {
    public static void main(String[] args) {
        Map <Integer, List<Integer>> todasAsTabuadas = new HashMap<Integer, List<Integer>>();

        for (int i = 1; i <= 10; i++) {
            todasAsTabuadas.put(i, tabuada(i));
        }

        todasAsTabuadas.forEach(
            (chave, num) -> {
                System.out.print("Tabuada de "+chave+": ");

                for (int i : num) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }

        );
    }

    public static List<Integer> tabuada (int n){
        List <Integer> tabuada = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            tabuada.add(i*n);
        }

        return tabuada;
    }
}