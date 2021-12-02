package Ex1;

public class Gato extends Animal {

    public Gato(){

    }

    public Gato(String nome){
        this.nome = nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String emitirSom() {
        return this.nome+": Miaau!";
    }
    
}
