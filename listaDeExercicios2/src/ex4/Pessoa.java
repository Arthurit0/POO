package ex4;

public class Pessoa {
    private String nome;
    private int nmrSorteio;

    public Pessoa(){
        
    }

    public Pessoa(String nome, int nmr){
        setNome(nome);
        setNmrSorteio(nmr);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNmrSorteio() {
        return this.nmrSorteio;
    }

    public void setNmrSorteio(int nmrSorteio) {
        this.nmrSorteio = nmrSorteio;
    }

    public String toString() {
        String str = "";

        str += this.nome+", número de sorteio "+this.nmrSorteio;

        return str;
    }


}
