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

    public boolean adicionarAnimal(Peixe peixe) {
        if(espacoDisponivel() >= (peixe.calculaEspacoOcupado()*0.7)){
            if(peixe instanceof Peixe){
                animais.add(peixe);
                return true;
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

}
