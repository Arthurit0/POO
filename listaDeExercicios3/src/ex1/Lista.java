package ex1;

import java.util.*;

public class Lista {
    private Map<String, List<Pessoa>> listaPessoas = new TreeMap<String, List<Pessoa>>();

    public Lista(){
        List<Pessoa> idosos = new LinkedList<Pessoa>();
        List<Pessoa> adolescentes = new LinkedList<Pessoa>();
        List<Pessoa> criancas = new LinkedList<Pessoa>();
        List<Pessoa> jovens = new LinkedList<Pessoa>();
        List<Pessoa> adultos = new LinkedList<Pessoa>();

        listaPessoas.put("1 até 12: crianças;", criancas);
        listaPessoas.put("13 até 18: adolescentes;", adolescentes);
        listaPessoas.put("19 até 25: jovens;", jovens);
        listaPessoas.put("26 até 59: adultos;", adultos);
        listaPessoas.put("60 ou mais: idosos;", idosos);

    }

    void adicionaPessoa(Pessoa pessoa){
        if((pessoa.getIdade() > 0)&&(pessoa.getIdade() <= 12)){
            listaPessoas.get("1 até 12: crianças;").add(pessoa);
            listaPessoas.get("1 até 12: crianças;").sort(Comparator.comparing(Pessoa::getNome));
            

        }else if((pessoa.getIdade() > 12) && (pessoa.getIdade() <= 18)){
            listaPessoas.get("13 até 18: adolescentes;").add(pessoa);
            listaPessoas.get("13 até 18: adolescentes;").sort(Comparator.comparing(Pessoa::getNome));

        }else if((pessoa.getIdade() > 18) && (pessoa.getIdade() <= 25)){
            listaPessoas.get("19 até 25: jovens;").add(pessoa);
            listaPessoas.get("19 até 25: jovens;").sort(Comparator.comparing(Pessoa::getNome));

        }else if((pessoa.getIdade() > 25) && (pessoa.getIdade() <=59)){
            listaPessoas.get("26 até 59: adultos;").add(pessoa);
            listaPessoas.get("26 até 59: adultos;").sort(Comparator.comparing(Pessoa::getNome));


        }else if((pessoa.getIdade() > 59)){
            listaPessoas.get("60 ou mais: Idosos").add(pessoa);
            listaPessoas.get("60 ou mais: Idosos").sort(Comparator.comparing(Pessoa::getNome));


        }
    }

    public Map<String, List<Pessoa>> getLista(){
        return this.listaPessoas;
    }

}
