package exercicio2.exceptions;

public class EspacoInsuficienteException extends Exception {
    public EspacoInsuficienteException(){

    }

    public EspacoInsuficienteException(String mensagem){
        super(mensagem);
    }
}
