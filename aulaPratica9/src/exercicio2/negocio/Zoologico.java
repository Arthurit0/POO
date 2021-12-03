package exercicio2.negocio;

import java.util.ArrayList;
import java.util.List;

import exercicio2.dados.*;
import exercicio2.exceptions.AlocacaoInvalidaException;
import exercicio2.exceptions.EspacoInsuficienteException;
import exercicio2.exceptions.TemperaturaInadequadaException;

public class Zoologico {
    List<Animal> animais = new ArrayList<Animal>();
    List<Viveiro> viveiros = new ArrayList<Viveiro>();

	public List<Animal> getAnimais() {
		return this.animais;
	}

	public void cadastrarAnimais(Animal animal) {
		animais.add(animal);
    }

	public List<Viveiro> getViveiros() {
		return this.viveiros;
	}

	public void cadastrarViveiro(Viveiro viveiro) {
		viveiros.add(viveiro);
    }
	

    public void alocarAnimal(Animal animal, Viveiro viveiro) throws EspacoInsuficienteException, TemperaturaInadequadaException, AlocacaoInvalidaException{
        if(viveiro instanceof Aquario){//É um aquário
            Aquario aquario = (Aquario) viveiro;

            if(animal instanceof Peixe){
                Peixe peixe = (Peixe) animal;

                if(aquario.espacoDisponivel() >= (peixe.calculaEspacoOcupado()*0.7)){

                    if((aquario.getTemperatura() <= peixe.getTemperaturaIdeal()+3)
                    &&(aquario.getTemperatura() >= peixe.getTemperaturaIdeal()-3)){
                        aquario.adicionarAnimal(peixe);
                        cadastrarAnimais(peixe);

                    }else{//Temperatura não ideal
                        throw new TemperaturaInadequadaException("\nO aquário não possui a temperatura adequada para este peixe!\n");
                    }
                }else{//Não há espaço disponível
                    throw new EspacoInsuficienteException("\nNão há espaço disponível no aquário!\n");
                }
            }else{ //Não peixe no aquário
                throw new AlocacaoInvalidaException("\nUm animal que não é peixe não pode ser alocado em um aquário!\n");
            }

        }else{//É um viveiro

            if(!(animal instanceof Peixe)){
                if(viveiro.espacoDisponivel() >= (animal.calculaEspacoOcupado()*0.7)){
                    viveiro.adicionarAnimal(animal);
                    cadastrarAnimais(animal);

                }else{//Não há espaço disponível
                    throw new EspacoInsuficienteException("\nNão há espaço disponível no viveiro!\n");
                }
            }else{//Peixe em um viveiro
                throw new AlocacaoInvalidaException("\nUm peixe deve ser alocado em um aquário!\n");
            }
        }

    }

    public List<Aquario> getSoAquarios(){
        List<Aquario> aquarios = new ArrayList<Aquario>();

        for(int i = 0; i<viveiros.size(); i++){
            if(viveiros.get(i) instanceof Aquario){
                aquarios.add((Aquario)viveiros.get(i));
            }
        }
        return aquarios;
    }

    public List<Viveiro> getSoViveiros(){
        List<Viveiro> soViveiros = new ArrayList<Viveiro>();

        for(int i = 0; i<viveiros.size(); i++){
            if(!(viveiros.get(i) instanceof Aquario)){
                soViveiros.add(viveiros.get(i));
            }
        }
        return soViveiros;
    }



    
}
