package exceptions;

public class UsuarioNaoExisteException extends Exception{
    
    public UsuarioNaoExisteException(String message){
        super(message);
    }
}
