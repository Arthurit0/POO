package exercicio2.exceptions;

public class AlocacaoInvalidaException extends Exception {
    public AlocacaoInvalidaException(){

    }

    public AlocacaoInvalidaException(String message){
        super(message);
    }
}
