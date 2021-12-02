package Ex2;

public class Trapezio extends FormaGeometrica {
    private int altura;

    public Trapezio(){

    }

    public Trapezio(int baseMenor, int baseMaior, int altura){
        medida1 = baseMenor;
        medida2 = baseMaior;
        this.altura = altura;
    }

    public void setBaseMenor(int valor){
        medida1 = valor;
    }

    public void setBaseMaior(int valor){
        medida2 = valor;
    }

    public void setAltura(int valor){
        altura = valor;
    }

    //A fórmula dada no exercício está errada, é a soma das bases e nao a subtração delas!
    public int calcularArea() {
        int area;

        area = ((medida2+medida1)*altura)/2;

        return area;
    }

    //Dificil calcular o perímetro sem o valor dos lados, afinal, não sabemos que tipo de trapézio é: retângulo, isósceles ou escaleno
    public int calcularPerimetro() {
        int perimetro, lado;

        lado = (int) Math.sqrt(Math.pow((medida2-medida1)/2, 2));

        perimetro = medida1+medida2+(lado*2);

        return perimetro;
    }
    
    public String toString() {
        String str = "";

        str += "Base menor: "+medida1+", Base maior: "+medida2+", Altura: "+altura;
        str += ",\nÁrea: "+calcularArea()+", Perímetro: "+calcularPerimetro()+";";

        return str;
    }
}
