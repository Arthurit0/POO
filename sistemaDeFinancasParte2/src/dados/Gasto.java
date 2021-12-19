package dados;

public class Gasto {
    private String nome;
    private Data data;
    private String descricao;
    private float valor;
    private Categorias categoria;

    public Gasto(){
    }

    public Gasto(String nome, String descricao, Data data, float valor, int categoria){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        setCategoria(categoria);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(int dia, int mes, int ano) {
        this.data = new Data(dia, mes, ano);
    }

    public void setData(Data data){
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Categorias getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) {
        if(categoria >= 0  && categoria < 6){
            this.categoria = Categorias.values()[categoria];
        }
    }

    public String toString() {
        String str = "";
        
        str += "Gasto: "+this.nome+", Data: "+this.data+", Valor: R$ "+this.valor+", Categoria: "+this.categoria+"\nDescrição: "+this.descricao;

        return str;
    }

}
