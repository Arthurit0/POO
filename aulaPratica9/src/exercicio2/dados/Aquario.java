package exercicio2.dados;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float calculaEspaco() {
        return super.calculaEspaco()*altura;
    }

    public boolean adicionarAnimal(Animal animal) {
        if(espacoDisponivel() >= (animal.calculaEspacoOcupado()*0.7)){
            if(animal instanceof Peixe){
                Peixe peixe = (Peixe) animal;
                if((getTemperatura() <= peixe.getTemperaturaIdeal()+3)
                &&(getTemperatura() >= peixe.getTemperaturaIdeal()-3)){
                    this.animais.add(animal);
                
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public String toString() {
        return super.toString()+", Altura: "+this.altura+"\nTemperatura: "+this.temperatura;
    }

    public String toStringAnimais(){
        if (animais.size()>0){
            String str = "=> Peixes Alocados:\n";

            for(int i=0; i<animais.size(); i++){
                str += "\n==================================================\n";
                str += animais.get(i);
            }

            str += "\n==================================================\n";

            return str;
        }

        return "Vazio\n";
    }

}
