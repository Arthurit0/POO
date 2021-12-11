package ex3;

public class Musica extends Arquivo {
    private int duracao;

    public Musica(String nome) throws NomeInvalidoException {
        super(nome);
        setExtensao(".mp3");
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString() {
        String str = "";

        str += "\t"+getNome()+getExtensao();
        str += "\n\tDuracao: "+getDuracao()+" min";

        return str;
    }
    
}
