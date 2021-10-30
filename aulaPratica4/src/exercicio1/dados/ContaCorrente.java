package exercicio1.dados;

public class ContaCorrente extends ContaBancaria{
    
    ContaCorrente(){
        super();
    }

    public boolean depositar(float valor){
        this.saldo += valor;
        return true;
        
    }
}
