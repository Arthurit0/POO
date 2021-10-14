package exercicio2.dados;

public class Veterinario {
    private String nome;
    private float salario;
    private Endereco encereco;
    private Animal[] animais = new Animal[5];
    private int quantidadeAnimais = 0;

    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Endereco getEncereco() {
        return this.encereco;
    }

    public void setEncereco(Endereco encereco) {
        this.encereco = encereco;
    }

    public Animal[] getAnimais() {
        return this.animais;
    }

    public void setAnimais(Animal animal) {
        if(this.quantidadeAnimais<5){
        
        this.animais[quantidadeAnimais] = animal;
        quantidadeAnimais++;
        }else{
            System.out.println("ERRO: Vetor de animais está cheio!");
        }
    }

    public int getQuantidadeAnimais() {
        return this.quantidadeAnimais;
    }

    public void setQuantidadeAnimais(int quantidadeAnimais) {
        this.quantidadeAnimais = quantidadeAnimais;
    }

    public String toString(){
        String dadosVet = "";

        dadosVet += "=> Nome: "+ this.nome;
        dadosVet += "\n=> Salário: R$ "+ this.salario;

        if (this.encereco != null){
            dadosVet += "\n"+ this.encereco;
        }

        return dadosVet;
    }

}
