package Ex2;

public class Losango extends FormaGeometrica {

    public Losango(){

    }

    public Losango(int d, int D){
        medida1 = d;
        medida2 = D;
    }

    public void setd(int valor){
        medida1 = valor;
    }

    public void setD(int valor){
        medida2 = valor;
    }

    public int calcularArea() {
        int area;

        area = (medida1*medida2)/2;

        return area;
    }

    public int calcularPerimetro() {
        int perimetro;

        perimetro = 4*((int) Math.sqrt((Math.pow(medida2, 2))/4+(Math.pow(medida1, 2))/4));

        return perimetro;
    }

    public String toString() {
        String str = "";

        str += "Diagonal menor: "+medida1+", Diagonal maior: "+medida2;
        str += ",\nÁrea: "+calcularArea()+", Perímetro: "+calcularPerimetro()+";";

        return str;
    }
    
}
