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

    public String toString() {
        return super.toString()+", Altura: "+this.altura+"\nTemperatura: "+this.temperatura;
    }

    public String toStringAnimais(){
        if (animais.size()>0){
            String str = "\n=> Peixes Alocados:\n";

            for(int i=0; i<animais.size(); i++){
                str += "\n================================================\n";
                str += animais.get(i);
            }

            str += "\n================================================\n";

            return str;
        }

        return "\n-> Aquário Vazio\n";
    }

}
