package SistemaViagem.negocio;
import SistemaViagem.dados.*;

public class ReservaPassagem {
    private Cidade cidades[] = new Cidade[20];
    private Cliente clientes[] = new Cliente[20];
    private int quantCidades = 0;
    private int quantClientes = 0;

	public int getQuantCidades() {
		return this.quantCidades;
	}

	public int getQuantClientes() {
		return this.quantClientes;
	}

    public void cadastrarCidade(Cidade cidade){
        if(quantCidades<cidades.length){
            cidades[quantCidades] = cidade;
            quantCidades++;
        }else{
            //Futuro throw-exception
            System.out.println("ERRO: Array de cidades está cheio!");
        }
    }

    public void cadastraCliente(Cliente cliente){
        if(quantClientes<clientes.length){
            clientes[quantClientes] = cliente;
            quantClientes++;
        }else{
            //Futuro throw-exception
            System.out.println("ERRO: Array de clientes está cheio!");
        }
    }

    public void reservarIda(Cliente cliente, Reserva reserva){
        for(int i = 0; i<quantClientes; i++){
            if(cliente.equals(clientes[i])){
                clientes[i].setReservas(reserva);
            }
        }
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta){
        Cliente c = new Cliente();
        for(int i = 0; i<quantClientes; i++){
            if(cliente.equals(clientes[i])){
                c = clientes[i];
                break;
            }
        }

        for (int i = 0; i<c.getNumReservas();i++){
            if(ida.equals(c.getReservas()[i])){
                c.getReservas()[i].setVolta(volta);
                break;
            }
        }
    }

    public Reserva[] mostrarReservas(int cpfCliente){
        Reserva nullReserva[] = new Reserva[0];

        for (int i=0; i<quantClientes; i++){
            if (clientes[i].getCpf() == cpfCliente){
                return clientes[i].getReservas();
            }
        }
        
        return nullReserva;
    }

    public Cliente[] mostrarClientes(){
        return this.clientes;
    }

    public Cidade[] mostrarCidades(){
        return this.cidades;
    }

    
}
