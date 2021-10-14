package exercicio1.dados;

public class Grupo {
    private Pessoa[] pessoas = new Pessoa[5];
    private int numeroPessoas = 0;

    public Grupo(){

    }

    public void setPessoa(Pessoa p){
        if (this.numeroPessoas<5){
            pessoas[this.numeroPessoas] = p;
            this.numeroPessoas++;
        }
    }

    public Pessoa[] getPessoas(){
        return pessoas;
    }

    public void ordena(){
        for (int i=0; i<5; i++){
            for (int j= i + 1; j<5; j++){
                if (this.pessoas[j].calculaIMC()>this.pessoas[i].calculaIMC()){
                    Pessoa temp = this.pessoas[j];
                    this.pessoas[j] = this.pessoas[i];
                    this.pessoas[i] = temp;
                }
            }
        }
    }
}
