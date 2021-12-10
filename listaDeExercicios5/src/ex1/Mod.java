package ex1;

public class Mod implements IOperacaoInteira{

    public int executar(int valor1, int valor2) {
        int mod;
        
        mod = valor1 - ((valor1/valor2) * valor2);

        return mod;
    }
    
}
