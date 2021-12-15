package exemplo.dados;

public class Pessoa {
    private int id;
    private String nome;
    private int cpf;
    private int telefone;
    private Endereco endereco;

    public Pessoa(int id, String nome, int cpf, int telefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        String str = "";

        str += "ID: "+getId()+", Nome: "+getNome()+", CPF: "+getCpf()+", Telefone: "+getTelefone()+";";
        str += "\n"+getEndereco();

        return str;
    }

}
