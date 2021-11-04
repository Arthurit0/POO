package ex3;

public class Imovel {
    private float largura;
    private float comprimento;
    private float valor;

    public float getLargura() {
        return this.largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float Area(){
        return this.comprimento * this.largura;
    }

    public String toString() {
       String str = "";

       str += "\nComprimento: "+this.comprimento;
       str += "\nLargura: "+this.largura;
       str += "\nÁrea: "+ Area();
       str += "\nValor: R$ "+this.valor;

       return str;
    }

}