package exemplo.dados;

public class Endereco {
    private int id;
    private String rua;
    private int numero;
    private String cidade;
    private int idPessoa;

    public Endereco(int id, String rua, int numero, String cidade) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdPessoa() {
        return this.idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String toString() {
        String str = "";

        str += "ID do Endereço: "+getId()+", Rua: "+getRua()+", Número: "+getNumero()+", Cidade: "+getCidade();

        return str;
    }

}
