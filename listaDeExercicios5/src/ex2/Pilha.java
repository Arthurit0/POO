package ex2;

import java.util.LinkedList;
import java.util.List;

import ex2.exceptions.PilhaCheiaException;
import ex2.exceptions.PilhaVaziaException;

public abstract class Pilha<T>{
    private int limite;
    List<T> elementos = new LinkedList<T>();

    public Pilha(int limite){
        this.limite = limite;
    }

    public int getLimite() {
        return this.limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public List<T> getElementos(){
        return elementos;
    }

    public void inserir(T objeto) throws PilhaCheiaException{
        if(elementos.size() < limite){
            elementos.add(objeto);
        }else{
            throw new PilhaCheiaException("O limite foi atingido! ");
        }
    }

    public T remover() throws PilhaVaziaException{
        if(!(elementos.isEmpty())){

            T rtrn = elementos.get(0);
            elementos.remove(0);

            return rtrn;
        }else{
            throw new PilhaVaziaException("Não há elementos na lista! ");
        }
    }



}
