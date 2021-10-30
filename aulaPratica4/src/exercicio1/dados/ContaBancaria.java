package exercicio1.dados;

public class ContaBancaria {
    private int cpf;
    protected float saldo;

    ContaBancaria(){
        saldo = 0;
    }

	public int getCpf() {
		return this.cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

    public boolean sacar (float valor){
        if((saldo - valor) <0){
            return false;
        }else{
            saldo -= valor;
            return true;
        }
    }

    public String gerarExtrato(){
        String extrato = new String();

        extrato += "Saldo de R$ "+this.saldo;

        return extrato;
    }
}
