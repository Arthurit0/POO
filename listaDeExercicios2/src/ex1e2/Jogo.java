package ex1e2;

public class Jogo {
    private String nome;
    private String genero;
    private String empresa;

    Jogo(){

    }

    public Jogo(String nome, String genero, String empresa){
        setNome(nome);
        setGenero(genero);
        setEmpresa(empresa);
    }

    public Jogo(String nome){
        setNome(nome);
        setGenero("Não definido");
        setEmpresa("Não definida");
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

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public boolean equals(Jogo jogo){
        if(jogo instanceof Jogo){
            Jogo test = (Jogo) jogo;

            if((test.getNome() == this.getNome())&&
              (test.getGenero() == this.getGenero())&&
              (test.getEmpresa() == this.getEmpresa())){
                return true;
              }
        }
        
        return false;
    }

    public String toString(){
        String str = "";

        str += "Nome do Produto: "+this.nome;
        str += "\nGênero do Jogo: "+this.genero;
        str += "\nEmpresa: "+this.empresa;

        return str;

    }

    
}
