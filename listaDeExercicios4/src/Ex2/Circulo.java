package Ex2;

public class Circulo extends FormaGeometrica {

    public Circulo(){

    }

    public Circulo(int raio){
        setRaio(raio);
    }


    public void setRaio(int valor){
        medida1 = valor;
        medida2 = medida1*2;
    }

    public int calcularArea() {
        int area;

        area = (int) Math.PI*((int) Math.pow(medida1, 2));
        
        return area;
    }

    public int calcularPerimetro() {
        int perimetro;

        perimetro = (int) Math.PI*((int) Math.pow(medida2, 2));

        return perimetro;
    }
    
    public String toString() {
        String str = "";

        str += "Raio: "+medida1+", Diâmetro: "+medida2;
        str += ",\nÁrea: "+calcularArea()+", Perímetro: "+calcularPerimetro()+";";

        return str;
    }
}
