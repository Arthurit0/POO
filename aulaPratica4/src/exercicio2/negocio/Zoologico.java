package exercicio2.negocio;

import java.util.ArrayList;
import java.util.List;

import exercicio2.dados.*;

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
	

    public boolean alocarAnimal(Animal animal, Viveiro viveiro){
        
        return viveiro.adicionarAnimal(animal);

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
        List<Viveiro> viveiros = new ArrayList<Viveiro>();

        for(int i = 0; i<viveiros.size(); i++){
            if(!(viveiros.get(i) instanceof Aquario)){
                viveiros.add(viveiros.get(i));
            }
        }
        return viveiros;
    }



    
}
