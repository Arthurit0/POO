package ex2;

public class Processo {
    private int id;
    private String nome;

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

    public String toString() {
        String str = "";

        str += "Processo de ID "+getId()+": "+getNome();

        return str;
    }

    
}
