package SistemaViagem.dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private Boolean idaEVolta = false;
    private int poltrona;
    private Cidade origem;
    private Cidade destino;
    private Reserva volta;

    public int getNumReserva() {
        return this.numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public String getDataVoo() {
        return this.dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getHoraVoo() {
        return this.horaVoo;
    }

    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getClasseVoo() {
        return this.classeVoo;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }

    public void setIdaEVolta(Boolean idaEVolta) {
		this.idaEVolta = idaEVolta;
	}

    public Boolean getIdaEVolta() {
        return this.idaEVolta;
    }

    public int getPoltrona() {
        return this.poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public Cidade getOrigem() {
        return this.origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return this.destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public Reserva getVolta() {
        return this.volta;
    }

    public void setVolta(Reserva volta) {
        this.idaEVolta = true;
        this.volta = volta;
    }

    public String toString(){
        String rstr = "";

        rstr += "\n=> Número de reserva: "+this.numReserva;
        rstr += "\n=> Data de Voo: "+this.dataVoo+" às "+this.horaVoo;
        rstr += "\n=> Preço da Passagem: R$ "+this.preco;
        rstr += "\n=> Classe do Voo: "+this.classeVoo;
        if (idaEVolta){
            rstr += "\n=> Volta reservada: Sim";
        }else{
            rstr += "\n=> Volta reservada: Não";
        }
        rstr += "\n=> Nº da poltrona: "+this.poltrona;
        rstr += "\n===> Origem: "+this.origem;
        rstr += "\n===> Destino: "+this.destino;

        if(this.volta != null){
            rstr += "\n\nVolta:";
            rstr += "\n=> Número de reserva: "+this.volta.numReserva;
            rstr += "\n=> Data de Voo: "+this.volta.dataVoo+" às "+this.volta.horaVoo;
            rstr += "\n=> Preço da Passagem: R$ "+this.volta.preco;
            rstr += "\n=> Nº da poltrona: "+this.volta.poltrona;
        }

        return rstr;
    }

}
