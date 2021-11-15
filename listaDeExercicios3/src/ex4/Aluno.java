package ex4;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private int idade;
    private List<Double> notas = new ArrayList<Double>();

    public Aluno(){

    }

    public Aluno(String nome, int idade, double N1, double N2, double N3, double N4, double N5){
        this.nome = nome;
        this.idade = idade;
        notas.add(N1);
        notas.add(N2);
        notas.add(N3);
        notas.add(N4);
        notas.add(N5);
    }

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

    public List<Double> getNotas() {
        return this.notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public double calcularMedia(){
        double media = 0;

        for (Double nota : notas) {
            media += nota;
        }

        return media/5;
    }

    public String toString() {
        String str = "";

        str += this.nome;
        str += ", Idade: "+this.idade;
        str += ", Notas: ";

        for (int i = 0; i < this.notas.size(); i++) {
            str += this.notas.get(i);
            if(i != (this.notas.size()-1)){
                str += ", ";
            }
        }

        str += "; Média: "+calcularMedia();

        return str;
    }

}
