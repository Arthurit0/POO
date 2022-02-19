package dados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gasto {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
    private int id;
    private String nome;
    private Date data = null;
    private String descricao;
    private float valor;
    private int id_categoria;
    private int id_usuario;

    public Gasto(){
    }

    public Gasto(String nome, String descricao, Date data, float valor, int id_categoria, int id_usuario){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.id_categoria = id_categoria;
        this.id_usuario = id_usuario;
    }

    public Gasto(int id, String nome, String descricao, String data, float valor, int id_categoria, int id_usuario) throws ParseException{
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = sdf.parse(data);
        this.valor = valor;
        this.id_categoria = id_categoria;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData(){
        return sdf.format(data);
    }

    public void setData(Date data){
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

    public int getCategoria() {
        return this.id_categoria;
    }

    public void setCategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String toString() {
        String str = "";
        
        str += "ID: "+this.id+", "+this.nome+", Data: "+getData()+", Valor: R$ "+this.valor+", Categoria: ";
        
        switch (id_categoria) {
            case 1:
                str += "Comida";
                break;

            case 2:
                str += "Lazer";
                break;

            case 3:
                str += "Educação";
                break;
            
            case 4:
                str += "Saúde";
                break;

            case 5:
                str += "Transporte";
                break;

            case 6:
                str += "Outros";
                break;

            default:
                str += "?";
                break;
        }

        str += "\nDescrição: "+this.descricao;

        return str;
    }

    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            Gasto obj = (Gasto) o;

            if((obj.id == this.id) 
                && (obj.nome.equals(this.nome)) 
                && (obj.data.equals(this.data)) 
                && (obj.valor == this.valor) 
                && (obj.id_categoria == this.id_categoria)
                && (obj.descricao.equals(this.descricao))){
                    return true;
            }
        }
        return false;
    }

}
