package ex2;

import java.util.List;

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

    @Override
    public String toString() {
        String str = "";
        List<Processo> imprimeProcessos = processos.getElementos();

        str += "Juiz "+getNome()+", responsável pelos processos:\n\n";

        for (int i = 0; i < imprimeProcessos.size(); i++) {
            str += imprimeProcessos.get(i)+"\n";
        }

        return str;
    }

}
