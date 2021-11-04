package ex1e2;

public class Revista {
    private String nome;
    private String genero;
    private String editora;

    Revista(){

    }

    public Revista(String nome, String genero, String editora){
        setNome(nome);
        setGenero(genero);
        setEditora(editora);
    }

    public Revista(String nome){
        setNome(nome);
        setGenero("Não definido");
        setEditora("Não definida");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean equals(Revista revista){
        if(revista instanceof Revista){
            Revista test = (Revista) revista;

            if((test.getNome() == this.getNome())&&
              (test.getGenero() == this.getGenero())&&
              (test.getEditora() == this.getEditora())){
                return true;
              }
        }
        
        return false;
    }

    public String toString(){
        String str = "";

        str += "Nome do Produto: "+this.nome;
        str += "\nGenero da Revista: "+this.genero;
        str += "\nEditora: "+this.editora;

        return str;

    }

}
