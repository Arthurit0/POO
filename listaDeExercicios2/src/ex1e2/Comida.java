package ex1e2;

public class Comida {
    private String nome;
    private String tipo;
    private String validade;

    Comida(){
        
    }

    public Comida(String nome, String tipo, String validade){
        setNome(nome);
        setTipo(tipo);
        setValidade(validade);
    }

    public Comida(String nome){
        setNome(nome);
        setTipo("Não definido");
        setValidade("Desconhecida");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValidade() {
        return this.validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public boolean equals(Comida comida){
        if(comida instanceof Comida){
            Comida test = (Comida) comida;

            if((test.getNome() == this.getNome())&&
              (test.getTipo() == this.getTipo())&&
              (test.getValidade() == this.getValidade())){
                return true;
              }
        }
        
        return false;
    }

    public String toString(){
        String str = "";

        str += "Nome do Produto: "+this.nome;
        str += "\nTipo de Alimento: "+this.tipo;
        str += "\nData de Validade: "+this.validade;

        return str;

    }

}
