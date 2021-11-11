package exercicio.dados;

public class Contato {
    private String nome;
    private int telefone;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public boolean equals(Object o){
        Contato c = (Contato) o;
        if(this.telefone == c.getTelefone()){
            return true;
        } else{
            return false;
        }
    }

    public String toString() {
        String str = "";

        str += "- "+this.nome+": "+this.telefone;

        return str;
    }

}