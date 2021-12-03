package exercicio2.dados;

import java.util.ArrayList;
import java.util.List;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected List<Animal> animais = new ArrayList<Animal>();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return this.largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float calculaEspaco(){
        return this.comprimento*this.largura;
    }

    private float espacoOcupado(){
        float espaco = 0;
        for(int i=0; i<animais.size(); i++){
            espaco += animais.get(i).calculaEspacoOcupado();
        }
        return espaco;
    }

    public float espacoDisponivel(){
        return (calculaEspaco()-espacoOcupado());
    }

    public void adicionarAnimal(Animal animal){
        animais.add(animal);
    }

    public List<Animal> getAnimais(){
        return this.animais;
    }

    public String toString() {
        String str = "";

        str += "Nome: "+this.nome;
        str += "\nComprimento: "+this.comprimento+", Largura: "+this.largura;

        return str;
    }

    public String toStringAnimais(){
        if (animais.size()>0){
            String str = "\n=> Animais Alocados:\n";

            for(int i=0; i<animais.size(); i++){
                str += "\n================================================\n";
                str += animais.get(i);
            }

            str += "\n================================================\n";

            return str;
        }

        return "\n-> Viveiro Vazio\n";
    }

}
