package exercicio2.dados;

public class Dono {
    private String nome;
    private Endereco endereco;
    private int cpf;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String toString(){
        String dadosDono = "";

        dadosDono += "=> Nome do Dono: "+ this.nome +"\n=> CPF: "+ this.cpf;

        if(this.endereco != null){
            dadosDono += "\n" + this.endereco;
        }

        return dadosDono;
    }

}
