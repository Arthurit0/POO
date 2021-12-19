package exercicio.dados;

public class Contato {
    private int id;
    private String nome;
    private int telefone;

    public Contato(){

    }

    public Contato(int id, String nome, int telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        if((c.getNome().equals(this.nome)) && c.getTelefone() == this.telefone){
            return true;
        } else{
            return false;
        }
    }

    public String toString() {
        String str = "";

        str += "- ["+this.id+"]: "+this.nome+": "+this.telefone;

        return str;
    }

}