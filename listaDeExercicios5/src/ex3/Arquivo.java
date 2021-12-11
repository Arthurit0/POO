package ex3;

public abstract class Arquivo {
    public String nome;
    public String extensao;

    public Arquivo(String nome) throws NomeInvalidoException{
        if(verificaValidade(nome)){
            setNome(nome);
        }else{
            throw new NomeInvalidoException("O nome não é válido! ");
        }
    }

    private boolean verificaValidade(String nome) {
        if(nome.length() > 10 && nome.length() < 256){

            for (int i = 0; i < nome.length(); i++) {
                if(nome.charAt(i) == '\n' || 
                   nome.charAt(i) == '[' ||
                   nome.charAt(i) == ']' ||
                   nome.charAt(i) == '(' ||
                   nome.charAt(i) == ')' ||
                   nome.charAt(i) == '\''||
                   nome.charAt(i) == '\"'){
                    return false;
                   }
            }
            return true;
        }else{
            return false;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExtensao() {
        return this.extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

}
