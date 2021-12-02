package Ex1;

public class Passaro extends Animal {

    public Passaro(){

    }

    public Passaro(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String emitirSom() {
        return this.nome+": Piupiu!";
    }
    
}
