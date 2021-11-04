package ex1e2;

public class Movel {
    private String nome;
    private String material;
    private String fabricante;

    Movel(){

    }

    public Movel(String nome, String material, String fabricante){
        setNome(nome);
        setMaterial(material);
        setFabricante(fabricante);
    }

    public Movel(String nome){
        setNome(nome);
        setMaterial("Não definido");
        setFabricante("Não definida");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public boolean equals(Movel movel){
        if(movel instanceof Movel){
            Movel test = (Movel) movel;

            if((test.getNome() == this.getNome())&&
              (test.getMaterial() == this.getMaterial())&&
              (test.getFabricante() == this.getFabricante())){
                return true;
              }
        }
        
        return false;
    }

    public String toString(){
        String str = "";

        str += "Nome do Produto: "+this.nome;
        str += "\nMaterial do Móvel: "+this.material;
        str += "\nFabricante: "+this.fabricante;

        return str;

    }

}
