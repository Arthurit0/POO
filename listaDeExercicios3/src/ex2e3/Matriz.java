package ex2e3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matriz<T> {
    private int m;
    private int n;
    private List<List<T>> mx = new ArrayList<List<T>>();

    public Matriz(int m, int n){
        this.m = m;
        this.n = n;
        for(int i=0; i<m; i++){
            List<T> linha = new ArrayList<>();
            mx.add(i, linha);
            for(int j=0; j<n; j++){
                mx.get(i).add(j, null);
            }
        }
    }

    public int getM() {
        return this.m;
    }

    public int getN() {
        return this.n;
    }

    public boolean setElem(T obj, int i, int j){
        if ((i < m)&&(j < n)){
            mx.get(i).add(j, obj);
            return true;
        }else{
            return false;
        }
    }

    public T getElem(int i, int j){
        T elem;
        if((i >= 0) && (j >= 0) && (i < m) && (j < n)){
            elem = mx.get(i).get(j);
            return elem;
        }else{
            return null;
        }
    }

    public List<T> getLinha(int linha){
        if((linha >= 0) && (linha < m)){
            return mx.get(linha);
        }else{
            return null;
        }
    }

    public List<T> getColuna(int coluna){
        if((coluna >=0) && (coluna < n)){
            List<T> col = new ArrayList<>();
            
            for(int i = 0; i<m; i++){
                col.add(mx.get(i).get(coluna));
            }

            return col;
        }else{
            return null;
        }
    }

    public List<T> getElementosQuadrante(Quadrante quadrante){
        Map<Integer, List<T>> quad = new HashMap<Integer,List<T>>();

        for(int i=0; i<4; i++){
            List<T> lista = new ArrayList<T>();
            quad.put(i, lista);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((j >= 0) && (j <= n/2) && (i >= 0) && (i <= m/2)){
                    quad.get(0).add(mx.get(i).get(j));
                }

                if((j > n/2) && (j < n) && (i >= 0) && (i <= m/2)){
                    quad.get(1).add(mx.get(i).get(j));
                }

                if((j >= 0) && (j<= n/2) && (i > m/2) && (i < m)){
                    quad.get(2).add(mx.get(i).get(j));
                }

                if((j > n/2) && (j < n) && (i > m/2) && (i < m)){
                    quad.get(3).add(mx.get(i).get(j));
                }
            }
        }

        if(quadrante == Quadrante.PRIMEIRO){
            return quad.get(0);
        }
        else if(quadrante == Quadrante.SEGUNDO){
            return quad.get(1);
        }
        else if(quadrante == Quadrante.TERCEIRO){
            return quad.get(2);
        }
        else if(quadrante == Quadrante.QUARTO){
            return quad.get(3);
        }else{
            return null;
        }   
    }



}
