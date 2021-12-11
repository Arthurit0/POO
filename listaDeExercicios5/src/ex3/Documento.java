package ex3;

public class Documento extends Arquivo{
    private String texto;

    public Documento(String nome) throws NomeInvalidoException {
        super(nome);
        setExtensao(".txt");
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String toString() {
        String str = "";

        str += "\t"+getNome()+getExtensao();

        return str;
    }
    
}
