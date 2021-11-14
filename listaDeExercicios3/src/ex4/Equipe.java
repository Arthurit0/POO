package ex4;

import java.util.ArrayList;
import java.util.List;

public class Equipe<T> {
    private String nome;
    private List<T> equipeAlunos = new ArrayList<T>();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<T> getEquipeAlunos() {
        return this.equipeAlunos;
    }

    public void setEquipeAlunos(List<T> equipeAlunos) {
        this.equipeAlunos = equipeAlunos;
    }

    public String toString() {
        String str = "";

        str += "A "+this.nome+" possui como membros:\n\n";

        for (int i = 0; i < equipeAlunos.size(); i++) {
            str += "Membro nº"+(i+1)+": "+equipeAlunos.get(i);
            if(i != (equipeAlunos.size()-1)){
                str += ",\n";
            }
        }

        return str;
    }
}
