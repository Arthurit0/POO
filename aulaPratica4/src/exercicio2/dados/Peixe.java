package exercicio2.dados;

public class Peixe extends Animal {
    private int temperaturaIdeal;

    public int getTemperaturaIdeal() {
        return this.temperaturaIdeal;
    }

    public void setTemperaturaIdeal(int temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public float calculaEspacoOcupado() {
        return super.calculaEspacoOcupado()*altura;
    }

    public String toString() {
        return super.toString()+"\nTemperatura Ideal: "+this.temperaturaIdeal;
    }
}
