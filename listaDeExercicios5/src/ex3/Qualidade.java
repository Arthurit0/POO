package ex3;

public enum Qualidade {
    QualidadeDe240p(240),
    QualidadeDe360p(360),
    QualidadeDe720p(720),
    QualidadeDe1024p(1024);

    private int qldd;

    Qualidade(int qldd){
        this.qldd = qldd;
    }

    public int getQualidade(){
        return qldd;
    }


}
