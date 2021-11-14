package ex1;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String cidade;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String toString(){
        String str = "";

        str += " - "+this.nome+", "+this.idade+", "+this.cpf+", "+this.cidade+";";

        return str;

    }

}
