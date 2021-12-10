package ex2;

import ex2.exceptions.PilhaCheiaException;

public class Juiz {
    private String nome;
    Pilha<Processo> processos;

    public Juiz(int limite){
        processos = new Pilha<Processo>(limite){};
    }
        
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pilha<Processo> getProcessos() {
        return this.processos;
    }

    public void cadastrarProcesso(Processo processo) throws PilhaCheiaException{
        try {
            processos.inserir(processo);
        } catch (PilhaCheiaException e) {
            throw e;
        }
    }

}
