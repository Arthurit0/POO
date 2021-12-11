package ex3;

public class Video extends Arquivo{
    Qualidade qualidade;

    public Video(String nome) throws NomeInvalidoException {
        super(nome);
        setExtensao(".mp4");
    }

    public Qualidade getQualidade() {
        return this.qualidade;
    }

    public void setQualidade(Qualidade qualidade) {
        if(qualidade.getQualidade() == 240 || 
           qualidade.getQualidade() == 360 || 
           qualidade.getQualidade() == 720 || 
           qualidade.getQualidade() == 1024){
               this.qualidade = qualidade;
        }
    }

    public String toString() {
        String str = "";

        str += "\t"+getNome()+getExtensao();
        str += "\n\tQualidade: "+qualidade.getQualidade()+"p";

        return str;
    }
    
}
