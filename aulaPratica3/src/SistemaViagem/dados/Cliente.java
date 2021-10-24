package SistemaViagem.dados;

public class Cliente {
    private long cpf;
    private String nome;
    private String endereco;
    private int telefone;
    private Reserva reservas[] = new Reserva[10];
    private int numReservas = 0;

	public int getNumReservas()
	{
		return this.numReservas;
	}

	public long getCpf() {
		return this.cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return this.telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Reserva[] getReservas() {
		return this.reservas;
	}

	public void setReservas(Reserva reserva) {
		if(numReservas<10){
		this.reservas[numReservas] = reserva;
        numReservas++;
		}else{
			System.out.printf("\nMáximo de reservas atingido!");
		}
	}

	public String toString(){
		String clstr = "";

		clstr += "\n=> CPF: "+this.cpf;
		clstr += "\n=> Nome: "+this.nome;
		clstr += "\n=> Endereço: "+this.endereco;
		clstr += "\n=> Telefone: "+this.telefone;

		return clstr;
	}

    
}
