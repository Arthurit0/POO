package ex2e3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Matriz<Float> matriz = new Matriz<Float>(5, 5);
    public static void main(String[] args) {
        
        List<Float> q1, q2, q3, q4, listaFinal;
        float num = 0, mnrQ1, mnrQ2, mnrQ3, mnrQ4, menorFinal;

        for(int i = 0; i<5; i++){
            for(int j = 0; j < 5; j++){
                if(num != -1){
                    System.out.printf("Digite um elemento para a posição ("+i+","+j+"), ou -1 para parar de escanear: ");
                    num = Float.parseFloat(scanner.nextLine());
                    
                    if(num != -1){
                        matriz.setElem(num, i, j);
                    }else{
                        matriz.setElem(Float.MAX_VALUE, i, j);
                    }

                }else{
                    matriz.setElem(Float.MAX_VALUE, i, j);
                }
            }
        }
        
        q1 = matriz.getElementosQuadrante(Quadrante.PRIMEIRO);
        q2 = matriz.getElementosQuadrante(Quadrante.SEGUNDO);
        q3 = matriz.getElementosQuadrante(Quadrante.TERCEIRO);
        q4 = matriz.getElementosQuadrante(Quadrante.QUARTO);

        mnrQ1 = menorElemento(q1);
        mnrQ2 = menorElemento(q2);
        mnrQ3 = menorElemento(q3);
        mnrQ4 = menorElemento(q4);

        listaFinal = new ArrayList<Float>();

        listaFinal.add(mnrQ1);
        listaFinal.add(mnrQ2);
        listaFinal.add(mnrQ3);
        listaFinal.add(mnrQ4);

        menorFinal = menorElemento(listaFinal);
        
        System.out.println();
        for(int i=0; i<5; i++){
            for(int j=0; j < 5; j++){
                if(matriz.getElem(i, j) != Float.MAX_VALUE){
                    System.out.printf(matriz.getElem(i, j)+" ");
                }else{
                    System.out.printf("0.0 ");
                }
            }
            System.out.println();
        }

        if(mnrQ1 == Float.MAX_VALUE){
            mnrQ1 = 0;
        }
        if(mnrQ2 == Float.MAX_VALUE){
            mnrQ2 = 0;
        }
        if(mnrQ3 == Float.MAX_VALUE){
            mnrQ3 = 0;
        }
        if(mnrQ4 == Float.MAX_VALUE){
            mnrQ4 = 0;
        }

        System.out.println("\nMenor valor do Quadrante 1: "+mnrQ1);
        System.out.println("Menor valor do Quadrante 2: "+mnrQ2);
        System.out.println("Menor valor do Quadrante 3: "+mnrQ3);
        System.out.println("Menor valor do Quadrante 4: "+mnrQ4);
        System.out.println("Menor valor de todos(!= 0): "+menorFinal);

    }

    private static float menorElemento(List<Float> l) {
        float menor = Float.MAX_VALUE;

        for(int i=0; i<l.size(); i++){
            if(l.get(i) != null){
                if(l.get(i) < menor){
                    menor = l.get(i);
                }
            }
        }


        return menor;
    }
}
