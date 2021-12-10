package ex3;

public enum Qualidade {
    Q240p(240),
    Q360p(360),
    Q720p(720),
    Q1024p(1024);

    private int qldd;

    Qualidade(int qldd){
        this.qldd = qldd;
    }

    public int getQualidade(){
        return qldd;
    }


}
