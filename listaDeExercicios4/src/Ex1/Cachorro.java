package Ex1;

public class Cachorro extends Animal {

    public Cachorro(){

    }

    public Cachorro(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String emitirSom() {
        return this.nome+": Au-Au!";
    }
    
}
