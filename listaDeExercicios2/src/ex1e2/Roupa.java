package ex1e2;

public class Roupa {
    private String nome;
    private String cor;
    private String marca;

    Roupa(){

    }

    public Roupa(String nome, String cor, String marca){
        setNome(nome);
        setCor(cor);
        setMarca(marca);
    }

    public Roupa(String nome){
        setNome(nome);
        setCor("Não definida");
        setMarca("Não definida");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean equals(Roupa roupa){
        if(roupa instanceof Roupa){
            Roupa test = (Roupa) roupa;

            if((test.getNome() == this.getNome())&&
              (test.getCor() == this.getCor())&&
              (test.getMarca() == this.getMarca())){
                return true;
              }
        }
        
        return false;
    }
    
    public String toString(){
        String str = "";

        str += "Nome do Produto: "+this.nome;
        str += "\nCor da roupa: "+this.cor;
        str += "\nMarca: "+this.marca;

        return str;

    }

}
