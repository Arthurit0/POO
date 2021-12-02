package exercicio2.exceptions;

public class TemperaturaInadequadaException extends Exception {
    public TemperaturaInadequadaException(){

    }

    public TemperaturaInadequadaException(String mensagem){
        super(mensagem);
    }
}
