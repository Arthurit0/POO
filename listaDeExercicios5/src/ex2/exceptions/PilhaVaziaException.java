package ex2.exceptions;

public class PilhaVaziaException extends Exception {
    public PilhaVaziaException(){

    }

    public PilhaVaziaException(String message){
        super(message);
    }
}
